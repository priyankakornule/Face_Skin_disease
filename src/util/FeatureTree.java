package util;

import org.tjucs.imgbow.Feature;

/**
 * ç‰¹å¾�å�‘é‡�æ ‘ (KDTree)
 * 
 * @author tess3ract <hty0807@gmail.com>
 */
public class FeatureTree extends KDTree.Euclidean<Integer> {

    public FeatureTree() {
        super(Feature.DIMENSION);
    }

    private double[] getValue(Feature feature) {
        double[] location = new double[Feature.DIMENSION];
        int[] values = feature.getValues();
        for (int i = 0; i < Feature.DIMENSION; i++) {
            location[i] = values[i];
        }
        return location;
    }

    public void add(int payload, Feature feature) {
        this.addPoint(getValue(feature), payload);
    }

    public Integer queryNearest(Feature feature) {
        return this.nearestNeighbours(getValue(feature), 1).get(0).payload;
    }
}
