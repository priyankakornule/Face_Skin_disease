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


@WebServlet("/GenereateReport")
public class GenereateReport extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int uid=Integer.parseInt(request.getParameter("uid").toString());
		int iid=Integer.parseInt(request.getParameter("iid").toString());
		String dis=request.getParameter("disease");	
		
		
		Register helth=DataAccessLayer.getHealthFormInfo(uid);
		
		helth.setDis(dis);
		
		 HttpSession session=request.getSession();
		 session.setAttribute("uinfo",helth);
		 session.setAttribute("uid",uid);
		
			response.sendRedirect("viewreport.jsp");
		
			
		
	}

}
