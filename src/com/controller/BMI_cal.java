package com.controller;

import java.io.IOException;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.DataAccessLayer;
import com.model.Register;

/**
 * Servlet implementation class BMI_cal
 */
@WebServlet("/BMI_cal")
public class BMI_cal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BMI_cal() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        
		int uid=Integer.parseInt(request.getParameter("uid"));
		System.out.println("Uid bmi :"+uid);
		
         String bmiStr=request.getParameter("bmi");
	     float bmi=Float.parseFloat(bmiStr);
	     System.out.println("Bmi : "+bmi);
	     
	     String mean=request.getParameter("meaning");
	     System.out.println("Bmi Result : "+mean);
	     
         String gender=request.getParameter("gender");
         System.out.println("Gender : "+gender);
       
         String active=request.getParameter("active");
         System.out.println("ActiveNess : "+active);
         
         Register reg=new Register();
         reg.setBmi(bmi);
         reg.setMean(mean);
         reg.setGender(gender);
         reg.setActiveness(active);
         
       
       System.out.println("************************");
       
  
 			
	 	double finalBmi = 0;
	 		
	 		
	 		if(reg.getGender().equals("1")){
	 			
	 			System.out.println("if===================>");
	 			
	 			if(reg.getActiveness().equals("Sedentary"))
	 			{
	 				System.out.println("1.0");
						finalBmi=bmi*1.0;
						System.out.println(finalBmi);
						
	 			}
	 			else if(reg.getActiveness().equals("Light Active")){
	 				System.out.println("1.12");
						finalBmi=bmi*1.12;
						System.out.println(finalBmi);
	 			}
	 			else if(reg.getActiveness().equals("Moderately Active")){
	 				 System.out.println("1.19");
						finalBmi=bmi*1.19;
						System.out.println(finalBmi);
	 			}
	 			else if(reg.getActiveness().equals("Very Active")){
	 				System.out.println("1.27");
                     finalBmi=bmi*1.27;
                     System.out.println(finalBmi);
	 			}
	 			else if(reg.getActiveness().equals("Extra Active")){
	 				System.out.println("1.45");
						finalBmi=bmi*1.45;
						System.out.println(finalBmi);
	 			}
	 		}else
	 		{
	 			if(reg.getActiveness().equals("Sedentary"))
	 			{
	 				System.out.println("1.0");
						finalBmi=bmi*1.0;
						System.out.println(finalBmi);
						
	 			}
	 			else if(reg.getActiveness().equals("Light Active")){
	 				System.out.println("1.11");
					finalBmi=bmi*1.11;
					System.out.println(finalBmi);
	 			}
	 			else if(reg.getActiveness().equals("Moderately Active")){
	 				System.out.println("1.17");
						finalBmi=bmi*1.17;
						System.out.println(finalBmi);
	 			}
	 			else if(reg.getActiveness().equals("Very Active")){
	 				System.out.println("1.26");
                     finalBmi=bmi*1.26;
                     System.out.println(finalBmi);
	 			}
	 			else if(reg.getActiveness().equals("Extra Active")){
	 				System.out.println("1.48");
						finalBmi=bmi*1.48;
						System.out.println(finalBmi);
	 			}
	 		}	
	 			/*switch(reg.getActiveness()) {
	 			case "Sedentary" : System.out.println("1.0");
	 								finalBmi=bmi*1.0;
	 								System.out.println(finalBmi);
	 								return;
	 			                      
	 			case "Light Active" : System.out.println("1.12");
	 								finalBmi=bmi*1.12;
	 								System.out.println(finalBmi);
	 								return;
	 									
	 			case "Moderately Active" : System.out.println("1.19");
	 								finalBmi=bmi*1.19;
	 								System.out.println(finalBmi);
	 								return;
	 								
	 			case "Very Active" : System.out.println("1.27");
	 			                       finalBmi=bmi*1.27;
	 			                       System.out.println(finalBmi);
	 			                      return; 
	 			
	 			case "Extra Active" : System.out.println("1.45");
	 								finalBmi=bmi*1.45;
	 								System.out.println(finalBmi);
	 								return;  
	 			}
	 			
	 		}else{
	 			System.out.println("else===================>");
	 			switch(reg.getActiveness()) {
	 			case "Sedentary" : System.out.println("1.0");
	 								finalBmi=bmi*1.0;
	 								System.out.println(finalBmi);
	 								return;  
	 			                      
	 			case "Light Active" : System.out.println("1.11");
	 								finalBmi=bmi*1.11;
	 								System.out.println(finalBmi);
	 								return;   
	 									
	 			case "Moderately Active" : System.out.println("1.17");
	 								finalBmi=bmi*1.17;
	 								System.out.println(finalBmi);
	 								return;    
	 			
	 			case "Very Active" : System.out.println("1.26");
	 			                       finalBmi=bmi*1.26;
	 			                       System.out.println(finalBmi);
	 			                      return;  
	 			
	 			case "Extra Active" : System.out.println("1.48");
	 								finalBmi=bmi*1.48;
	 								System.out.println(finalBmi);
	 								return;
	 			}
	 		}
*/	 
	 	System.out.println("Final  bmi : "+finalBmi);
	 	
	 	DataAccessLayer.insertBmi(reg,uid,finalBmi);
        

    	response.sendRedirect("uploadImage.jsp");
         
	 	
	   }
	public static void main(String[] args) {
		
		Register reg=DataAccessLayer.getHealthFormInfo(1);
		System.out.println(reg.getBmi());
		float bmi=reg.getBmi();
		double finalBmi = 0;
		System.out.println(reg.getGender());
		System.out.println(reg.getActiveness());
		
		
		
 		
 		
 		if(reg.getGender().equals("1")){
 			
 			System.out.println("if===================>");
 			switch(reg.getActiveness()) {
 			case "Sedentary" : System.out.println("1.0");
 								finalBmi=bmi*1.0;
 								System.out.println(finalBmi);
 								return;
 			                      
 			case "Light Active" : System.out.println("1.12");
 								finalBmi=bmi*1.12;
 								System.out.println(finalBmi);
 								return;
 									
 			case "Moderately Active" : System.out.println("1.19");
 								finalBmi=bmi*1.19;
 								System.out.println(finalBmi);
 								return;
 								
 			case "Very Active" : System.out.println("1.27");
 			                       finalBmi=bmi*1.27;
 			                       System.out.println(finalBmi);
 			                      return; 
 			
 			case "Extra Active" : System.out.println("1.45");
 								finalBmi=bmi*1.45;
 								System.out.println(finalBmi);
 								return;  
 			}
 			
 		}else{
 			System.out.println("else===================>");
 			switch(reg.getActiveness()) {
 			case "Sedentary" : System.out.println("1.0");
 								finalBmi=bmi*1.0;
 								System.out.println(finalBmi);
 								return;  
 			                      
 			case "Light Active" : System.out.println("1.11");
 								finalBmi=bmi*1.11;
 								System.out.println(finalBmi);
 								return;   
 									
 			case "Moderately Active" : System.out.println("1.17");
 								finalBmi=bmi*1.17;
 								System.out.println(finalBmi);
 								return;    
 			
 			case "Very Active" : System.out.println("1.26");
 			                       finalBmi=bmi*1.26;
 			                       System.out.println(finalBmi);
 			                      return;  
 			
 			case "Extra Active" : System.out.println("1.48");
 								finalBmi=bmi*1.48;
 								System.out.println(finalBmi);
 								return;
 			}
 		}
 
 	
 	
	
		System.out.println("---------"+finalBmi);
        DataAccessLayer.insertBmi(reg,1,finalBmi);
	}
	 
}
