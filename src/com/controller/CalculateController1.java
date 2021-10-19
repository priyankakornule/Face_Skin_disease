package com.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.DataAccessLayer;
import com.model.ImageModel;
import com.model.Quantity;

/**
 * Servlet implementation class CalculateController1
 */
@WebServlet("/CalculateController1")
public class CalculateController1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalculateController1() {
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
		
		float bmi=Float.parseFloat(request.getParameter("bmi"));
		System.out.println("bmi : "+bmi);
		double calorieBmi=Double.parseDouble(request.getParameter("calorieBmi"));
		System.out.println("calorieBmi : "+calorieBmi);
		double calorieFood=Double.parseDouble(request.getParameter("calorieFood"));
		System.out.println("calorieFood : "+calorieFood);
		
		 		
		
		
		 DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		 Date date = new Date();
	     System.out.println(dateFormat.format(date)); //2016/11/16 12:08:43
		 String startTime=dateFormat.format(date);
		  
		  System.out.println("startTime :: "+startTime);
	      String foodname="";
		  List<ImageModel> im=DataAccessLayer.getWholeDayCalorie(uid,startTime);
		List<String> str=new ArrayList<>();
		  for(ImageModel i:im){
			   foodname=i.getPrediction();
			  System.out.println("Prediction ===>"+foodname);
			  str.add(foodname);
               }
		  
		  int calorie=DataAccessLayer.getWholeActualCalorie(str);
		  System.out.println("Calorie :: "+calorie);
     
		  double NeededCalorie=0;
		  int quant=0;
		  int quantity=0;
			 if(Integer.parseInt(request.getParameter("quantity")) != 0)
			  { 
				 quantity=Integer.parseInt(request.getParameter("quantity"));
				 ImageModel qu=new ImageModel();
					
				 qu.setQuantity(quantity);
				
				int i=DataAccessLayer.getInsertQuantity(qu);
				if(i !=0 ){
					
			
				  quant=calorie*quantity;
				  System.out.println("quantity====>"+quant);
				
					 NeededCalorie=calorieBmi-quant;
					 System.out.println("Needed Calorie : "+NeededCalorie);
				
				} 
                    
			  }
			 else{ 
			 NeededCalorie=calorieBmi-calorie;
			 System.out.println("Needed Calorie : "+NeededCalorie);
			 
			 }
		 String result=null;
			 if(NeededCalorie > 0){
			     result="Calorie is insufficient";
			     System.out.println(result);
			 }else{
				 result="Calorie is more";
				 System.out.println(result);
			 }
		

		 
		        HttpSession session1=request.getSession();
		        session1.setAttribute("result", result);
		        session1.setAttribute("calorie", calorie);
		        session1.setAttribute("NeededCalorie", NeededCalorie);
		        
				response.sendRedirect("NeededCalorie.jsp");
		        
				
		
	}
	
}
