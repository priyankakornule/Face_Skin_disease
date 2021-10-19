<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.awt.image.BufferedImage"%>
<%@ page import="javax.imageio.ImageIO"%>
<%@ page import="java.io.*"%>
<%@ page import="java.sql.Connection,java.sql.PreparedStatement"%>
<%@ page import="com.data.Category"%>
<%@ page import="com.data.DataSet"%> 
<%@ page import="com.DAO.*"%> 
<%@ page import="com.data.Instance"%> 
<%@ page import="com.model.*"%> 
<%@ page import="java.util.ArrayList, java.util.Arrays,  java.util.List"%>
<%@ page import="com.cnn.ConvolutionLayer, com.cnn.ConvolutionalNeuralNetwork, com.cnn.PoolingLayer, static com.cnn.ActivationFunction.SIGMOID"%>
<%@ page import="javax.servlet.http.HttpSession, javax.servlet.ServletException, javax.servlet.annotation.WebServlet, javax.servlet.http.HttpServlet, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Face Skin Disease</title>
</head>
<style>
td, th {
    padding: 3%;
}
</style>
<body>


   
        <link rel="stylesheet" href="css/normalize.css">
        <link rel="stylesheet" href="css/main.css" media="screen" type="text/css">
        <link href='http://fonts.googleapis.com/css?family=Pacifico' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Playball' rel='stylesheet' type='text/css'>
        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="css/style-portfolio.css">
        <link rel="stylesheet" href="css/picto-foundry-food.css" />
        <link rel="stylesheet" href="css/jquery-ui.css">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/font-awesome.min.css" rel="stylesheet">
        <link rel="icon" href="favicon-1.ico" type="image/x-icon">
    </head>
<%
	response.setHeader("Pragma", "No-cache");
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	response.setDateHeader("Expires", -1);

	if (session.getAttribute("uid") == null) {
		response.sendRedirect("login.jsp");
		return;
	}
%>
    <body>

        <nav class="navbar navbar-default navbar-fixed-top" role="navigation">
            <div class="container">
                <div class="row">
                <!-- Brand and toggle get grouped for better mobile display -->
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand" href="#"> Face Skin Disease</a>
                    </div>

                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                        <ul class="nav navbar-nav main-nav  clear navbar-right ">
                            <li><a class="navactive color_animation" href="#top">HOME</a></li>
                            <li><a class="navactive color_animation" href="EuploadImage.jsp">UPLOAD IMAGE</a></li>
                             <li><a class="navactive color_animation" href="appoinment.jsp">APPOINMENT</a></li>
                                <li><a class="navactive color_animation" href="Logout_controller">LOGOUT</a></li>
                           <!-- <li><a class="navactive color_animation" href="#story">ABOUT</a></li> -->
                            
                        </ul>
                    </div><!-- /.navbar-collapse -->
                </div>
            </div><!-- /.container-fluid -->
        </nav>
         
         <div id="top" class="starter_container8 bg">
        <div>
          <!--   <div class="follow_container"> -->
            <!--     <div class="col-md-6 col-md-offset-3"> -->

<%

int uid=Integer.parseInt(session.getAttribute("uid").toString());
         System.out.println("ID======> : "+uid);          		

            		String dis = (String)session.getAttribute("Dis");
            		System.out.println("DIS : "+dis);
            		
            		
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

        			
            		
          		
  
%>

<%-- <%=symptom %>
<%=remi %> --%>

<h1 align="center" style="margin-top: 10%">Analysis Report</h1>
	<br>
	
	
				<br> 

			<form action="ReportDownload" method="post">
				<table border="2"
					style="margin-top: 1%;    width: 45%;  margin-left: 25%; border-spacing: 10px 20px;"
					border="0" cellspacing="5" height="2">
                    
                    
                   <%--  <tr style="font-size: 20px">
						<td><b>First Name:</b></td>
						<td><%=fname%></td>
					</tr>
					
					
                     <tr style="font-size: 20px">
						<td><b>Last Name:</b></td>
						<td><%=lname%></td>
					</tr>
					
					
					 <tr style="font-size: 20px">
						<td><b>Gender:</b></td>
						<td><%=gender%></td>
					</tr>
                    
					
					 <tr style="font-size: 20px">
						<td><b>Age:</b></td>
						<td><%=age%></td>
					</tr>
					
					 <tr style="font-size: 20px">
						<td><b>Bloodgroup:</b></td>
						<td><%=bloodgroup%></td>
					</tr>
 --%>
                    

					<tr style="font-size: 20px">
						<td><b>Disease Name:</b></td>
						<td><%=pred%></td>
					</tr>

					

					<%-- <tr style="font-size: 20px">
						<td><b>Medicine:</b></td>
						<td><%=remi%></td>
					</tr> --%>
					
				<%-- 	<tr style="font-size: 20px">
						<td><b>Disease Info:</b></td>
						<td><%=disinfo%></td>
					</tr>
  --%>
                  
				</table>
				<input type="submit" value="Download Report" class="button" style="margin-left: 42%;">
				</td>

			</form>
			
			
			
			<br> 
                </div>
            </div>
        </div>


       
      

       
        
       
     

        <!-- ============ Footer Section  ============= -->

        <footer class="sub_footer" style="
    margin-top: 2%;
">
            <div class="container">
                <div class="col-md-4"><p class="sub-footer-text text-center">&copy; Restaurant 2014, Theme by <a href="https://themewagon.com/">ThemeWagon</a></p></div>
                <div class="col-md-4"><p class="sub-footer-text text-center">Back to <a href="#top">TOP</a></p>
                </div>
                <div class="col-md-4"><p class="sub-footer-text text-center">Built With Care By <a href="#" target="_blank">Us</a></p></div>
            </div>
        </footer>


        <script type="text/javascript" src="js/jquery-1.10.2.min.js"> </script>
        <script type="text/javascript" src="js/bootstrap.min.js" ></script>
        <script type="text/javascript" src="js/jquery-1.10.2.js"></script>     
        <script type="text/javascript" src="js/jquery.mixitup.min.js" ></script>
        <script type="text/javascript" src="js/main.js" ></script>

    </body>
</html>
