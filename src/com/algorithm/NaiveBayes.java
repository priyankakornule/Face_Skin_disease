package com.algorithm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import com.sun.xml.internal.bind.marshaller.DumbEscapeHandler;

public class NaiveBayes {
	 public static double distance(double x, double y) {  
		  return  Math.sqrt( Math.pow(x-y,2.0) );  
		 }
		  
		 public static double distance(int x, int y) {  
		  return Math.sqrt( Math.pow(x-y,2) );          
		 }
		 
		 
		 public static double distance(double x[], double y[]) {
		  
		  double ds=0.0;
		  for(int n=0;n<x.length;n++)
		   ds += Math.pow(x[n]-y[n],2.0);
		  
		  ds=Math.sqrt(ds);
		  
		  //System.out.println("new1=="+ds);
		  
		  return  ds;  
		 }
		  
		 public static double distance(int x[], int y[]) {
		  
		  double ds=0.0;
		  for(int n=0;n<x.length;n++)
		   ds += Math.pow(x[n]-y[n],2.0);
		  
		  ds=Math.sqrt(ds);
		  return  ds;            
		 }
		 
		 
		  public static double[] distance(int x[][], int y[]) {
		  
		    double ds[]=new double[x.length];
		  for(int n=0;n<x.length;n++)
		   ds[n]= distance(x[n],y);   
		  
		  //System.out.println("new2=="+ds);
		  return  ds;            
		 }
		 
		  public static double[] distance(double x[][], double y[]) {
			  
		  double ds[]=new double[x.length];
		  for(int n=0;n<x.length;n++)
		   ds[n] = distance(x[n],y);   
		  
		  //System.out.println("new3=="+Arrays.toString(ds));
		  return  ds;            
		 } 
		  
		  
		  
		  public static String getclassification(double ady2[]) throws FileNotFoundException
		  {
			  
			  System.out.println("\n Euclidean Distance between two vectors x and y having N-dimensional element " );
		        
			  //return dynamic dimention from classify.arff
			  
			  double adx2[][]=DivideDimention.getDynamicDimention();

		     // double ady2[]={0.017130620985010708, 0.01284796573875803, 0.004282655246252677, 0.004282655246252677, 0.029978586723768737, 0.02676659528907923, 0.022483940042826552, 0.007494646680942184, 0.007494646680942184, 0.007494646680942184, 0.0053533190578158455, 0.0021413276231263384, 0.009635974304068522, 0.027837259100642397, 0.0053533190578158455, 0.0053533190578158455, 0.009635974304068522, 0.010706638115631691, 0.0021413276231263384, 0.01284796573875803, 0.032119914346895075, 0.010706638115631691, 0.017130620985010708, 0.010706638115631691, 0.013918629550321198, 0.0032119914346895075, 0.0053533190578158455, 0.014989293361884369, 0.014989293361884369, 0.03640256959314775, 0.014989293361884369, 0.007494646680942184, 0.004282655246252677, 0.01284796573875803, 0.006423982869379015, 0.007494646680942184, 0.006423982869379015, 0.031049250535331904, 0.007494646680942184, 0.027837259100642397, 0.0053533190578158455, 0.01284796573875803, 0.006423982869379015, 0.010706638115631691, 0.004282655246252677, 0.0053533190578158455, 0.004282655246252677, 0.008565310492505354, 0.011777301927194861, 0.011777301927194861, 0.023554603854389723, 0.017130620985010708, 0.009635974304068522, 0.009635974304068522, 0.016059957173447537, 0.008565310492505354, 0.019271948608137045, 0.010706638115631691, 0.0053533190578158455, 0.007494646680942184, 0.014989293361884369, 0.006423982869379015, 0.013918629550321198, 0.0032119914346895075, 0.017130620985010708, 0.01284796573875803, 0.004282655246252677, 0.0053533190578158455, 0.010706638115631691, 0.010706638115631691, 0.01284796573875803, 0.009635974304068522, 0.031049250535331904, 0.007494646680942184, 0.010706638115631691, 0.06852248394004283, 0.004282655246252677, 0.008565310492505354, 0.017130620985010708, 0.004282655246252677};          
		      double ds6[]= distance(adx2, ady2);	      
		      System.out.println( "Distance :" + Arrays.toString(ds6)); 
		      
		      double ds7[]=ds6; 
		
		    
		      
		    //this code is used to find minimum distance from obtain distance 
		    //we are print total length,minimun distance and its index here  
		      
		      System.out.println("length====="+ds7.length);
		      int index=0;
		      double min=ds7[0]; 
		      for(int i=0;i<ds7.length;i++)
		      {	  
		    	  if(min>ds7[i])
		    	  {
		    		  min=ds7[i];
		    		  index=i;	  
		    	  }
		    	  
		    	  
		      }
		      System.out.println("index=="+index);
		      System.out.println("min=="+min);
		      
		      
		     //return minimun distance categories here or classified categories here
		      
		      ArrayList categores=CategoryExtractor.getcategories();	      
		      
		      //System.out.println("output======="+categores.get(index));
		      
		     String category=(String) categores.get(index);

			 
		     return category;
			  
		  }
		  
		  
		  

