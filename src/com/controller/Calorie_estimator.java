package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.DataAccessLayer;
import com.model.Register;

/**
 * Servlet implementation class Calorie_estimator
 */
@WebServlet("/Calorie_estimator")
public class Calorie_estimator extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Calorie_estimator() {
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
		System.out.println("Uid bmi :"+uid);
		
		int age=Integer.parseInt(request.getParameter("age"));
		System.out.println("age : "+age);
		
         String bmiStr=request.getParameter("bmi");
	     float bmi=Float.parseFloat(bmiStr);
	     System.out.println("Bmi : "+bmi);
	     
	     String mean=request.getParameter("meaning");
	     System.out.println("Bmi Result : "+mean);
	     
         String gender=request.getParameter("gender");
         System.out.println("Gender : "+gender);
         
         double height=Double.parseDouble(request.getParameter("height"));
         System.out.println("Height : "+height);
         
         double weight=Double.parseDouble(request.getParameter("weight"));
         System.out.println("Weight : "+weight);
        		 
       
         String active=request.getParameter("active");
         System.out.println("ActiveNess : "+active);
         
         Register reg=new Register();
         reg.setBmi(bmi);
         reg.setMean(mean);
         reg.setGender(gender);
         reg.setActiveness(active);
         reg.setCms(height);
         reg.setWeight(weight);
       
       System.out.println("************************");
       
             
       
      //double factorW,factorH,factorS,factorA,factorPA,factorPAHW, factorPAW, factorPAH,totalEER,Result;
      double factorW=0;
      if(reg.getGender().equals("0")){
    	  factorW=15.91*1*weight;//1 for kg per weight
    	  System.out.println("FactorW male : "+factorW);
      }else{
    	  factorW=9.36*1*weight;
    	  System.out.println("FactorW Female : "+factorW);
      }
       
      double factorH=0;
      if(reg.getGender().equals("0")){
    	  factorH=539.68*0.01*height;// 0.01 for per centimeter for height
    	  System.out.println("FactorH male : "+factorH);
      }else{
    	  factorH=726*0.01*height;
    	  System.out.println("FactorH female : "+factorH);
      }
       
       
      double factorPA=0;
      if(reg.getGender().equals("1")){
			
			System.out.println("if===================>");
			
			if(reg.getActiveness().equals("Sedentary"))
			{
				System.out.println("1.0");
				factorPA=1.0;
					System.out.println(factorPA);
					
			}
			else if(reg.getActiveness().equals("Light Active")){
				System.out.println("1.12");
				factorPA=1.12;
					System.out.println(factorPA);
			}
			else if(reg.getActiveness().equals("Moderately Active")){
				 System.out.println("1.19");
				 factorPA=1.19;
					System.out.println(factorPA);
			}
			else if(reg.getActiveness().equals("Very Active")){
				System.out.println("1.27");
				factorPA=1.27;
               System.out.println(factorPA);
			}
			else if(reg.getActiveness().equals("Extra Active")){
				System.out.println("1.45");
				factorPA=1.45;
					System.out.println(factorPA);
			}
		}else
		{
			if(reg.getActiveness().equals("Sedentary"))
			{
				System.out.println("1.0");
				factorPA=1.0;
					System.out.println(factorPA);
					
			}
			else if(reg.getActiveness().equals("Light Active")){
				System.out.println("1.11");
				factorPA=1.11;
				System.out.println(factorPA);
			}
			else if(reg.getActiveness().equals("Moderately Active")){
				System.out.println("1.17");
				factorPA=1.17;
					System.out.println(factorPA);
			}
			else if(reg.getActiveness().equals("Very Active")){
				System.out.println("1.25");
				factorPA=1.26;
               System.out.println(factorPA);
			}
			else if(reg.getActiveness().equals("Extra Active")){
				System.out.println("1.48");
				factorPA=1.48;
					System.out.println(factorPA);
			}
		}	
       
       
       
       double factorPAH=factorPA*factorH;
       System.out.println("Factor PAH : "+factorPAH);
       double factorPAW=factorPA*factorW;
       System.out.println("Fcator PAW : "+factorPAW);
       
       double factorPAHW=0;
       factorPAHW=factorPAH+factorPAW;
       System.out.println("factor PAHW : "+factorPAHW);
       
        double factorA=0;
        if(reg.getGender().equals("0")){
        	factorA=(-9.53)*age;
        	System.out.println("Factor A : "+factorA);
        }else{
        	factorA=(-6.91)*age;
        	System.out.println("Factor A : "+factorA);
        }
       
        double factorS=0;////Assign Sex Factor (SF)
        if(reg.getGender().equals("0")){
        	factorS=662;
        	System.out.println("Factor S : "+factorS);
        }
        else{
        	factorS=354;
        	System.out.println("Factor A : "+factorS);
        }
        
