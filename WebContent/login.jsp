<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Face Skin Disease</title>
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
        
       <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0">
		<link rel="stylesheet" href="./Sky Forms_files/demo.css">
		<link rel="stylesheet" href="./Sky Forms_files/sky-forms.css">
		
		
		
	


    </head>
	
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
                        <a class="navbar-brand" href="#">Face Skin Disease</a>
                    </div>

                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                        <ul class="nav navbar-nav main-nav  clear navbar-right ">
                            <li><a class="navactive color_animation" href="index.jsp">WELCOME</a></li>
                            <li><a class="navactive color_animation" href="register.jsp">REGISTRATION</a></li>
                            <li><a class="navactive color_animation" href="login.jsp">LOGIN</a></li>
                            <li><a class="navactive color_animation" href="#story">ABOUT</a></li>
                            
                        </ul>
                    </div><!-- /.navbar-collapse -->
                </div>
            </div><!-- /.container-fluid -->
        </nav>
        
        <div id="top" class="starter_container bg">
            <div class="follow_container">
            
                <div class="col-md-6 col-md-offset-3">
                 <div style="background-color: #4a424280; background-size:500px">
                <br>
                   <form name="Reg" action="LoginController" class="sky-form" method="post"autocomplete="off">
				 <h1 style="color: white;">Login</h1>
				<table style="margin-left: 28%;">
				<fieldset>	
				
					<tr><section>
						<label class="input">
							<i class="icon-append icon-envelope-alt"></i>
							<td style="color: white;">Email :</td><td> <input type="email" name="email" placeholder="Email address" required="true"style=" background: #fbf5fac7; ">
							</td>
						</label>
					</section>
					</tr>
					<tr><section>
						<label class="input">
							<i class="icon-append icon-lock"></i>
							<td style="color: white;">Password:</td><td> <input type="password" name="pass" id="pass" placeholder="Password"   required="true" minlength="8"style=" background: #fbf5fac7; ">
							</td>
						</label>
					</section>
					</tr>
					
				</fieldset>
				</table>
				<footer>
				
					<button type="submit" name="submit" value="submit" class="button" id="submit"  style="margin-left: 41%; color: white;">Login</button>
					<br><a href="forgotpassword.jsp" style="color: #bcc2ce;">Forget Password</a> 
				</footer>
			</form>	
					<br>
                </div>
                </div>
            </div>
        </div>

       

        <!-- ============ Footer Section  ============= -->

        <footer class="sub_footer" style="margin-top: -1%;">
            <!-- <div class="container">
                <div class="col-md-4"><p class="sub-footer-text text-center">&copy; Hospital 2014, Theme by <a href="https://themewagon.com/">ThemeWagon</a></p></div>
                <div class="col-md-4"><p class="sub-footer-text text-center">Back to <a href="#top">TOP</a></p>
                </div>
                <div class="col-md-4"><p class="sub-footer-text text-center">Built With Care By <a href="#" target="_blank">Us</a></p></div>
            </div> -->
        </footer>


        <script type="text/javascript" src="js/jquery-1.10.2.min.js"> </script>
        <script type="text/javascript" src="js/bootstrap.min.js" ></script>
        <script type="text/javascript" src="js/jquery-1.10.2.js"></script>     
        <script type="text/javascript" src="js/jquery.mixitup.min.js" ></script>
        <script type="text/javascript" src="js/main.js" ></script>

    </body>
</html>
