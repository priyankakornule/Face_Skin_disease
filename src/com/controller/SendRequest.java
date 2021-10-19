package com.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.DataAccessLayer;
import com.model.Register;

/**
 * Servlet implementation class SendRequest
 */
@WebServlet("/SendRequest")
public class SendRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendRequest() {
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
		
		int uid=Integer.parseInt(request.getParameter("uid"));
		System.out.println("uid=====>"+uid);
		
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		String dis=request.getParameter("dis");
		System.out.println("dis=="+dis);
		Register reg=new Register();
		
		reg.setFname(fname);
		reg.setLname(lname);
		reg.setDis(dis);
		
		int aId=DataAccessLayer.insertAppoinment(uid,reg);
		System.out.println("aID===============> "+aId);
		if(aId != 0){
			HttpSession session=request.getSession();
			session.setAttribute("aId", aId);
			response.sendRedirect("index.jsp");
		}
		else
		{
			String msg="Already Fix the Appoinment...!!!";
			HttpSession session=request.getSession();
			session.setAttribute("msg",msg);
			response.sendRedirect("appoinment.jsp");
			
			
			
		}
	}
 
}
