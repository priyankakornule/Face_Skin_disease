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
        <body> <nav class="navbar navbar-default navbar-fixed-top" role="navigation">
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
                        <a class="navbar-brand" href="#">Face Skin Disease</a>
                    </div>

                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                        <ul class="nav navbar-nav main-nav  clear navbar-right ">
                            <li><a class="navactive color_animation" href="home.jsp">HOME</a></li>
                          
                           <li><a class="navactive color_animation" href="Logout_controller">LOGOUT</a></li>
                        </ul>
                    </div><!-- /.navbar-collapse -->
                </div>
            </div><!-- /.container-fluid -->
        </nav>
         
        <div id="top" class="starter_container8 bg">
            <div class="follow_container">
                <div class="col-md-6 col-md-offset-3">
                  	<center>
		<h3>
		<%
		int uid=Integer.parseInt(session.getAttribute("uid").toString());
		
		String dis = (String)session.getAttribute("Dis");
                    		System.out.println("DIS : "+dis);
			BufferedImage img = (BufferedImage) session
					.getAttribute("image");
			
			System.out.println("Test Jsp image : "+img);
		// String testDirectory = "C:/Users/KasNet-9/Desktop/Supriya/Document/IoT/Automatic Ocular Disease Screening and Monitoring using Hybrid Cloud System/Code/Demo/images/testset/";
		%>
	</h3>
	<%
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ImageIO.write(img, "jpg", baos);
		baos.flush();
		byte[] imageInByteArray = baos.toByteArray();
		baos.close();
		String b64 = javax.xml.bind.DatatypeConverter.printBase64Binary(imageInByteArray);
	%>

	<div style="font-size: 28px;    color: brown;" >
		
		<img src="data:image/jpg;base64, <%=b64%>" style="border-radius: 22px; height: 250px; width:250px; margin-left: -29%;     margin-left: 15%;"  alt="Visruth.jpg not found" align="left"  />&nbsp;
		<%-- <%

	     boolean VERBOSE = true;

	     int imageSize = 32;

//	    private static double etaabs = 0.00001;
	     double eta = .01;
	 
		
		 ConvolutionalNeuralNetwork cnn = ConvolutionalNeuralNetwork.builder().setInputHeight(imageSize)
                .setInputWidth(imageSize)
                .appendConvolutionLayer(ConvolutionLayer.newBuilder().setConvolutionSize(3, 5, 5).setNumConvolutions(20).build())
                .appendPoolingLayer(PoolingLayer.newBuilder().setWindowSize(2, 2).build())
                .appendConvolutionLayer(ConvolutionLayer.newBuilder().setConvolutionSize(1, 5, 5).setNumConvolutions(20).build())
                .appendPoolingLayer(PoolingLayer.newBuilder().setWindowSize(2, 2).build())
                .appendConvolutionLayer(ConvolutionLayer.newBuilder().setConvolutionSize(1, 3, 3).setNumConvolutions(20).build())
                .setFullyConnectedDepth(1).setFullyConnectedWidth(300).setFullyConnectedActivationFunction(SIGMOID)
                .setLearningRate(eta).setMaxEpochs(1).build();
		 
		 String testDirectory = "E://imgeprojecttesting//Calorie_Estimation//Image//TestSet//";
		 DataSet testSet = new DataSet(testDirectory);
		 

		 System.out.println("Size of list :::: " + Category.categories.size());
		 
		 /* for(PredictionValues data :  PredictionValues.predictions){
			 
			 System.out.println("Category Retriving ::: "+ data.getActual());
			 System.out.println("Category Retriving ::: "+ data.getCrorrectPredicted());
			 System.out.println("Category Retriving ::: "+ data.getPredicted());
			 System.out.println("Category Retriving ::: "+ data.getTotalPredicted());
		
		} */
		 
	
		%> --%>
			
	
		<%

/* PredictionValues data=PredictionValues.predictions.get(PredictionValues.predictions.size()-1); */

%>


<p class="formfield" vertical-align="middle" ><font color: "#191970" style="margin-left: 6%;font-family: Lobster, serif;font-size: 40px; ">Disease Predicted:</font>
<textarea name="food" rows="2" cols="30" font style="font-family:Yu Gothic UI;font-size:20px; color:#191970;    margin-top: -113px;
    margin-left: 60%;" readonly="readonly"><%=dis%> </textarea> </p>
    
    <%---------------check these code for show fatal Non_fatal --%>
   <%--  <% out.print(dis);%> --%><br>
     <%if(dis.equals("Pemphigus_vulgaris")||dis.equals("Staphylococcal_scalded_skin_syndrome")||dis.equals("Stevens-Johnson_syndrome")||dis.equals("Toxic_epidermal_necrolysis")||dis.equals("Toxic_shock_syndrome"))
    {
    	out.print("This disease is Non_Fatal Disease");
    }else if(dis.equals("Herpes_zoster_shingles")||dis.equals("Hives"))
    {
    	
    	out.print("This disease is Fatal disease");
    }else
    {
    	out.print("This is Other");
    }
    
    %> 
	 <%-- <p class="formfield" vertical-align="middle" ><font color: "#191970" style="font-family: Lobster, serif;font-size: 40px; ">Disease Predicted:</font><textarea  rows="4" cols="40" font style="font-family:Yu Gothic UI;font-size:20px; color:#191970;"><%=data.getPredicted()%> </textarea> </p> --%>
  <%
   
     int imageId=(int)session.getAttribute("imageId");
    System.out.println("imageId: "+imageId);
    
  Connection con = DataAccessLayer.makeConnection();

  String update="UPDATE user_uploaded_images SET prediction=' "+dis+ " ' WHERE file_id= "+imageId;
  System.out.println(update);
  PreparedStatement statement1 = con.prepareStatement(update);
  statement1.executeUpdate();
%>  
	
	
	</div>

	<br>
	<!-- <a href="Prescription.jsp" style=" font-family: Yu Gothic UI; font-size: 40px; color: #191970;">Click Here </a><font color: "#191970" size="6" style=" font-family: Lobster, serif;font-size: 40px; ">for prescription....</font> -->
	<!--</center></div> -->
 <%-- <form action="GenereateReport" method="post">

<h3>Click here to generate and view Report</h3>
<input type="submit" name="bt" value="View Report">
<input type="hidden" name="uid" value="<%=uid%>">
<input type="hidden" name="iid" value="<%=imageId%>">
<input type="hidden" name="disease" value="<%=dis%>">

</form> --%> 
 <a href="Prescription.jsp" style=" font-family: Yu Gothic UI; font-size: 40px; color: #191970;">Click Here </a><font color: "#191970" size="6" style=" font-family: Lobster, serif;font-size: 40px; ">for Report....</font>
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
>