		public static void main(String[] args) throws FileNotFoundException {
	
		  System.out.println("\n Euclidean Distance between two vectors x and y having N-dimensional element " );
	        
		  //return dynamic dimention from classify.arff
		  
		  double adx2[][]=DivideDimention.getDynamicDimention();

	      double ady2[]={0.008607198748043818,0.017996870109546165,0.010954616588419406,0.01643192488262911,0.01564945226917058,0.010954616588419406,0.011737089201877934,0.00782472613458529,0.02034428794992175,0.003129890453834116,0.009389671361502348,0.010954616588419406,0.006259780907668232,0.011737089201877934,0.005477308294209703,0.009389671361502348,0.00782472613458529,0.01486697965571205,0.010954616588419406,0.013302034428794992,0.010954616588419406,0.007042253521126761,0.010172143974960876,0.017996870109546165,0.003912363067292645,0.012519561815336464,0.01643192488262911,0.00782472613458529,0.02034428794992175,0.007042253521126761,0.01486697965571205,0.010172143974960876,0.025039123630672927,0.014084507042253521,0.008607198748043818,0.01643192488262911,0.012519561815336464,0.008607198748043818,0.014084507042253521,0.010954616588419406,0.00782472613458529,0.010172143974960876,0.023474178403755867,0.010172143974960876,0.02269170579029734,0.01564945226917058,0.014084507042253521,0.02034428794992175,0.019561815336463225,0.007042253521126761,0.014084507042253521,0.017214397496087636,0.011737089201877934,0.009389671361502348,0.011737089201877934,0.012519561815336464,0.008607198748043818,0.017996870109546165,0.009389671361502348,0.014084507042253521,0.011737089201877934,0.017996870109546165,0.007042253521126761,0.01643192488262911,0.012519561815336464,0.014084507042253521,0.006259780907668232,0.013302034428794992,0.007042253521126761,0.02034428794992175,0.002347417840375587,0.013302034428794992,0.007042253521126761,0.010172143974960876,0.018779342723004695,0.009389671361502348,0.02112676056338028,0.014084507042253521,0.013302034428794992,0.012519561815336464};          
	      double ds6[]= distance(adx2, ady2);	      
	      System.out.println( "Distance :" + Arrays.toString(ds6)); 
	      
	      double ds7[]=ds6; 
	
	    
	      
	    //this code is used to find minimum distance from obtain distance 
	    //we are print total length,minimun distance and its index here  
	      
	      System.out.println("length====="+ds7.length);
	      int index=0;
	      double min=ds7[0]; 
	      for(int i=0;i<ds7.length;i++)
	      {	  
	    	  if(min>ds7[i])
	    	  {
	    		  min=ds7[i];
	    		  index=i;	  
	    	  }
	    	  
	    	  
	      }
	      System.out.println("index=="+index);
	      System.out.println("min=="+min);
	      
	      
	     //return minimun distance categories here or classified categories here
	      
	      ArrayList categores=CategoryExtractor.getcategories();	      
	      
	      System.out.println("output==="+categores.get(index));
	      
	    
	      	      
	}
}
