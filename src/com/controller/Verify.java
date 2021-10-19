
package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.DataAccessLayer;
import com.model.Register;


/**
 * Servlet implementation class Verify
 */
@WebServlet("/Verify")
public class Verify extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		String eneteredOTP=request.getParameter("code");
		HttpSession session=request.getSession();
		String generatedOTP=session.getAttribute("OTP").toString();
		System.out.println("Entered OTP : "+eneteredOTP);
		System.out.println("Generated OTP : "+generatedOTP);
		
		if(eneteredOTP.equals(generatedOTP))
		{
			System.out.println("Valid OTP ");
			
				response.sendRedirect("resetPassword.jsp");
			}
		else {
			response.sendRedirect("error.jsp");
		}
		}
	
}
