package com.algorithm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class CategoryExtractor {

	
public static ArrayList getcategories() throws FileNotFoundException
{
	//File f=new File("C:\\Gayatri_new\\Skin_disease\\data\\output\\classify.arff");
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
			//System.out.println("row1=="+row1);
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	 
    
    
    //this code is used to get all dimention into list
    
      try {
				while ((line = br1.readLine()) != null) {
				
					
		     	 String text[]=line.split(",");	
			     ArrayList al=new ArrayList<>(Arrays.asList(text));
				 list.add(al);		
				}
			} catch (IOException e) {
				
				e.printStackTrace();
			}
 
      
      
      //this code is used to retuen all categories in Arraylist
      
      ArrayList category=new ArrayList();
      
      for(int i=linenumber;i<list.size();i++)
      {
    	  
    	  int len=list.get(i).size();
    	  category.add(list.get(i).get(len-1));
    	  
      }
      
  
      /*
       get all categories and list length here
       System.out.println(category);
       System.out.println(category.size());
  */
      
      
      
	return category;


}
	
	
public static void main(String[] args) throws FileNotFoundException {

      
	/*File f=new File("E://imgeprojecttesting//Calorie_Estimation//data//output//classify.arff");
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
 
      
      
      ArrayList category=new ArrayList();
      
      for(int i=linenumber;i<list.size();i++)
      {
    	  
    	  int len=list.get(i).size();
    	  category.add(list.get(i).get(len-1));
    	  
      }
      
    System.out.println(category);
    System.out.println(category.size());
  
      
      
      
      
*/  	
}
}
