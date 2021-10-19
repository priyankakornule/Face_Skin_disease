package main;

import java.util.List;

import org.tjucs.imgbow.Feature;
import org.tjucs.imgbow.Instance;
import org.tjucs.imgbow.InstanceGenerator;
import org.tjucs.imgbow.Model;
import org.tjucs.imgbow.TrainResult;
import org.tjucs.imgbow.util.ClassifyUtils;
import org.tjucs.imgbow.util.SerializationUtils;

import weka.classifiers.Classifier;
import weka.classifiers.functions.MultilayerPerceptron;

/**
 * 
 * @author tess3ract <hty0807@gmail.com>
 */
public class Train {

    public static void main(String[] args) throws Exception {
            System.out.println("Usage: Train <img_base> <categories> <cate_sample> <output_arff> <output_classifier> <output_model>");
     //   String imgBase = "C:\\Gayatri_new\\Skin_disease\\Image\\TuneSet\\";
        
        String imgBase = "E:\\Final Project\\Face_Skin_disease\\Image\\TuneSet\\";
       String categories="Herpes_zoster_shingles,Hives,Pemphigus_vulgaris,Staphylococcal_scalded_skin_syndrome,Stevens-Johnson_syndrome,Toxic_epidermal_necrolysis,Toxic_shock_syndrome,OTHER";
        int cateSample =450;
        String outputArff = "data/output/classify.arff";
        String outputClassifier = "NB";
        String outputModel = "data.out";
        InstanceGenerator instanceGenerator = new InstanceGenerator(categories.split(","));
        TrainResult trainResult = instanceGenerator.train(imgBase, cateSample);
        List<Instance> instances = trainResult.getInstances();
        System.out.println("dumping arff to " + outputArff);
        instanceGenerator.dumpArff(instances, outputArff);
        System.out.println("running cross-validation using MLP");
        String arguments = "-t " + outputArff + " -d " + outputClassifier+ " -L 0.3 -M 0.2 -N 500 -V 0 -S 0 -E 20 -H a";
        MultilayerPerceptron.main(arguments.split(" "));

        List<Feature> words = trainResult.getWords();
        Classifier classifier = ClassifyUtils.loadClassifier(outputClassifier);
        Model model = new Model(categories.split(","), words, classifier);
        SerializationUtils.dumpObject(outputModel, model);
        System.out.println("model saved as " + outputModel);
    }
}
