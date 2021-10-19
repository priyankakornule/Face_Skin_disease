package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.DataAccessLayer;
import com.model.HealthForm;
import com.model.Register;

/**
 * Servlet implementation class AddUser
 */
@WebServlet("/AddUser")
public class AddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUser() {
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


		PrintWriter out=response.getWriter();
		
		 String uid1=request.getParameter("uid");
			int uid=Integer.parseInt(uid1);
			System.out.println("uid  "+uid);
			
		/* String hid1=request.getParameter("hid");
		int hid=Integer.parseInt(hid1);*/
         int  age=0;
	     try{
	    	 age=Integer.parseInt(request.getParameter("age"));
		     System.out.println("age : "+age);
	     }catch(NumberFormatException e){
	    	 e.printStackTrace();
	     }
	     
	     
	     
	     String gender=request.getParameter("gender");
	     System.out.println("gender :"+gender);

	     String height=request.getParameter("foot");
	     
	     double cms=Double.parseDouble(request.getParameter("height"));
	     System.out.println("cms "+cms);
	     
	     double weight=Double.parseDouble(request.getParameter("weight"));
	     
	     String activeness=request.getParameter("activeness");
	     System.out.println("ACtive : "+activeness);
	     
	 
		
	     Register reg=new Register();
	     reg.setAge(age);
	     reg.setGender(gender);
	     reg.setHeight(height);
	     reg.setCms(cms);
	     reg.setWeight(weight);
	     reg.setActiveness(activeness);
	     
	     // Boolean flag = false;
			//String updateFlag = "updated";
			if (uid != 0) {
				System.out.println("if loop");
				int hid=DataAccessLayer.getHealthUpdate(reg,uid);
				//flag = true;
				System.out.println("hid"+hid);
				
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Inserted Successfully......');");
				out.println("location='CalculateBmi.jsp';");
				out.println("</script>");
				
			} else {
				System.out.println("else loop");
				 
				out.println("<script type=\"text/javascript\">");
				out.println("alert('updated UnSuccessfully......');");
				out.println("location='healthForm.jsp';");
				out.println("</script>");
			}

			
		}
		
		
	

}
