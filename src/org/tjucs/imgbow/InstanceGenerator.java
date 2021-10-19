package org.tjucs.imgbow;

/**
 * @author tess3ract <hty0807@gmail.com>
 */
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.tjucs.imgbow.cluster.Cluster;
import org.tjucs.imgbow.cluster.ClusterResult;
import org.tjucs.imgbow.cluster.KMeansCluster;
import org.tjucs.imgbow.feature.FeatureMaker;
import org.tjucs.imgbow.feature.SIFTFeatureMaker;


public class InstanceGenerator {

    private static final int PARTITION = 80;

    private FeatureMaker featureMaker = new SIFTFeatureMaker();

    private Cluster cluster = new KMeansCluster();

    private String[] categories;

    public InstanceGenerator() {}

    public InstanceGenerator(String[] categories) {
        this.categories = categories;
    }

    /**
     * 得到样本文件列表
     * 
     * @param base
     * @param start
     * @param end
     * @return
     * @throws IOException
     */
    public List<Sample> getSamples(String base, int start, int end)
            throws IOException {
        List<Sample> samples = new ArrayList<Sample>();
        for (String cate: categories) {
            int count = 0;
            System.out.println(File.separator);
            File dir = new File(base + File.separator + cate);
            File files[] = dir.listFiles();
            if (files == null) {
                throw new IOException("cannot find category " + cate);
            }
            for (int i = 0; i < files.length; i++) {
                if (!files[i].isDirectory()
                        && files[i].getName().contains(".jpg")) {
                    count++;
                    if (count > start)
                        samples.add(new Sample(files[i].getAbsolutePath(), cate));
                    if (count >= end)
                        break;
                }
            }
        }
        return samples;
    }

    /**
     * 
     * @param samples
     * @return
     * @throws IOException
     */
    private Map<String, List<Feature>> getFeatures(List<Sample> samples)
            throws IOException {
        List<Feature> bow = new ArrayList<Feature>();
        Map<String, List<Feature>> allFeatures = new HashMap<String, List<Feature>>();
        for (Sample sample: samples) {
            String key = sample.getPath();
            System.out.println("generating feature from " + key);
            try {
                List<Feature> features = featureMaker.getFeatures(key);
                if (features == null || features.size() == 0) {
                    throw new Exception("no feature found");
                }
                bow.addAll(features);
                allFeatures.put(key, features);
            } catch (Exception e) {
                System.err.println("failed to sample " + key + ": "
                        + e.getMessage());
            }
        }
        allFeatures.put("bow", bow);
        return allFeatures;
    }

    /**
     * 
     * @param bow
     * @return
     */
    private List<Feature> calcDict(List<Feature> bow) {
        System.out.println("bow size: " + bow.size());
        ClusterResult clusterResult = cluster.getSets(bow, PARTITION);
        return clusterResult.getCentroids();
    }

    /**
     * 
     * @param features
     * @param dict
     * @return
     */
    public Instance getInstance(List<Feature> features, List<Feature> dict) {
        int dictSize = dict.size();
        int[] counts = new int[dictSize];
        for (int i = 0; i < features.size(); i++) {
            int nearest = -1;
            double nearestDist = Double.MAX_VALUE;
            for (int j = 0; j < dictSize; j++) {
                double dist = dict.get(j).distance(features.get(i));
                if (dist < nearestDist) {
                    nearestDist = dist;
                    nearest = j;
                }
            }
            counts[nearest]++;
        }
        double[] freq = new double[dictSize];
        for (int i = 0; i < dictSize; i++) {
            freq[i] = (double) counts[i] / features.size();
        }
        return new Instance(freq);
    }

    /**
     * 
     * @param imgBase
     * @param cateSample
     * @return
     * @throws Exception
     */
    public TrainResult train(String imgBase, int cateSample) throws Exception {
        List<Sample> samples = getSamples(imgBase, 0, cateSample);
        Map<String, List<Feature>> allFeatures = getFeatures(samples);
        List<Feature> bow = allFeatures.get("bow");
        List<Feature> dict = calcDict(bow);
        List<Instance> instances = new ArrayList<Instance>();
        for (Sample sample: samples) {
            List<Feature> features = allFeatures.get(sample.getPath());
            if (features == null) {
                continue;
            }
            Instance instance = getInstance(features, dict);
            instance.setImage(sample.getPath());
            instance.setCategory(sample.getCategory());
            instances.add(instance);
        }
        return new TrainResult(instances, dict);
    }

    public void dumpArff(List<Instance> instances, String output)
            throws IOException {
        BufferedWriter br = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(new File(output))));
        br.write("@relation features\n");
        for (int i = 0; i < PARTITION; i++) {
            br.write("@attribute dimension" + i + " numeric\n");
        }
        br.write("@attribute class {");
        for (int i = 0; i < categories.length; i++) {
            if (i > 0)
                br.write(",");
            br.write(categories[i]);
        }
        br.write("}\n");
        br.write("@data\n");
        for (Instance instance: instances) {
            String tmp = "";
            double[] freq = instance.getFreq();
            for (int i = 0; i < freq.length; i++) {
                tmp += freq[i] + ",";
            }
            tmp += instance.getCategory();
            tmp += "\n";
            br.write(tmp);
        }
        br.close();
    }
}
