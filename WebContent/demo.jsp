<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
      
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Calorie-Estimator</title>
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
                        <a class="navbar-brand" href="#">Food Corner</a>
                    </div>

                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                        <ul class="nav navbar-nav main-nav  clear navbar-right ">
                            <li><a class="navactive color_animation" href="home.jsp">HOME</a></li>
                            <li><a class="navactive color_animation" href="healthForm.jsp">HEALTH FORM</a></li>
                            <li><a class="navactive color_animation" href="Logout_controller">LOGOUT</a></li>
                            
                        </ul>
                    </div><!-- /.navbar-collapse -->
                </div>
            </div><!-- /.container-fluid -->
        </nav>
         
        <div id="top" class="starter_container1 bg">
            <div class="follow_container" style="    margin-top: -6%;">
                
                 <div class="col-md-6 col-md-offset-3">
                 <div style="background-color: #4a424280; background-size:500px; margin-top: -5%;">
                    
                	<sql:setDataSource  var="myDS"  driver="com.mysql.jdbc.Driver"
    url="jdbc:mysql://localhost:3306/calorie_estimation"
    user="root" password="root"
/>
 
	<%
	
	int hid=Integer.parseInt(request.getParameter("hid").toString());
	System.out.println(hid);
	%> 
	
	<sql:query dataSource="${myDS}" var="result" sql="select * from  health_form where hid=?">	
          <sql:param value="<%=hid%>" ></sql:param>
    </sql:query>
	
	
	<br>
	<br>
	
	<i>Add User</i>
		</h1>
		<br>
		<form name="myForm" method="post" action="AddUser">
			
			<table align="center">
			<c:forEach var="row" items="${result.rows}">
			<input type="hidden" name="uid" value="<c:out value="${row.uid}" />"/>
			<input type="hidden" name="hid" value="<c:out value="${row.hid}" />"/>
				<tr>
				<!-- hid, age, gender, height, cms, weight, activeness, uid -->
					<td><font color="maroon">age</font><br>
					<br></td>

					<td><input type="text" name="age" value="<c:out value="${row.age}" />"/>
					<br>
					<br></td>
				</tr>
				<tr>
					<td><font color="maroon">gender</font><br>
					<br></td>

					<td><%-- <input type="radio" name="gender" value="<c:out value="${row.gen}" />"/> --%><br>
					<input type="radio" name="gen" value="male" id="gen" checked><font color="white" size="0.7"   style=" font-size: 70%;">Male</font>
											<input type="radio" name="gen" value="female" id="gen"><font color="white" size="0.7"style=" font-size: 70%;">Female</font></td>
					<br></td>
				</tr>
				<tr>
					<td><font color="maroon">height</font><br>
					<br></td>

					<td><%-- <input type="text" name="height" value="<c:out value="${row.height}" />"/> --%><br>
					<td><select style='width: 50%;' name="foot" id="foot"
											onchange="hcon()"><option value="1">1'</option>
												<option value="2">2'</option>
												<option value="3">3'</option>
												<option value="4">4'</option>
												<option value="5">5'</option>
												<option value="6">6'</option>
												<option value="7">7'</option></select><select style='width: 40%;'
											name="inch" id="inch" onchange="hcon()"><option
													value="1">1"</option>
												<option value="2">2"</option>
												<option value="3">3"</option>
												<option value="4">4"</option>
												<option value="5">5"</option>
												<option value="6">6"</option>
												<option value="7">7"</option>
												<option value="8">8"</option>
												<option value="9">9"</option>
												<option value="10">10"</option>
												<option value="11">11"</option></select></td>
					<br></td>
				</tr>
				<tr>
					<td><font color="maroon">cms</font><br> 
					
					<br></td>

					<td><%-- <input type="text" name="cms" value="<c:out value="${row.cms}" />"/> --%><br>
					<input type="text" name="height" id="cen" size="4"
											onkeyup="con(cen)" required true>
					<br></td>
				</tr>
				<tr>
					<td><font color="maroon">weight</font><br>
					<br></td>

					<td><%-- <input type="text" name="weight" value="<c:out value="${row.weight}" />"/> --%><br>
					<input type="text" name="weight" id="weight"
											maxlength="3" size="3" onkeyup="isNumberKey(this.id)">
					<br></td>
				</tr>
				<tr>
					<td><font color="maroon">activeness</font><br>
					<br></td>

					<td><%-- <input type="text" name="activeness" value="<c:out value="${row.activeness}" />"/> --%><br>
					<select style='width: 100px;' name="loa" id="loa">
										<option value="1"> Sedentary</option>
												<option value="2">Light Active</option>
												<option value="3">Moderately Active</option>
												<option value="4">Very Active</option>
												<option value="5"> Extra Active</option></select>
					<br></td>
				</tr>
				



				<tr align="center">
					<td> <font
						color="green"><button type="submit" name="login" value="" style="
    margin-right: -146%;
    margin-top: 12%;