        double totalEER=0;
        totalEER=factorS+factorA+factorPAHW;
        System.out.println("Total EER : "+totalEER);
        
        double result=0;
        result=(totalEER);
 		System.out.println("Result : "+result);
	 	/*double finalBmi = 0;
	 		
	 		
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
	 			 
	 	System.out.println("Final  bmi : "+finalBmi);
*/	 	
	 	DataAccessLayer.insertBmi(reg,uid,result);
        

    	response.sendRedirect("uploadImage.jsp");
         
	 	
	   }
	public static void main(String[] args) {
		
		Register reg=DataAccessLayer.getHealthFormInfo(1);
		System.out.println(reg.getBmi());
		float bmi=reg.getBmi();
		double finalBmi = 0;
		System.out.println(reg.getGender());
		System.out.println(reg.getActiveness());
		int age=reg.getAge();
		double weight=reg.getWeight();
		double height=reg.getCms();
		 		
		 double factorW=0;
	      if(reg.getGender().equals("0")){
	    	  factorW=15.91*1*weight;//1 for kg per weight
	    	  System.out.println("FactorW male : "+factorW);
	      }else{
	    	  factorW=9.36*1*weight;
	    	  System.out.println("FactorW Female : "+factorW);
	      }
	       
	      double factorH=0;
	      if(reg.getGender().equals("0")){
	    	  factorH=539.68*0.01*height;// 0.01 for per centimeter for height
	    	  System.out.println("FactorH male : "+factorH);
	      }else{
	    	  factorH=726*0.01*height;
	    	  System.out.println("FactorH female : "+factorH);
	      }
	       
	       
	      double factorPA=0;
	      if(reg.getGender().equals("1")){
				
				System.out.println("if===================>");
				
				if(reg.getActiveness().equals("Sedentary"))
				{
					System.out.println("1.0");
					factorPA=1.0;
						System.out.println(factorPA);
						
				}
				else if(reg.getActiveness().equals("Light Active")){
					System.out.println("1.12");
					factorPA=1.12;
						System.out.println(factorPA);
				}
				else if(reg.getActiveness().equals("Moderately Active")){
					 System.out.println("1.19");
					 factorPA=1.19;
						System.out.println(factorPA);
				}
				else if(reg.getActiveness().equals("Very Active")){
					System.out.println("1.27");
					factorPA=1.27;
	               System.out.println(factorPA);
				}
				else if(reg.getActiveness().equals("Extra Active")){
					System.out.println("1.45");
					factorPA=1.45;
						System.out.println(factorPA);
				}
			}else
			{
				if(reg.getActiveness().equals("Sedentary"))
				{
					System.out.println("1.0");
					factorPA=1.0;
						System.out.println(factorPA);
						
				}
				else if(reg.getActiveness().equals("Light Active")){
					System.out.println("1.11");
					factorPA=1.11;
					System.out.println(factorPA);
				}
				else if(reg.getActiveness().equals("Moderately Active")){
					System.out.println("1.17");
					factorPA=1.17;
						System.out.println(factorPA);
				}
				else if(reg.getActiveness().equals("Very Active")){
					System.out.println("1.25");
					factorPA=1.26;
	               System.out.println(factorPA);
				}
				else if(reg.getActiveness().equals("Extra Active")){
					System.out.println("1.48");
					factorPA=1.48;
						System.out.println(factorPA);
				}
			}	
	       
	       
	       
	       double factorPAH=factorPA*factorH;
	       System.out.println("Factor PAH : "+factorPAH);
	       double factorPAW=factorPA*factorW;
	       System.out.println("Fcator PAW : "+factorPAW);
	       
	       double factorPAHW=0;
	       factorPAHW=factorPAH+factorPAW;
	       System.out.println("factor PAHW : "+factorPAHW);
	       
	        double factorA=0;
	        if(reg.getGender().equals("0")){
	        	factorA=(-9.53)*age;
	        	System.out.println("Factor A : "+factorA);
	        }else{
	        	factorA=(-6.91)*age;
	        	System.out.println("Factor A : "+factorA);
	        }
	       
	        double factorS=0;////Assign Sex Factor (SF)
	        if(reg.getGender().equals("0")){
	        	factorS=662;
	        	System.out.println("Factor S : "+factorS);
	        }
	        else{
	        	factorS=354;
	        	System.out.println("Factor A : "+factorS);
	        }
	        
	        double totalEER=0;
	        totalEER=factorS+factorA+factorPAHW;
	        System.out.println("Total EER : "+totalEER);
	        
	        double result=0;
	        result=(totalEER);
	 		System.out.println("Result : "+result);
		 	
	}
	 
		
}
