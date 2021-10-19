
package com.controller;
import java.awt.image.BufferedImage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.imageio.ImageIO;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.model.Register;
import com.DAO.DataAccessLayer;
import com.itextpdf.text.*;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import com.utility.SendMail;
import com.utility.SendMail2;


@WebServlet("/ReportDownload")
public class ReportDownload extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		Document document = new Document();
		try
		{
				
			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\HP\\Desktop\\report.pdf"));
			document.open();

						
            //FONT COLOUR - color
            Font fontColour_style =  FontFactory.getFont(FontFactory.TIMES, 18f, Font.BOLD, BaseColor.BLACK);          		
			Paragraph p=new Paragraph(" Face Skin Disease Detection Report",fontColour_style);
			p.setAlignment(Element.ALIGN_CENTER);
			document.add(p);
			
			
			Font fontColour_style1 =  FontFactory.getFont(FontFactory.TIMES, 14f, Font.BOLD, BaseColor.RED);          		
			Paragraph p1=new Paragraph("Status Report",fontColour_style1);
			p1.setAlignment(Element.ALIGN_CENTER);
			document.add(p1);
			
						
			PdfPTable table = new PdfPTable(4); //number of columns
			table.setSpacingBefore(12f);
			table.setTotalWidth(400f);  
			table.setLockedWidth(true); 
			Font fontColour_style2 =  FontFactory.getFont(FontFactory.TIMES, 12f, Font.BOLD, BaseColor.BLUE); 
			PdfPCell header = new PdfPCell(new Phrase(" Face Skin Disease Prediction", fontColour_style2));
			header.setExtraParagraphSpace(8f);
			header.setHorizontalAlignment(Element.ALIGN_LEFT);
			header.setColspan(4);  
			table.addCell(header); 
			
			
			PdfPTable nested = new PdfPTable(2);
			
			table.setWidths(new int[]{700,700,0,0});
			Font fontColour_style3 =  FontFactory.getFont(FontFactory.TIMES, 10f,  BaseColor.BLACK); 
			
			HttpSession session=request.getSession();
			int uid=(int) session.getAttribute("uid");
			Register r=DataAccessLayer.getInfo(uid);
			
	
			String username=r.getFname();
			String lastname=r.getLname();
			String email=r.getEmail();
			
			
			System.out.println("username =============> "+r.getFname());
			
			System.out.println("lastname =============> "+r.getLname());
			
			
			
			
			String dis=(String) session.getAttribute("Dis");
			
			String pred;


			if(dis.equals("Pemphigus_vulgaris"))
			{
				pred="Pemphigus_vulgaris";
			}
			else if(dis.equals("Staphylococcal_scalded_skin_syndrome"))
			{
				pred="Staphylococcal_scalded_skin_syndrome";
			}
			else if(dis.equals("Stevens-Johnson_syndrome"))
			{
				pred="Stevens-Johnson_syndrome";
			}
			else if(dis.equals("Toxic_epidermal_necrolysis"))
			{
				pred="Toxic_epidermal_necrolysis"; 
			}
			else if(dis.equals("Toxic_shock_syndrome"))
			{
				pred="Toxic_shock_syndrome"; 
			}
			else if(dis.equals("Herpes_zoster_shingles"))
			{
				pred="Herpes_zoster_shingles";
			}
			else if(dis.equals("Hives"))
			{
				pred="Hives";
			}
			else 
			{
				pred="OTHER";
			}
			
			

			
			System.out.println("username in report"+username);
			System.out.println("lastname in report"+lastname);
			System.out.println("email in report"+email);
		
			System.out.println("disease name in report"+pred);
			
	
			
			
			nested.addCell(new PdfPCell(new Phrase("User Name",fontColour_style3)));  
			nested.addCell(username);
			
			nested.addCell(new PdfPCell(new Phrase("Last Name",fontColour_style3)));  
			nested.addCell(lastname);
			
			nested.addCell(new PdfPCell(new Phrase("Email",fontColour_style3)));  
			nested.addCell(email);
			
			
			
			nested.addCell(new PdfPCell(new Phrase("Disease",fontColour_style3)));
			nested.addCell(pred);
			
			
			
			
			PdfPCell nesthousing = new PdfPCell(nested);  
			table.addCell(nesthousing); 
			
			BufferedImage bi= (BufferedImage) session.getAttribute("image");
			System.out.println(bi);
		    File outputfile = new File("C:\\Users\\HP\\Desktop\\saved.jpg");
		    ImageIO.write(bi, "jpg", outputfile);
		    			
			PdfPCell bottom = new PdfPCell(new Phrase("bottom"));
			Image img = Image.getInstance("C:\\Users\\HP\\Desktop\\saved.jpg");
			
			bottom.setColspan(3);
			bottom.addElement(img);
			table.addCell(bottom);  
			document.add(table);
			document.close();         
			writer.close();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
				
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String gurufile = "report.pdf";
		String gurupath = "C:\\Users\\HP\\Desktop\\";
		response.setContentType("APPLICATION/OCTET-STREAM");
		response.setHeader("Content-Disposition", "attachment; filename=\"" + gurufile + "\"");

		FileInputStream fileInputStream = new FileInputStream(gurupath + gurufile);

		int i;
		while ((i = fileInputStream.read()) != -1) 
		{
			out.write(i);
		}
		fileInputStream.close();
		out.close();
		
	
		
		HttpSession session=request.getSession();
		int uid=(int) session.getAttribute("uid");
		Register r=DataAccessLayer.getInfo(uid);
		
		//HttpSession session=request.getSession();
		String username=r.getFname();
		String lastname=r.getLname();
		String email=r.getEmail();
		
		
		
		
		System.out.println("username =============> "+username);
		
		System.out.println("the email in report "+email);
		try {
			//SendMail.sendEmail(email, document);
			SendMail2.sendEmail(email, document);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
