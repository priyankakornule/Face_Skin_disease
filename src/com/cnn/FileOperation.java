package com.cnn;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileOperation {

	double[] fixedImageOutput = null;
	
	public void AppendToFile(double fixedImageOutput) {
			File file = new File("E:\\Final Project\\Face_Skin_disease\\WebContent\\NewTrain.arff");
		BufferedWriter bw = null;
		FileWriter fw = null;
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// true = append file
		try {
			fw = new FileWriter(file,true);
			bw = new BufferedWriter(fw);
			
			bw.append(" "+String.valueOf(fixedImageOutput)+",");
				//bw.append("\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {

				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}
		}
	}
	
	

	
	public static void main(String args[])
	{


	}
}



