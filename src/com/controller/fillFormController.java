package com.controller;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.DataAccessLayer;
import com.model.Appoinment;
import com.utility.SendMail2;

/**
 * Servlet implementation class fillFormController
 */
@WebServlet("/fillFormController")
public class fillFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public fillFormController() {
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
		
		System.out.println("fillFormController");
		
		int uid=Integer.parseInt(request.getParameter("uid"));
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		String email=request.getParameter("email");
		String dis=request.getParameter("dis");
		String date=request.getParameter("date1");
		String time=request.getParameter("usr_time");
		String place=request.getParameter("place");
		String status=request.getParameter("status");
		
		
		Appoinment app=new Appoinment();
		app.setDate(date);
		app.setTime(time);
		app.setPlace(place);
		app.setFname(fname);
		app.setLname(lname);
		app.setDis(dis);
	
		app.setStatus(status);
		
		int aid=DataAccessLayer.insertFixtimeDate(app,uid);
		
/*	String email="amegha.narote@outlook.com";*/
		if(aid !=0 ){
		
			System.out.println("the email in report "+email);
			try {
				
				/*SendMail2.sendEmail2(em,fname, lname, dis, date, time, place);*/
				SendMail2.sendEmail2(email, fname, lname, dis, date, time, place);
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("viewRequest.jsp");
		}
		
	}

}
