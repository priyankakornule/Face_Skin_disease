package feature;

import java.io.IOException;
import java.util.List;

import org.tjucs.imgbow.Feature;


public interface FeatureMaker {

    /* generate features from specified img */
    public List<Feature> getFeatures(String img) throws IOException;

}
