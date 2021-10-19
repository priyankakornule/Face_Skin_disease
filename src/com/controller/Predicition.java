package com.controller;

//import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
//import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.DataAccessLayer;

import com.driver.Driver;

import main.Classify;

//import static com.driver.Driver.VERBOSE;

/**
 * Servlet implementation class Predicition
 */
@WebServlet("/Predicition")
public class Predicition extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Predicition() {
		super();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	//@SuppressWarnings("static-access")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int iid=DataAccessLayer.getImgId();
		BufferedImage img;
		int height = 500;
		int width = 500;
		
		


		try {
			System.out.println("in Prediciton.java try");
			img = DataAccessLayer.fetchGrayImages(iid);
			String name= DataAccessLayer.fetchGrayImages2(iid);
			BufferedImage buffer1= new BufferedImage(width, height,BufferedImage.TYPE_INT_RGB);
			buffer1.getGraphics().drawImage(img, 0, 0, width, height, null);
			
			//File f=new File("C://Gayatri_new//Skin_disease//Image//TestSet//"+name);
			File f=new File("E://Final Project//Face_Skin_disease//Image//TestSet//"+name);
			
			ImageIO.write(img,"jpg",f);
			
			String predict=Driver.main(name);
			
			HttpSession session=request.getSession();
			
			session.setAttribute("image",img);
			session.setAttribute("imageId",iid);
			session.setAttribute("Dis", predict);

			response.sendRedirect("Test.jsp");
			



		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	
		

	
		//DBCon.getImgId();
	
	}

}
