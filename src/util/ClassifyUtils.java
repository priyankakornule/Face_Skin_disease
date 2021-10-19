package util;

import org.tjucs.imgbow.Instance;

import weka.classifiers.Classifier;
import weka.core.SparseInstance;

/**
 * åˆ†ç±»ç¨‹åº�è¾…åŠ©ç±»
 * 
 * @author tess3ract <hty0807@gmail.com>
 */
public class ClassifyUtils {

    public static Classifier loadClassifier(String input) throws Exception {
        return (Classifier) SerializationUtils.loadObject(input);
    }

    public static weka.core.Instance getWekaInstance(Instance instance) {
        SparseInstance spi = new SparseInstance(0.0f, instance.getFreq());
        return spi;
    }

}
