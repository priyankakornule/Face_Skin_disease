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
 * Servlet implementation class RegistrationController
 */
@WebServlet("/RegistrationController")
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationController() {
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
		doGet(request, response);
		
		//uid, fname, lname, contact, email, pass
	    String fname=request.getParameter("fname");
	    String lname=request.getParameter("lname");
	    String contact=request.getParameter("contact");
	    String email=request.getParameter("email");
	    String pass=request.getParameter("pass");
	    
	     Register register=new Register();
	     register.setFname(fname);
	     register.setLname(lname);
	     register.setContact(contact);
	     register.setEmail(email);
	     register.setPass(pass);

	     Register reg=DataAccessLayer.getEmail(register);
	    
	     String str=reg.getEmail();
		  
	       if(str == null){
	    	   
	 
	     int i=DataAccessLayer.getInsertRegistration(register);
	     
	     if(i != 0 ){
	    	 response.sendRedirect("login.jsp");
	     }else{
	    	 response.sendRedirect("register.jsp");
	     }
	     
	     }else{
	    	 response.sendRedirect("emailExist.jsp");
	     }
	     
	     
	}

}
