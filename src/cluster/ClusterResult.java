package cluster;

import java.util.List;

import org.tjucs.imgbow.Feature;

/**
 * è�šç±»ç»“æžœæ��è¿°
 * 
 * @author tess3ract <hty0807@gmail.com>
 */
public class ClusterResult {

    /* ä¸­å¿ƒç‚¹åˆ—è¡¨ */
    private List<Feature> centroids;

    /* å�„ä¸ªç‚¹æ‰€å±žçš„ç±»åˆ«åº�å�· */
    private List<Integer> belongs;

    public ClusterResult(List<Feature> centroids, List<Integer> belongs) {
        this.centroids = centroids;
        this.belongs = belongs;
    }

    /**
     * @return the centroids
     */
    public List<Feature> getCentroids() {
        return centroids;
    }

    /**
     * @param centroids
     *            the centroids to set
     */
    public void setCentroids(List<Feature> centroids) {
        this.centroids = centroids;
    }

    /**
     * @return the belongs
     */
    public List<Integer> getBelongs() {
        return belongs;
    }

    /**
     * @param belongs
     *            the belongs to set
     */
    public void setBelongs(List<Integer> belongs) {
        this.belongs = belongs;
    }

}
