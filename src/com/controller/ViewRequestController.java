package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.model.Register;

/**
 * Servlet implementation class ViewRequestController
 */
@WebServlet("/ViewRequestController")
public class ViewRequestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewRequestController() {
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
		
		int aid=Integer.parseInt(request.getParameter("aid"));
		System.out.println("aid=====>"+aid);
		
		int uid=Integer.parseInt(request.getParameter("uid"));
		System.out.println("uid=====>"+uid);
		
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		String dis=request.getParameter("dis");
		
		out.println("<script type=\"text/javascript\">");
		out.println("alert('Inserted Appoinment Details......');");
		out.println("location='fillForm.jsp';");
		out.println("</script>");
		
		
		
		
	}
	

}
