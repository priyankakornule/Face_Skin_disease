package cluster;

import java.util.List;

import org.tjucs.imgbow.Feature;


public interface Cluster {

    /* run clustering in features */
    public ClusterResult getSets(List<Feature> features, int partition);

}
