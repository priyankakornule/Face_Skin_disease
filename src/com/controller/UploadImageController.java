package com.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.DAO.DataAccessLayer;
import com.cnn.Recog;

@WebServlet("/UploadImageController")
@MultipartConfig(maxFileSize = 52428800)  // upload file's size up to 16MB
public class UploadImageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fileName="";
		
		Connection con=DataAccessLayer.makeConnection();
		InputStream inputStream = null; // input stream of the upload file
		Part filePart = request.getPart("file");
	
		int uid=Integer.parseInt(request.getParameter("uid"));
		
		
	
		if (filePart != null) {
			System.out.println(filePart.getContentType());
			System.out.println(filePart.getName());
			fileName =  Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
			System.out.println(fileName);
			
			inputStream = filePart.getInputStream();
			//flag = Recog.imageValidation(inputStream,fA);
			
		}

		
		String message = null; 
		if(filePart!=null)

		{
		try {
		
				// constructs SQL statement
			String sql= "insert into user_uploaded_images(user_id,image,prediction,date,time) "
					+ "values (?,?,?,curdate(),curtime())";
			System.out.println(sql);
			System.out.println("After insert");
			PreparedStatement statement = con.prepareStatement(sql);
			inputStream = filePart.getInputStream();

			if (inputStream != null) {
				// fetches input stream of the upload file for the blob column
				statement.setInt(1, uid);
				statement.setBlob(2, inputStream);
				statement.setString(3,fileName);
				
			}

			// sends the statement to the database server
			int file_id = statement.executeUpdate();
			if (file_id > 0) {
				message = "File uploaded and saved into database";
			}


		} catch (SQLException ex) {
			message = "ERROR: " + ex.getMessage();
			ex.printStackTrace();
			
			//request.setAttribute("Message", message);
			getServletContext().getRequestDispatcher("/UploadFail.jsp").forward(request, response);
		} finally {
			if (con != null) {
				// closes the database connection
				try {
					con.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
			// sets the message in request scope
			request.setAttribute("Message", message);
         
			// forwards to the message page 
			getServletContext().getRequestDispatcher("/Predicition.jsp").forward(request, response);
			//getServletContext().getRequestDispatcher("/imageSegmentation.jsp").forward(request, response);
			
		}
		}
		else
		{
			System.out.println("Given image is not valid!!!");
			String msg = "Given image is not valid!!!";
			HttpSession session1 = request.getSession();
			
			
			session1.setAttribute("Msg", msg);
			response.sendRedirect("UploadFail.jsp");
			
		}
	}

		
		
		
		
		
		
	}


