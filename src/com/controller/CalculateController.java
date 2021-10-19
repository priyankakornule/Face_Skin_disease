package com.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.DataAccessLayer;
import com.model.CalculateNutrient;
import com.model.DietPlan;
import com.model.Food;
import com.model.ImageModel;
import com.model.Nutrientinfo;
import com.model.Quantity;
import com.model.Register;
import com.sun.org.apache.xml.internal.resolver.readers.CatalogReader;



/**
 * Servlet implementation class CalculateController
 */
@WebServlet("/CalculateController")
public class CalculateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalculateController() {
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
		  
		    int quantity=1;
		    ImageModel qu=new ImageModel();
			qu.setQuantity(quantity);
			int i=DataAccessLayer.getInsertQuantity(qu);
			 
			if(i !=0 ){
		 
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
	
	public static void main(String[] args) throws IOException,Exception  {

		double calorieUser=207;
		System.out.println("calorieUser : "+calorieUser);
		double calorieFood=102;
		System.out.println("calorieFood : "+calorieFood);
		
		 double NeededCalorie=0;
		 NeededCalorie=calorieUser-calorieFood;
		 System.out.println("Needed Calorie : "+NeededCalorie);
		 
		 double wholeDay;
				 double cal=204,cal2=100;
		 
		 
		 int uid=1;
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
		  
		  int calorie=10;
		  System.out.println("Calorie :: "+calorie);
		 
		  int quant=0;
		  int quantity=3;
			 if(quantity != 0)
			  { 
				  quant=calorie*quantity;
				  System.out.println("quantity====>"+quant);
				
					 NeededCalorie=calorieUser-quant;
					 System.out.println("Needed Calorie : "+NeededCalorie);
			  }
			 else{ 
			 NeededCalorie=calorieUser-calorie;
			 System.out.println("Needed Calorie : "+NeededCalorie);
			 
			 }

		  
          /*for(Nutrientinfo n:calorie){
       	   System.out.println("Calorie===>"+n.getCalories());
		  }*/
		  
		  
		 
		 
		 /* String t[]=startTime.split("-");
		  System.out.println(Arrays.toString(t));
		  
		  int t1=Integer.parseInt(t[0]);
		  System.out.println(t1);
		  
		  int t2=Integer.parseInt(t[1]);
		  System.out.println(t2);
		  
		  int t3=Integer.parseInt(t[2]);
		  System.out.println(t3);
		   
		  Date date1 = null;
		  List<ImageModel> image=DataAccessLayer.fetchDate(uid);
			 for(ImageModel i1:image){
				 date1 =i1.getDate();
				 System.out.println("Date:"+date1);
				 }
		  int day = 0,month = 0,year;
			  for(int i=0;i<image.size();i++){
				  
					Date dt=image.get(i).getDate();
					int fid=image.get(i).getId();
					String name=image.get(i).getName();
					System.out.println("FID =============>"+fid);
					System.out.println("dt : :"+dt);
					
					 day=dt.getDate();
					System.out.println(day); 
					
					month=dt.getMonth()+1;
					System.out.println(month);
					
					year=dt.getYear();
					System.out.println(year);
					
					System.out.println("t2"+t2);
					System.out.println("day"+day);
					System.out.println("t3"+t3);
					System.out.println("month"+month);
				     System.out.println("Out Loop");
					 
                      int count=0;
					 if(t2 == month && t3 == day){
						 System.out.println(name);
						
						int calories=DataAccessLayer.getCalorieUser1(fid);
						System.out.println("Calorie ==>"+calories);
						count=count+calories;
					
						 System.out.println("count"+count);
					 }else{
						System.out.println("cal "+cal);
					 }
					
					
			  }
		*/	  
			  /*Calendar localCalendar = Calendar.getInstance(TimeZone.getDefault());
		      
		       
		        int currentDay = localCalendar.get(Calendar.DATE);
		        int currentMonth = localCalendar.get(Calendar.MONTH) + 1;
		        int currentYear = localCalendar.get(Calendar.YEAR);
		        
		     
		        System.out.println("Current Day: " + currentDay);
		        System.out.println("Current Month: " + currentMonth);
		        System.out.println("Current Year: " + currentYear);*/
		      
		
			 
	/*	  String t1[]=StartTime1.split("-");
		  System.out.println(Arrays.toString(t1));
		  
		  String t2=t1[1];
		  System.out.println(t2);
		  
		  String t3=t1[2];
		  System.out.println(t3);
		  
		  
		  String e1[]=EndTime1.split("-");
		  System.out.println(Arrays.toString(e1));
		  
		  String e2=e1[1];
		  System.out.println(e2);
		  
		  String e3=e1[2];
		  System.out.println(e3);
		  
		  int wholeDay=0;
		  
		  int cal=207;
		  int cal2=150;
		*/   
	
		/* List<ImageModel> image=DataAccessLayer.fetchDate(uid);
		 for(ImageModel i:image){
		   Date date1=i.getDate();
			 System.out.println(date1);
			 
			 
		 }*/
		 
	//select u.file_id,u.user_id,t.name,t.Calories,t.foodname,u.prediction,u.date from calorie_estimation.nutrientinfo as t INNER JOIN calorie_estimation.user_uploaded_images as u ON t.name=u.prediction where foodname='ALOOPARATHA';	 
		

			 
			 
			 
			 
			 
			 
			 
		 String result=null;
			 if(NeededCalorie > calorie){
			     result="Calorie is insufficient";
			     System.out.println(result);
			 }else{
				 result="Calorie is more";
				 System.out.println(result);
			 }
		
	}
}
