/*package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import javax.mail.Session;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.DataAccessLayer;
import com.algorithm.KeyClassifier;
import com.model.CalculateNutrient;
import com.model.Food;



*//**
 * Servlet implementation class Calculate
 *//*
@WebServlet("/Calculate")
public class Calculate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	*//**
	 * @see HttpServlet#HttpServlet()
	 *//*
	public Calculate() {
		super();
		// TODO Auto-generated constructor stub
	}

	*//**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 *//*
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ")
				.append(request.getContextPath());
	}

	*//**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 *//*
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String serving=request.getParameter("qnumber");
		int qnumber1 = Integer.parseInt(serving);
		//system.out.println("served---> "+qnumber1);
	System.out.println("Calculate.doPost()");
		
		String age=request.getParameter("age");
		int age1 = Integer.parseInt(age);
	   System.out.println("age is---> "+age1);
		
		String gender=request.getParameter("gender");
		//int gen=Integer.parseInt(gender);
		System.out.println("gender is--> "+gender);
		
		String height=request.getParameter("height");
		System.out.println("height is--> "+height);
		
		String weight=request.getParameter("weight");
		System.out.println("weight is---> " +weight);
		
		String activeness=request.getParameter("activeness");
		System.out.println("activ iss---> "+activeness);
		
		//calculate nutrient by default//
		
		String calories=request.getParameter("calorie2");
		System.out.println(" caloris need==> "+calories);
		int calories22 = Integer.parseInt(calories.trim());
		System.out.println("fat1---> "+calories22);
		
		String fatty=request.getParameter("fatty");
		int fatty1 = Integer.parseInt(fatty.trim());
		System.out.println("fat1---> "+fatty1);
		
		String protein2=request.getParameter("protein2");
		int protein22 = Integer.parseInt(protein2.trim());
		System.out.println("protein1 is---> "+protein2);
		
		
		String carbo2=request.getParameter("carbo2");
		int carbo22 = Integer.parseInt(carbo2.trim());
		System.out.println("protein1 is---> "+carbo2);
		
		
		
		CalculateNutrient cn= new CalculateNutrient();
		cn.setCalories(calories);
		cn.setProtein(protein2);
		cn.setFats(fatty);
		cn.setCarbohydrated(carbo2);
		
		// user Nutrient of food
		
		String energy = request.getParameter("energy");
		int energy1 = Integer.parseInt(energy);

		String protein = request.getParameter("protein");
		float protein1 = Float.parseFloat(protein);

		String sugar = request.getParameter("sugar");
		float sugar1 = Float.parseFloat(sugar);

		String fats = request.getParameter("fats");
		float fats1 = Float.parseFloat(fats);

		String fiber = request.getParameter("fiber");
		float fiber1 = Float.parseFloat(fiber);

		String calcium = request.getParameter("calcium");
		float calcium1 = Float.parseFloat(calcium);

		String calories23 = request.getParameter("calories");
		int calories1 = Integer.parseInt(calories23);

		String vitaminA = request.getParameter("VitaminA");
		int vitaminA1 = Integer.parseInt(vitaminA);

		String vitaminC = request.getParameter("VitaminC");
		int vitaminC1 = Integer.parseInt(vitaminC);

		String iron = request.getParameter("iron");
		int iron1 = Integer.parseInt(iron);
		
		String diet_type=request.getParameter("diet_type");

        Food ff = new Food();
		
		
		
		ff.setAge(age1);
		ff.setGender(gender);
		ff.setCalories(calories1);
		ff.setProtein(protein1);
		ff.setVitaminA(vitaminA1);
		ff.setVitaminC(vitaminC1);
		ff.setIron(iron1);
		ff.setCalcium(calcium1);
		ff.setSugar(sugar1);
		ff.setEnergy(energy1);
		ff.setFat(fats1);
		ff.setFiber(fiber1);
		ff.setIron(iron1);
	    
		
		String output=KeyClassifier.checkKey(ff);
		//system.out.println("output is--> "+output);
		
		int needcalories=calories22/8;
		//system.out.println("divide "+needcalories);
		int needbreakfastcalories=needcalories*3;
		//system.out.println("breakfast calori-->" +needbreakfastcalories);
		int needlunchfastcalories=needcalories*3;
		//system.out.println("lunch calori-->" +needlunchfastcalories);
		int needdinnerfastcalories=needcalories*2;
		//system.out.println("dinner calori-->" +needdinnerfastcalories);
		
		
		         //for morning 
				int morning=needbreakfastcalories/9;
			    //system.out.println(" borning tes-->"+morning);
				int morning1=morning-10;
				//system.out.println("morning tea from--> "+morning1);
				int morning2=morning+10;
				//system.out.println("morning tea end---> "+morning2);
				HttpSession session=request.getSession();
			List<Food> mf	=DataAccessLayer.morningfood(morning1,morning2);
			if (mf.size()==0) {
				Food mfood= new Food();
				mfood.setFoodname("Tea");
				mfood.setCalories(50);
				mfood.setFoodtype("Morning");
				mfood.setDiet("Veg");
				mf.add(mfood);
				
				
				session.setAttribute("mornning", mf);
			} else {

				session.setAttribute("mornning", mf);
			}
			
			
			
		    for (Food food : mf) {
			//system.out.println(" food are--> "+food.getFoodname());
			
		            }	
		    
		  		//for fruit
		    int fruits=needbreakfastcalories/8;
		    //system.out.println("fruits are--> "+fruits);
		    int fruits1=fruits-20;
		    //system.out.println("fruits from-->"+fruits1);
		    int fruits2=fruits+10;
		    //system.out.println(" fruits end--> "+fruits2);
		    
		    List<Food> frdiet  =DataAccessLayer.fruitsneed(fruits1,fruits2);
		    
		    if (frdiet.size()==0) {
		    	Food mfood= new Food();
				mfood.setFoodname("Apple");
				mfood.setCalories(80);
				mfood.setFoodtype("Fruit");
				mfood.setDiet("veg");
				frdiet.add(mfood);
		    	
		    	
		    	
		    	session.setAttribute("fruitset", frdiet);
			} else {

				session.setAttribute("fruitset", frdiet);
			}
		    
		    
				
		    for (Food food : frdiet) {
		    	
		    	//system.out.println(" fruits are----> "+food.getFoodname());
				
			}
		    
				//for breakfast
				int breakfast=needbreakfastcalories-morning-fruits;
				//system.out.println("breakkkkkkk---> "+breakfast);
				int breakfast3=breakfast*10/100;
				int breakfast2=breakfast-25;
				//system.out.println("range breakFAST from "+breakfast2);
				int breakfast1=breakfast+20;
				//system.out.println("range BREAKFAST end from "+breakfast1);
				
				List<Food> breakdiet=DataAccessLayer.breakfast(breakfast2,breakfast1,diet_type);
				
				   if (breakdiet.size()==0) {
				    	Food mfood= new Food();
						mfood.setFoodname("Bread Butter");
						mfood.setCalories(130);
						mfood.setFoodtype("Breakfast");
						mfood.setDiet("veg");
						breakdiet.add(mfood);
				    	
				    	
				    	
						session.setAttribute("breakfast", breakdiet);
					} else {

						session.setAttribute("breakfast", breakdiet);
					}
				    
				
				
				
				for (Food food : breakdiet) {
					//system.out.println("lunch --> "+food.getFoodname());
				}
				
		       //for lunch//
				
				int lunchitem=needlunchfastcalories-110-200;
				//system.out.println("lunch item are--> "+lunchitem);
				int lunchitem1=lunchitem-20;
				//system.out.println("lunch from " +lunchitem1);
				int lunchitem2=lunchitem+20;
				//system.out.println("lunch end--> "+lunchitem2);
				
				List<Food> lunchdiet=DataAccessLayer.lunchitem(lunchitem1,lunchitem2,diet_type);
				
				
				 if (lunchdiet.size()==0) {
				    	Food mfood= new Food();
						mfood.setFoodname("cabbage Sabji");
						mfood.setUnit("1 cup");
						mfood.setCalories(60);
						mfood.setFoodtype("Lunch");
						mfood.setDiet("veg");
						lunchdiet.add(mfood);
				    	
				    	
				    	
						session.setAttribute("lunch", lunchdiet);
					} else {

						session.setAttribute("lunch", lunchdiet);
					}
				
				
				
				
				for (Food food : lunchdiet) {
					//system.out.println("lunch are--> "+food.getFoodname());
				}
				
				// dinner
				
				int dinner=needdinnerfastcalories-200;
				//system.out.println("dinner--> " +dinner);
				int dinner1=dinner-35;
				//system.out.println("dinner from--> "+dinner1 );
				int dinner2=dinner+35;
				//system.out.println("dinner from--> "+dinner2);
				List<Food> dinnerdiet	=DataAccessLayer.dinnerdiet(dinner1,dinner2,diet_type);
				
				
				
				 if (dinnerdiet.size()==0) {
				    	Food mfood= new Food();
						mfood.setFoodname("Any veg Sabji");
						mfood.setUnit("1 cup");
						mfood.setCalories(60);
						mfood.setFoodtype("Lunch");
						mfood.setDiet("veg");
						dinnerdiet.add(mfood);
				    	
						session.setAttribute("dinner", dinnerdiet);
					} else {

						session.setAttribute("dinner", dinnerdiet);
					}
				
				
				
				
				
				for (Food food : dinnerdiet) {
					//system.out.println(" dinner--> "+food.getFoodname());
				}
				
				String result=KeyClassifier.checkKey(ff);
				System.out.println("result is--->"+result+"/");
				
				if(result.equalsIgnoreCase("no"))
				{
					System.out.println("result no");
					String result1="The food you have eaten is insufficient for your health \n So maintain your health by consuming your diet. ";
					session.setAttribute("result", result1);
				}else if(result.equalsIgnoreCase("yes")){
					System.out.println("result yes");
					String result2="The food you have eaten is sufficient for your health \n So maintain your health by consuming your diet. ";
					session.setAttribute("result", result2);
				} 
				else if(result.equalsIgnoreCase("high")){
					System.out.println("result high");
					String result3="The food you have eaten is excessive for your health \n So maintain your health by consuming your diet. ";
					session.setAttribute("result", result3);
				}
				
				
				response.sendRedirect("displaydiet.jsp");
				
				
		

	}

}
*/