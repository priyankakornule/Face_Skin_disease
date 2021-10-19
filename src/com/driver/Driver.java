package com.driver;

import static com.cnn.ActivationFunction.SIGMOID;

import com.cnn.ConvolutionLayer;
import com.cnn.ConvolutionalNeuralNetwork;
import com.cnn.PoolingLayer;
import com.data.DataSet;

import main.Classify;

public class Driver {

	public static final boolean VERBOSE = true;

	private static int imageSize = 32;

	private static double eta = .01;
	
	public static String main(String name) throws Exception {

			
			
			String trainDirectory="E://Final Project//Face_Skin_disease//Image//TrainSet//";
			String tuneDirectory="E://Final Project//Face_Skin_disease//Image//TuneSet//";
			String testDirectory="E://Final Project//Face_Skin_disease//Image//TestSet//";
			
			
			
			
			
			DataSet.setImageSize(imageSize);
			DataSet trainSet=new DataSet(trainDirectory);
			DataSet tuneSet=new DataSet(tuneDirectory);
			DataSet testSet=new DataSet(testDirectory);
			
			ConvolutionalNeuralNetwork cnn = ConvolutionalNeuralNetwork.builder().setInputHeight(imageSize).setInputWidth(imageSize)
					.appendConvolutionLayer(ConvolutionLayer.newBuilder().setConvolutionSize(3, 5, 5).setNumConvolutions(20).build())
					.appendPoolingLayer(PoolingLayer.newBuilder().setWindowSize(2, 2).build())
					.appendConvolutionLayer(ConvolutionLayer.newBuilder().setConvolutionSize(1, 5, 5).setNumConvolutions(20).build())
					.appendPoolingLayer(PoolingLayer.newBuilder().setWindowSize(2, 2).build())
					.appendConvolutionLayer(ConvolutionLayer.newBuilder().setConvolutionSize(1, 3, 3).setNumConvolutions(20).build())
					.setFullyConnectedDepth(1).setFullyConnectedWidth(300).setFullyConnectedActivationFunction(SIGMOID)
					.setLearningRate(eta).setMaxEpochs(30).build();

			
			
			
			System.out.println("******\tDeep CNN constructed." + " The structure is described below.\t******");
			System.out.println(cnn);

			// train CNN3
			cnn.train(trainSet, tuneSet, testSet);
			String prd = Classify.classify1(name);
			System.out.println("prediction ===== >"+prd);
	
			
			
			//System.out.println("******\tDeep CNN training has begun." + " Updates will be provided after each epoch.\t******");
		
			// cnn.train1(testSet);
			//System.out.println("\n******\tDeep CNN testing has begun.\t******");
			// cnn.test(testSet, true);
			System.out.println(cnn.test(testSet, true) + "% accuracy");
			return prd;
		}
	
	public static double[] main2() {

		/*String trainDirectory="C://Gayatri_new//Skin_disease//Image//TrainSet//";
		String tuneDirectory="C://Gayatri_new//Skin_disease//Image//tuneSet//";
		String testDirectory="C://Gayatri_new//Skin_disease//Image//TestSet//";
		*/
		
		
		
		String trainDirectory="E://Final Project//Face_Skin_disease//Image//TrainSet//";
		String tuneDirectory="E://Final Project//Face_Skin_disease//Image//TuneSet//";
		String testDirectory="E://Final Project//Face_Skin_disease//Image//TestSet//";
		
		
		// load data
		DataSet.setImageSize(imageSize);
		DataSet trainSet = new DataSet(trainDirectory);
		DataSet tuneSet = new DataSet(tuneDirectory);
		DataSet testSet = new DataSet(testDirectory);

		// build CNN
		ConvolutionalNeuralNetwork cnn = ConvolutionalNeuralNetwork.builder().setInputHeight(imageSize).setInputWidth(imageSize)
				.appendConvolutionLayer(ConvolutionLayer.newBuilder().setConvolutionSize(3, 5, 5).setNumConvolutions(20).build())
				.appendPoolingLayer(PoolingLayer.newBuilder().setWindowSize(2, 2).build())
				.appendConvolutionLayer(ConvolutionLayer.newBuilder().setConvolutionSize(1, 5, 5).setNumConvolutions(20).build())
				.appendPoolingLayer(PoolingLayer.newBuilder().setWindowSize(2, 2).build())
				.appendConvolutionLayer(ConvolutionLayer.newBuilder().setConvolutionSize(1, 3, 3).setNumConvolutions(20).build())
				.setFullyConnectedDepth(1).setFullyConnectedWidth(300).setFullyConnectedActivationFunction(SIGMOID)
				.setLearningRate(eta).setMaxEpochs(1).build();

		System.out.println("******\tDeep CNN constructed." + " The structure is described below.\t******");
		System.out.println(cnn);

		// train CNN3

		System.out.println("******\tDeep CNN training has begun." + " Updates will be provided after each epoch.\t******");

		double[] testArray=cnn.train1(testSet);
		System.out.println("\n******\tDeep CNN testing has begun.\t******");
		cnn.test(testSet, true);

		return testArray;
	}
}