">Update
								User</button></font></td>
				</tr>

			</c:forEach>
			</table>
			</form>
                </div>
            </div>
        </div>
        </div>
        

        <!-- ============ About Us ============= -->

        <section id="story" class="description_content">
            <div class="text-content container">
                <div class="col-md-6">
                    <h1>About us</h1>
                    <div class="fa fa-cutlery fa-2x"></div>
                    <p class="desc-text">Restaurant is a place for simplicity. Good food, good beer, and good service. Simple is the name of the game, and we’re good at finding it in all the right places, even in your dining experience. We’re a small group from Denver, Colorado who make simple food possible. Come join us and see what simplicity tastes like.</p>
                </div>
                <div class="col-md-6">
                    <div class="img-section">
                       <img src="images/kabob.jpg" width="250" height="220">
                       <img src="images/limes.jpg" width="250" height="220">
                       <div class="img-section-space"></div>
                       <img src="images/radish.jpg"  width="250" height="220">
                       <img src="images/corn.jpg"  width="250" height="220">
                   </div>
                </div>
            </div>
        </section>


       <!-- ============ Pricing  ============= -->


       <!--  <section id ="pricing" class="description_content">
             <div class="pricing background_content">
                <h1><span>Affordable</span> pricing</h1>
             </div>
            <div class="text-content container"> 
                <div class="container">
                    <div class="row">
                        <div id="w">
                            <ul id="filter-list" class="clearfix">
                                <li class="filter" data-filter="all">All</li>
                                <li class="filter" data-filter="breakfast">Breakfast</li>
                                <li class="filter" data-filter="special">Special</li>
                                <li class="filter" data-filter="desert">Desert</li>
                                <li class="filter" data-filter="dinner">Dinner</li>
                            </ul>@end #filter-list    
                            <ul id="portfolio">
                                <li class="item breakfast"><img src="images/food_icon01.jpg" alt="Food" >
                                    <h2 class="white">$20</h2>
                                </li>

                                <li class="item dinner special"><img src="images/food_icon02.jpg" alt="Food" >
                                    <h2 class="white">$20</h2>
                                </li>
                                <li class="item dinner breakfast"><img src="images/food_icon03.jpg" alt="Food" >
                                    <h2 class="white">$18</h2>
                                </li>
                                <li class="item special"><img src="images/food_icon04.jpg" alt="Food" >
                                    <h2 class="white">$15</h2>
                                </li>
                                <li class="item dinner"><img src="images/food_icon05.jpg" alt="Food" >
                                    <h2 class="white">$20</h2>
                                </li>
                                <li class="item special"><img src="images/food_icon06.jpg" alt="Food" >
                                    <h2 class="white">$22</h2>
                                </li>
                                <li class="item desert"><img src="images/food_icon07.jpg" alt="Food" >
                                    <h2 class="white">$32</h2>
                                </li>
                                <li class="item desert breakfast"><img src="images/food_icon08.jpg" alt="Food" >
                                    <h2 class="white">$38</h2>
                                </li>
                            </ul>@end #portfolio
                        </div>@end #w
                    </div>
                </div>
            </div>  
        </section> -->


        <!-- ============ Our Beer  ============= -->


      <!--   <section id ="beer" class="description_content">
            <div  class="beer background_content">
                <h1>Great <span>Place</span> to enjoy</h1>
            </div>
            <div class="text-content container"> 
                <div class="col-md-5">
                   <div class="img-section">
                       <img src="images/beer_spec.jpg" width="100%">
                   </div>
                </div>
                <br>
                <div class="col-md-6 col-md-offset-1">
                    <h1>OUR BEER</h1>
                    <div class="icon-beer fa-2x"></div>
                    <p class="desc-text">Here at Restaurant we’re all about the love of beer. New and bold flavors enter our doors every week, and we can’t help but show them off. While we enjoy the classics, we’re always passionate about discovering something new, so stop by and experience our craft at its best.</p>
                </div>
            </div>
        </section>


       ============ Our Bread  =============


        <section id="bread" class=" description_content">
            <div  class="bread background_content">
                <h1>Our Breakfast <span>Menu</span></h1>
            </div>
            <div class="text-content container"> 
                <div class="col-md-6">
                    <h1>OUR BREAD</h1>
                    <div class="icon-bread fa-2x"></div>
                    <p class="desc-text">We love the smell of fresh baked bread. Each loaf is handmade at the crack of dawn, using only the simplest of ingredients to bring out smells and flavors that beckon the whole block. Stop by anytime and experience simplicity at its finest.</p>
                </div>
                <div class="col-md-6">
                    <img src="images/bread1.jpg" width="260" alt="Bread">
                    <img src="images/bread1.jpg" width="260" alt="Bread">
                </div>
            </div>
        </section>


        
        ============ Featured Dish  =============

        <section id="featured" class="description_content">
            <div  class="featured background_content">
                <h1>Our Featured Dishes <span>Menu</span></h1>
            </div>
            <div class="text-content container"> 
                <div class="col-md-6">
                    <h1>Have a look to our dishes!</h1>
                    <div class="icon-hotdog fa-2x"></div>
                    <p class="desc-text">Each food is handmade at the crack of dawn, using only the simplest of ingredients to bring out smells and flavors that beckon the whole block. Stop by anytime and experience simplicity at its finest.</p>
                </div>
                <div class="col-md-6">
                    <ul class="image_box_story2">
                        <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                            Indicators
                            <ol class="carousel-indicators">
                                <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                                <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                                <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                            </ol>

                            Wrapper for slides
                            <div class="carousel-inner">
                                <div class="item active">
                                    <img src="images/slider1.jpg"  alt="...">
                                    <div class="carousel-caption">
                                        
                                    </div>
                                </div>
                                <div class="item">
                                    <img src="images/slider2.jpg" alt="...">
                                    <div class="carousel-caption">
                                        
                                    </div>
                                </div>
                                <div class="item">
                                    <img src="images/slider3.JPG" alt="...">
                                    <div class="carousel-caption">
                                        
                                    </div>
                                </div>
                            </div>
                        </div>
                    </ul>
                </div>
            </div>
        </section> -->

        <!-- ============ Reservation  ============= -->

        <!-- <section  id="reservation"  class="description_content">
            <div class="featured background_content">
                <h1>Reserve a Table!</h1>
            </div>
            <div class="text-content container"> 
                <div class="inner contact">
                    Form Area
                    <div class="contact-form">
                        Form
                        <form id="contact-us" method="post" action="reserve.php">
                            Left Inputs
                            <div class="container">
                                <div class="row">
                                    <div class="col-lg-8 col-md-6 col-xs-12">
                                        <div class="row">
                                            <div class="col-lg-6 col-md-6 col-xs-6">
                                                Name
                                                <input type="text" name="first_name" id="first_name" required="required" class="form" placeholder="First Name" />
                                                <input type="text" name="last_name" id="last_name" required="required" class="form" placeholder="Last Name" />
                                                <input type="text" name="state" id="state" required="required" class="form" placeholder="State" />
                                                <input type="text" name="datepicker" id="datepicker" required="required" class="form" placeholder="Reservation Date" />
                                            </div>

                                            <div class="col-lg-6 col-md-6 col-xs-6">
                                                Name
                                                <input type="text" name="phone" id="phone" required="required" class="form" placeholder="Phone" />
                                                <input type="text" name="guest" id="guest" required="required" class="form" placeholder="Guest Number" />
                                                <input type="email" name="email" id="email" required="required" class="form" placeholder="Email" />
                                                <input type="text" name="subject" id="subject" required="required" class="form" placeholder="Subject" />
                                            </div>

                                            <div class="col-xs-6 ">
                                                Send Button
                                                <button type="submit" id="submit" name="submit" class="text-center form-btn form-btn">Reserve</button> 
                                            </div>
                                            
                                        </div>
                                    </div>
                                    
                                    <div class="col-lg-4 col-md-6 col-xs-12">
                                        Message
                                        <div class="right-text">
                                            <h2>Hours</h2><hr>
                                            <p>Monday to Friday: 7:30 AM - 11:30 AM</p>
                                            <p>Saturday & Sunday: 8:00 AM - 9:00 AM</p>
                                            <p>Monday to Friday: 12:00 PM - 5:00 PM</p>
                                            <p>Monday to Saturday: 6:00 PM - 1:00 AM</p>
                                            <p>Sunday to Monday: 5:30 PM - 12:00 AM</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            Clear
                            <div class="clear"></div>
                        </form>
                    </div>End Contact Form Area
                </div>End Inner
            </div>
        </section> -->

        <!-- ============ Social Section  ============= -->
      
        <!-- <section class="social_connect">
            <div class="text-content container"> 
                <div class="col-md-6">
                    <span class="social_heading">FOLLOW</span>
                    <ul class="social_icons">
                        <li><a class="icon-twitter color_animation" href="#" target="_blank"></a></li>
                        <li><a class="icon-github color_animation" href="#" target="_blank"></a></li>
                        <li><a class="icon-linkedin color_animation" href="#" target="_blank"></a></li>
                        <li><a class="icon-mail color_animation" href="#"></a></li>
                    </ul>
                </div>
                <div class="col-md-4">
                    <span class="social_heading">OR DIAL</span>
                    <span class="social_info"><a class="color_animation" href="tel:883-335-6524">(941) 883-335-6524</a></span>
                </div>
            </div>
        </section> -->

        <!-- ============ Contact Section  ============= -->

       <!--  <section id="contact">
            <div class="map">
                <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3618.664063989472!2d91.8316103150038!3d24.909437984030877!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x37505558dd0be6a1%3A0x65c7e47c94b6dc45!2sTechnext!5e0!3m2!1sen!2sbd!4v1444461079802" width="100%" height="450" frameborder="0" style="border:0" allowfullscreen></iframe>
            </div>
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="inner contact">
                            Form Area
                            <div class="contact-form">
                                Form
                                <form id="contact-us" method="post" action="contact.php">
                                    Left Inputs
                                    <div class="col-md-6 ">
                                        Name
                                        <input type="text" name="name" id="name" required="required" class="form" placeholder="Name" />
                                        Email
                                        <input type="email" name="email" id="email" required="required" class="form" placeholder="Email" />
                                        Subject
                                        <input type="text" name="subject" id="subject" required="required" class="form" placeholder="Subject" />
                                    </div>End Left Inputs
                                    Right Inputs
                                    <div class="col-md-6">
                                        Message
                                        <textarea name="message" id="message" class="form textarea"  placeholder="Message"></textarea>
                                    </div>End Right Inputs
                                    Bottom Submit
                                    <div class="relative fullwidth col-xs-12">
                                        Send Button
                                        <button type="submit" id="submit" name="submit" class="form-btn">Send Message</button> 
                                    </div>End Bottom Submit
                                    Clear
                                    <div class="clear"></div>
                                </form>
                            </div>End Contact Form Area
                        </div>End Inner
                    </div>
                </div>
            </div>
        </section> -->

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
<script type="text/javascript">
		function myFunction() {
			document.getElementById("eval").click(); // Click on the checkbox
			return true;
		}
	</script>
		<script>
		function LengthConverter(valNum) {
			var v = valNum;
			document.getElementById("outputMeters").value = v / 3.2808;
		}
	</script>
	<script type="text/javascript">
		var cneed;
		var fneed;
		var crneed;
		var pneed;
		var aneed;
		var fd;
		function cc() {
			var age = parseInt(document.getElementById("age").value);
			var wtype = document.getElementById("wtype").value;
			var foot = parseInt(document.getElementById("foot").value);
			var inch = parseInt(document.getElementById("inch").value);
			var cm = document.getElementById("cen").value;
			var weight = document.getElementById("weight").value;
			if (age != '' && cm != '' && weight != '') {
				if (wtype == "pounds") {
					weight = parseInt(weight);
					weight = Math.round(weight / 2.2046);
				}
				var loa = document.getElementById("loa").value;
				if (document.getElementById("gen").checked) {
					fd = (10 * weight) + (6.25 * cm) - (5 * age) + 5;
				} else {
					fd = (10 * weight) + (6.25 * cm) - (5 * age) - 161;
				}
				switch (loa) {
				case "1":
					cneed = fd * 1.2;
					break;
				case "2":
					cneed = fd * 1.375
					break;
				case "3":
					cneed = fd * 1.53;
					break;
				case "4":
					cneed = fd * 1.725;
					break;
				case "5":
					cneed = fd * 1.9;
					break;
				}
				cneed = Math.floor(cneed);
				//cneed1=Math.floor(cneed*0.0353);
				fneed = Math.floor((cneed * 0.25) / 9);
				if (wtype == "pounds") {
					fneed = Math.floor(fneed * 0.0353);
					//fneed=fneed*0.0022 ;
				}
				pneed = Math.floor((cneed * 0.25) / 4);
				if (wtype == "pounds") {
					pneed = Math.floor(pneed * 0.0353);
				}
				crneed = Math.floor((cneed * 0.25) / 4);
				if (wtype == "pounds") {
					crneed = Math.floor(crneed * 0.0353);
				}
				aneed = Math.floor((cneed * 0.25) / 7);
				if (wtype == "pounds") {
					aneed = Math.floor(aneed * 0.0353);
				}
				document.getElementById("rc").value = " " + cneed;
				document.getElementById("rf").value = " " + fneed;
				document.getElementById("rp").value = " " + pneed;
				document.getElementById("rh").value = " " + crneed;
				document.getElementById("ra").value = " " + aneed;
				document.getElementById("l1").innerHTML = "";
				document.getElementById("l2").innerHTML = "";
				document.getElementById("l3").innerHTML = "";
				document.getElementById("l4").innerHTML = "";
				var caltype = document.getElementById("caltype").value;
				if (caltype == 'g') {
					document.getElementById("l1").innerHTML = "grams";
					document.getElementById("l2").innerHTML = "grams";
					document.getElementById("l3").innerHTML = "grams";
					document.getElementById("l4").innerHTML = "grams";
				}
				if (wtype == "pounds") {
					fat1 = fneed * 0.0022;
					pro1 = pneed * 0.0022;
					car1 = crneed * 0.0022;
					alh1 = aneed * 0.0022;
					fat1 = fat1.toFixed(3);
					pro1 = pro1.toFixed(3);
					car1 = car1.toFixed(3);
					alh1 = alh1.toFixed(3);
					document.getElementById("rf").value = " " + fat1;
					document.getElementById("rp").value = " " + pro1;
					document.getElementById("rh").value = " " + car1;
					document.getElementById("ra").value = " " + alh1;
					document.getElementById("l1").innerHTML = "lbs";
					document.getElementById("l2").innerHTML = "lbs";
					document.getElementById("l3").innerHTML = "lbs";
					document.getElementById("l4").innerHTML = "lbs";
				}
				if (caltype == 'pounds') {
					fat1 = fneed * 0.0022;
					pro1 = pneed * 0.0022;
					car1 = crneed * 0.0022;
					alh1 = aneed * 0.0022;
					fat1 = fat1.toFixed(3);
					pro1 = pro1.toFixed(3);
					car1 = car1.toFixed(3);
					alh1 = alh1.toFixed(3);
					document.getElementById("rf").value = " " + fat1;
					document.getElementById("rp").value = " " + pro1;
					document.getElementById("rh").value = " " + car1;
					document.getElementById("ra").value = " " + alh1;
					document.getElementById("l1").innerHTML = "lbs";
					document.getElementById("l2").innerHTML = "lbs";
					document.getElementById("l3").innerHTML = "lbs";
					document.getElementById("l4").innerHTML = "lbs";
				}
				if (caltype == 'kg') {
					fat2 = fneed / 1000;
					pro2 = pneed / 1000;
					car2 = crneed / 1000;
					alh2 = aneed / 1000;
					fat2 = fat2.toFixed(3);
					pro2 = pro2.toFixed(3);
					car2 = car2.toFixed(3);
					alh2 = alh2.toFixed(3);
					document.getElementById("rf").value = " " + fat2;
					document.getElementById("rp").value = " " + pro2;
					document.getElementById("rh").value = " " + car2;
					document.getElementById("ra").value = " " + alh2;
					document.getElementById("l1").innerHTML = "kilogram";
					document.getElementById("l2").innerHTML = "kilogram";
					document.getElementById("l3").innerHTML = "kilogram";
					document.getElementById("l4").innerHTML = "kilogram";
				}
			} else {
				alert("Please fill your details properly!");
			}
		}
		function con(num) {
			var hc = parseInt(num.value);
			var hi = hc / 2.54;
			var hf = Math.floor(hi / 12);
			var ri = Math.round(hi % 12);
			if (hc > 40 && hc <= 210) {
				document.getElementById("foot").value = hf;
			}
			document.getElementById("inch").value = ri;
		}
		function hcon() {
			var hf = parseInt(document.getElementById("foot").value);
			var hi = parseInt(document.getElementById("inch").value);
			var hc;
			hc = Math.round((hf * 30.48) + (hi * 2.54));
			document.getElementById("cen").value = hc;
		}
		function cknum(event, num) {
			var kc;
			if (window.event) {
				kc = event.keyCode;
			} else {
				kc = event.which;
			}
			var a = num.value;
			if (kc == 48) {
				if (a == "") {
					return false;
				} else {
					return true;
				}
			}
			if (kc != 8 && kc != 0) {
				if (kc<49||kc>57) {
					return false;
				}
			}
		}
		function isNumberKey(id) {
			var no = eval('"' + id + '"');
			var number = document.getElementById(no).value;
			if (!number.match(/^[0-9\.]+$/) && number != "") {
				number = number.substring(0, number.length - 1);
				document.getElementById(id).value = number;
			}
		}
		function convert() {
			var age = parseInt(document.getElementById("age").value);
			var cm = document.getElementById("cen").value;
			var weight = document.getElementById("weight").value;
			if (age != '' && cm != '' && weight != '') {
				var caltype = document.getElementById("caltype").value;
				var fat = document.getElementById("rf").value;
				var pro = document.getElementById("rp").value;
				var car = document.getElementById("rh").value;
				var alh = document.getElementById("ra").value;
				if (caltype == 'g') {
					document.getElementById("rc").value = " " + cneed;
					document.getElementById("rf").value = " " + fneed;
					document.getElementById("rp").value = " " + pneed;
					document.getElementById("rh").value = " " + crneed;
					document.getElementById("ra").value = " " + aneed;
					document.getElementById("l1").innerHTML = "grams";
					document.getElementById("l2").innerHTML = "grams";
					document.getElementById("l3").innerHTML = "grams";
					document.getElementById("l4").innerHTML = "grams";
				}
				if (caltype == 'pounds') {
					fat1 = fneed * 0.0022;
					pro1 = pneed * 0.0022;
					car1 = crneed * 0.0022;
					alh1 = aneed * 0.0022;
					fat1 = fat1.toFixed(3);
					pro1 = pro1.toFixed(3);
					car1 = car1.toFixed(3);
					alh1 = alh1.toFixed(3);
					document.getElementById("rf").value = " " + fat1;
					document.getElementById("rp").value = " " + pro1;
					document.getElementById("rh").value = " " + car1;
					document.getElementById("ra").value = " " + alh1;
					document.getElementById("l1").innerHTML = "lbs";
					document.getElementById("l2").innerHTML = "lbs";
					document.getElementById("l3").innerHTML = "lbs";
					document.getElementById("l4").innerHTML = "lbs";
				}
				if (caltype == 'kg') {
					fat2 = fneed / 1000;
					pro2 = pneed / 1000;
					car2 = crneed / 1000;
					alh2 = aneed / 1000;
					fat2 = fat2.toFixed(3);
					pro2 = pro2.toFixed(3);
					car2 = car2.toFixed(3);
					alh2 = alh2.toFixed(3);
					document.getElementById("rf").value = " " + fat2;
					document.getElementById("rp").value = " " + pro2;
					document.getElementById("rh").value = " " + car2;
					document.getElementById("ra").value = " " + alh2;
					document.getElementById("l1").innerHTML = "kilogram";
					document.getElementById("l2").innerHTML = "kilogram";
					document.getElementById("l3").innerHTML = "kilogram";
					document.getElementById("l4").innerHTML = "kilogram";
				}
			} else {
				alert("Please fill your details properly!");
			}
		}
		function chk() {
			var sds = document.getElementById('dum');
			if (sds == null) {
				alert("You are using a free package.\n You are not allowed to remove the tag.\n");
				document.getElementById("tab").style.visibility = "hidden";
			}
			var sdss = document.getElementById("dumdiv");
			if (sdss == null) {
				alert("You are using a free package.\n You are not allowed to remove the tag.\n");
			}
		}
		window.onload = chk;
	</script>
    </body>
</html>
>