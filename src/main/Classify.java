package main;

import java.util.List;
import org.tjucs.imgbow.Feature;
import org.tjucs.imgbow.Instance;
import org.tjucs.imgbow.InstanceGenerator;
import org.tjucs.imgbow.Model;
import org.tjucs.imgbow.TrainResult;
import org.tjucs.imgbow.feature.FeatureMaker;
import org.tjucs.imgbow.feature.SIFTFeatureMaker;
import org.tjucs.imgbow.util.ClassifyUtils;
import org.tjucs.imgbow.util.SerializationUtils;

import com.algorithm.NaiveBayes;

import weka.classifiers.Classifier;


public class Classify {

    private static FeatureMaker featureMaker = new SIFTFeatureMaker();

    public static void main(String[] args) throws Exception {
    	//String inputImg = "C://Gayatri_new//Skin_disease//Image//TestSet//06.jpg";
    	String inputImg ="E://Final Project//Face_Skin_disease//Image//TrainSet//10-1.jpg";
      // String inputModel = "C://Gayatri_new//Skin_disease//data.out";
       String inputModel ="E://Final Project//Face_Skin_disease//data.out";
       Model model = (Model) SerializationUtils.loadObject(inputModel);
        Classifier classifier = model.getClassifier();
        String[] categories = model.getCategories();
      
        
        InstanceGenerator instanceGenerator = new InstanceGenerator();
        List<Feature> features = featureMaker.getFeatures(inputImg);
      //  System.out.println(features);
        Instance instance = instanceGenerator.getInstance(features,model.getWords());
      //  System.out.println(instance);

        double value = classifier.classifyInstance(ClassifyUtils.getWekaInstance(instance));
        String category = categories[(int) value];
        System.out.println(category);

    
    }
    
    
     public static String classify1(String name) throws Exception
     {
     
    	 
    	// String inputImg = "C:\\Gayatri_new\\Skin_disease\\Image\\TestSet\\"+name;
    	 String inputImg ="E:\\Final Project\\Face_Skin_disease\\Image\\TestSet\\"+name;
    	 
       //   String inputModel = "C:\\Gayatri_new\\Skin_disease\\data.out";
          String inputModel = "E:\\Final Project\\Face_Skin_disease\\data.out";
         Model model = (Model) SerializationUtils.loadObject(inputModel);
         Classifier classifier = model.getClassifier();
         String[] categories = model.getCategories();

         
         InstanceGenerator instanceGenerator = new InstanceGenerator();
         List<Feature> features = featureMaker.getFeatures(inputImg);
        // System.out.println(features);
         Instance instance = instanceGenerator.getInstance(features,model.getWords());
         System.out.println("freq==1"+instance);
         System.out.println("freq==1"+instance.getFreq().length);
 
         // using euclidean distance
         double ady2[]=instance.getFreq();
        String category=NaiveBayes.getclassification(ady2);
       
        
        //using weka 
        /*double value = classifier.classifyInstance(ClassifyUtils.getWekaInstance(instance));
         String category = categories[(int) value];
         System.out.println(category);
*/
    	 return category;
         
     }

}
