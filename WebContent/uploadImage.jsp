<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Face Skin Disease</title>
</head>


   
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

    <body>
    
<%
	response.setHeader("Pragma", "No-cache");
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	response.setDateHeader("Expires", -1);

	if (session.getAttribute("uid") == null) {
		response.sendRedirect("login.jsp");
		return;
	}
%>
<%
int uid=Integer.parseInt(session.getAttribute("uid").toString());
System.out.println("UserId : " +uid);
%> 

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
                        <a class="navbar-brand" href="#">Face Skin Disease</a>
                    </div>

                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                        <ul class="nav navbar-nav main-nav  clear navbar-right ">
                            <li><a class="navactive color_animation" href="home.jsp">HOME</a></li>
                            <li><a class="navactive color_animation" href="uploadImage.jsp">UPLOAD IMAGE</a></li>
                            <li><a class="navactive color_animation" href="Logout_controller">LOGOUT</a></li>  
                            
                        </ul>
                    </div><!-- /.navbar-collapse -->
                </div>
            </div><!-- /.container-fluid -->
        </nav>
         
        <div id="top" class="starter_container1 bg">
            <div class="follow_container">
             
               <form action="UploadImageController" method="post" enctype="multipart/form-data">
              
				<div class='resp_code align='center' style=" box-shadow: 0 0 2em #041d19; background-color: #f5f5f5a6;   background-color: rgba(241, 231, 233, black); margin-top: 72px;  width: 531px;  margin-left: 426px;">
				<table id='tab' align='center' 
					style="width: 100%;">
				
				<br><br><br>
					<input type="file" name="file" id="file-1" class="inputfile inputfile-1" data-multiple-caption="{count} files selected" multiple style=" margin-top: -2%; margin-left: 2%;" />
					<label for="file-1" style=" margin-top: 3%; margin-bottom: `; margin-bottom: 1%;"><svg xmlns="http://www.w3.org/2000/svg" width="20" height="17" viewBox="0 0 20 17"><path d="M10 0l-5.2 4.9h3.3v5.1h3.8v-5.1h3.3l-5.2-4.9zm9.3 11.5l-3.2-2.1h-2l3.4 2.6h-3.5c-.1 0-.2.1-.2.1l-.8 2.3h-6l-.8-2.2c-.1-.1-.1-.2-.2-.2h-3.6l3.4-2.6h-2l-3.2 2.1c-.4.3-.7 1-.6 1.5l.6 3.1c.1.5.7.9 1.2.9h16.3c.6 0 1.1-.4 1.3-.9l.6-3.1c.1-.5-.2-1.2-.7-1.5z"/></svg> <span>Choose a file&hellip;</span></label>
					<br>
					<input type="submit" value="Upload Image" style=" margin-bottom: 4%; /* margin-top: 3%; */">
				<input type="hidden" name="uid" value="<%=uid %>"/>
					</table>
				</div>
				
				
				
			</form>
            </div>
        </div>

        <!-- ============ About Us ============= -->

        <section id="story" class="description_content">
            <div class="text-content container">
                <div class="col-md-6">
                    <h1>About us</h1>
                   <!--  <div class="fa fa-cutlery fa-2x"></div> -->
                     <p class="desc-text">Within lies one of Best hospitals, offering residential accommodation to its doctors and staff, and facilitating a premier department of emergency medicine and centers of excellence for key super specialties.</p>
                </div>
                <div class="col-md-6">
                    <div class="img-section">
                       <img src="images/d1.jpg" width="250" height="220">
                       <img src="images/d2.jpg" width="250" height="220">
                       <div class="img-section-space"></div>
                       <img src="images/d3.jpg"  width="250" height="220">
                       <img src="images/d4.jpg"  width="250" height="220">
                   </div>
                </div>
            </div>
        </section>


      
        <!-- ============ Footer Section  ============= -->

        <footer class="sub_footer" style="
    margin-top: 2%;
">
            <div class="container">
                <div class="col-md-4"><p class="sub-footer-text text-center">&copy; Hospital 2014, Theme by <a href="https://themewagon.com/">ThemeWagon</a></p></div>
                <div class="col-md-4"><p class="sub-footer-text text-center">Back to <a href="#top">TOP</a></p>
                </div>
                <div class="col-md-4"><p class="sub-footer-text text-center">Built With Care By <a href="#" target="_blank">Us</a></p></div>
            </div>
        </footer>


        
        <script type="text/javascript" src="js/bootstrap.min.js" ></script>
        <script type="text/javascript" src="js/jquery-1.10.2.js"></script>     
        <script type="text/javascript" src="js/jquery.mixitup.min.js" ></script>
        <script type="text/javascript" src="js/main.js" ></script>

    </body>
</html>
>