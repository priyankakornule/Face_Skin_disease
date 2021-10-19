package com.algorithm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class DivideDimention {
	

	public static double[][] getDynamicDimention() throws FileNotFoundException
	{
	
		
	
		  File f=new File("E:\\Final Project\\Face_Skin_disease\\data\\output\\classify.arff");
	      BufferedReader br = new BufferedReader(new FileReader(f));
	      BufferedReader br1 = new BufferedReader(new FileReader(f));
	      
	      ArrayList<ArrayList> list=new ArrayList<>();
	      String line;
	      int linenumber=0;	    
	      int count=0;	
	      
	      int count1=0;
	      int row1=0;
	      
	      //this code is used for find first frequency line
	      
	      try {
				while ((line = br.readLine()) != null) {
				
					if(line.equals("@data"))
					{
					linenumber=count;
					linenumber=linenumber+1;
					}
					else
					{
					count++;	
					}	
					
				  count1++;
				  	
				}
				row1=count1-linenumber;
				System.out.println("row1=="+row1);
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		 
	      
	      
	      //this code is used to get all dimention in list
	      
	        try {
					while ((line = br1.readLine()) != null) {
					
						
			     	 String text[]=line.split(",");	
				     ArrayList al=new ArrayList<>(Arrays.asList(text));
					 list.add(al);		
					}
				} catch (IOException e) {
					
					e.printStackTrace();
				}
	    	
	      
	     //get dynamic row and column from classify.arff file
	        
	        double dim[][]=new double[row1][80];
	        int row=0;
	        for(int i=linenumber;i<list.size();i++)
	        {
	        	
	         String list2=list.get(i).toString();	
	         String list4=""; 
	         for(int k=1;k<list2.length()-1;k++)
	         {
	        	list4=list4+list2.charAt(k); 
	        	 
	        	 
	         }
	         
	         String[] list3=list4.split(",");
	         
	         double d[]=new double[list3.length];
	        
	         
	         for(int j=0;j<list3.length-1;j++)
	         {
	        	 
	        	double d1= Double.parseDouble(list3[j]);
	        	dim[row][j]=d1; 	 
	         }
	         row++;
	         
	        }
		
	        
	        
	      /* for(int i=0;i<1;i++)
	       {
	    	   for(int j=0;j<80;j++)
	    	   {
	    		   
	    		  System.out.print(dim[i][j]); 
	    	   }
	    	   
	    	   System.out.println();
	       }*/
	
		
	        return dim;
		
	}
	
		public static void main(String[] args) throws FileNotFoundException {
	
			  File f=new File("E:\\Final Project\\Face_Skin_disease\\data\\output\\classify.arff");
		//File f=new File("C:\\Gayatri_new\\Skin_disease\\data\\output\\classify.arff");
	      BufferedReader br = new BufferedReader(new FileReader(f));
	      BufferedReader br1 = new BufferedReader(new FileReader(f));
	      
	      ArrayList<ArrayList> list=new ArrayList<>();
	      String line;
	      int linenumber=0;	    
	      int count=0;	
	      
	      int count1=0;
	      int row1=0;
	      
	      //this code is used for find first frequency line
	      
	      try {
				while ((line = br.readLine()) != null) {
				
					if(line.equals("@data"))
					{
					linenumber=count;
					linenumber=linenumber+1;
					}
					else
					{
					count++;	
					}	
					
				  count1++;
				  	
				}
				
				System.out.println("linenumber=>"+linenumber);

				System.out.println("count1=>"+count1);
				row1=count1-linenumber;
				System.out.println("row1=="+row1);
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		 
	      
	      
	      //this code is used to get all dimention in list
	      
	        try {
					while ((line = br1.readLine()) != null) {
					
						
			     	 String text[]=line.split(",");	
				     ArrayList al=new ArrayList<>(Arrays.asList(text));
					 list.add(al);
					// System.out.println("Al==>"+al);
					}
				} catch (IOException e) {
					
					e.printStackTrace();
				}
	    	
	      System.out.println("list==>"+list);
	     //get dynamic row and column from classify.arff file
	        
	        double dim[][]=new double[row1][80];
	        int row=0;
	        for(int i=linenumber;i<list.size();i++)
	        {
	        	
	         String list2=list.get(i).toString();	

	        	System.out.println("list2=>"+list2);
	        	 
	         String list4=""; 
	         for(int k=1;k<list2.length()-1;k++)
	         {
	        	list4=list4+list2.charAt(k); 
	        	//System.out.println("list2.charAt(k)=>"+list2.charAt(k));
	        	//System.out.println("list4=>"+list4);
	        	 
	         }
	         
	         String[] list3=list4.split(",");
	         
	         double d[]=new double[list3.length];
	        
	         
	         for(int j=0;j<list3.length-1;j++)
	         {
	        	 
	        	double d1= Double.parseDouble(list3[j]);
	        	dim[row][j]=d1; 	 
	         }
	         row++;
	         
	        }
		
	        
	        
	       for(int i=0;i<1;i++)
	       {
	    	   for(int j=0;j<80;j++)
	    	   {
	    		   
	    		  System.out.print(dim[i][j]); 
	    	   }
	    	   
	    	   System.out.println();
	       }
	
		
		
}	


}
