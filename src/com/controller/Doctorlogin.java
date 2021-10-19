package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class doctorlogin
 */
@WebServlet("/doctorlogin")
public class Doctorlogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Doctorlogin() {
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
		
		String email=request.getParameter("email");
		System.out.println("admin==="+email);
		String password=request.getParameter("pass");
		System.out.println("pwd==="+password);
		
		if(email.equals("admin@gmail.com")&&password.equals("admin@123"))
		{
		
		 request.setAttribute("errorMessage", "Welcome doctor ");
         RequestDispatcher rd = request.getRequestDispatcher("doctorwelcome.jsp");
         rd.forward(request, response); 
			
		}
		else
		{
			
            request.setAttribute("errorMessage", "Invalid user or password");
            RequestDispatcher rd = request.getRequestDispatcher("doctorlogin.jsp");
            rd.forward(request, response); 
		}	
		
		
	}

}
