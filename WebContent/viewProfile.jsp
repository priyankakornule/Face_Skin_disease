<!DOCTYPE html>


<%@page import="com.model.Register"%>
<%@page import="com.DAO.DataAccessLayer"%>
<%@page import="javax.imageio.ImageIO"%>
<%@page import="java.io.ByteArrayOutputStream"%>
<%@page import="java.awt.image.BufferedImage"%>

<html>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  
  
<link href="https://fonts.googleapis.com/css?family=Poppins:100,200,400,300,500,600,700" rel="stylesheet"> 
			<!--
			CSS
			============================================= -->
			<link rel="stylesheet" href="css2/linearicons.css">
			<link rel="stylesheet" href="css2/font-awesome.min.css">
			<link rel="stylesheet" href="css2/bootstrap.css">
			<link rel="stylesheet" href="css2/magnific-popup.css">
			<link rel="stylesheet" href="css2/jquery-ui.css">				
			<link rel="stylesheet" href="css2/nice-select.css">							
			<link rel="stylesheet" href="css2/animate.min.css">
			<link rel="stylesheet" href="css2/owl.carousel.css">				
			<link rel="stylesheet" href="css2/main6.css">
			
			<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">	
			
	<style>

::placeholder { /* Chrome, Firefox, Opera, Safari 10.1+ */
  color: black;
  font-family:sans-serif;
 font-size:14px;
  opacity: 1;
   /* Firefox */
}


   meter {  
     width: 220px;  
     height: 25px;  
   }  

</style>	
			
</head>


<body style="background-color: skyblue">

<%
	response.setHeader("Pragma", "No-cache");
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	response.setDateHeader("Expires", -1);

	if (session.getAttribute("uid") == null) {
		response.sendRedirect("login.jsp");
		return;
	}
%>
<!-- <script>
function myFunction() {   
document.getElementById('first_name').readOnly = true;
document.getElementById('last_name').readOnly = true;
document.getElementById('phone').readOnly = true;
document.getElementById('mobile').readOnly = true;
document.getElementById('email').readOnly = true;
document.getElementById('dob').readOnly = true;
document.getElementById('location').readOnly = true;
document.getElementById('gender').readOnly = true;

}

</script>

 <script>
    function mysaveFunction() {   
    document.getElementById('first_name').disabled = true;
    document.getElementById('last_name').disabled = true;
    document.getElementById('phone').disabled = true;
    document.getElementById('mobile').disabled = true;
    document.getElementById('email').disabled = true;
    document.getElementById('dob').disabled = true;
    document.getElementById('location').disabled = true;
    document.getElementById('gender').disabled = true;
    
    }
    </script>	
 -->
<%

int uid=Integer.parseInt(session.getAttribute("uid").toString());

Register s=DataAccessLayer.getHealthFormInfo(uid);
						
 				
   
  %> 
  
  

  <div>
  
  
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
   
    <ul class="nav navbar-nav" style="    margin-left: 63%;">
      <li class="active"><a href="uploadImage.jsp">Upload Image</a></li>
      
      <li><a class="navactive color_animation" href="Logout_controller">LOGOUT</a></li>
    </ul>
  </div>
</nav>

</div>
<br>
<br><br><br><br>
<hr>



<div class="container bootstrap snippet" style="    margin-top: -6%;">
    <div class="row">
  		<div class="col-sm-10" style="margin-left:-10px;">
  		<h1 style="font-family: serif; font-size: 40px; color: initial;"><%=s.getFname()+" "+s.getLname()%></h1></div>
    	  </div>
    <div class="row">
  		<div class="col-sm-3"><!--left col-->
    <div class="panel panel-default">
          </div>
          
          
        
          
        </div><!--/col-3-->
    	<div class="col-sm-9" style="    margin-left: 16%;">
            <ul class="nav nav-tabs">
                <li class="active"><a style="font-family: serif; font-size: 18px; color:black" data-toggle="tab" href="#home">User Profile:</a></li>
                
                
              </ul>
              
              
              
  

              
        <div class="tab-content" style=" height: 90%; background-color: aliceblue;">
            <div class="tab-pane active" id="home">
                <hr>
                  <!-- <form  action="StudentProfile" method="post" > -->
                      <div class="form-group">
                          
                          <div class="col-xs-6">
                              <label><h4>First name:</h4></label>
                              <input type="text" class="form-control" name="fname" style="font-family: serif; font-size: 15px; color: snow; background-color: #000000a1;"  value="<%=s.getFname()%>" placeholder="first name"  disabled>
                          </div>
                      </div>
                      <div class="form-group">
                          
                          <div class="col-xs-6">
                            <label for="last_name"><h4>Last name:</h4></label>
                              <input type="text" class="form-control" name="lname" style="font-family: serif; font-size: 15px; color: snow; background-color: #000000a1;"  value="<%=s.getLname()%>" placeholder="last name" title="enter your last name if any." disabled>
                          </div>
                      </div>
          
                      <div class="form-group">
                          
                          <div class="col-xs-6">
                              <label for="phone"><h4>Contact:</h4></label>
                              <input type="text" class="form-control" name="number" style="font-family: serif; font-size: 15px; color: snow; background-color: #000000a1;" value="<%=s.getContact()%>" id="phone" placeholder="enter phone" title="enter your phone number if any." disabled>
                          </div>
                      </div>
          
                   
                      <div class="form-group">
                          
                          <div class="col-xs-6">
                              <label for="email"><h4>Email:</h4></label>
                              <input type="text" class="form-control" name="email" style="font-family: serif; font-size: 15px; color: snow; background-color: #000000a1;" value="<%=s.getEmail()%>" id="email" placeholder="you@email.com" title="enter your email." disabled>
                          </div>
                      </div>
                    
                      <div class="form-group">
                          <div class="col-xs-6">
                              <label for="password"><h4>Gender:</h4></label>
                            
                           <%
                if(s.getGender().equals("1")){
                	%>
                	<td><input type="text" class="form-control" name="gender" style="font-family: serif; font-size: 15px; color: snow; background-color: #000000a1;"  id="gender"  value="Female" placeholder=" your Gender" title="enter your password." disabled>       	
                <%}
                else{%>
                	  <td><input type="text" class="form-control" name="gender" style="font-family: serif; font-size: 15px; color: snow; background-color: #000000a1;" id="gender" value="Male" placeholder=" your Gender" title="enter your password." disabled></td>
               <%  }
                %>
                          
                          </div>
                      </div>
                      <div class="form-group">
                          <div class="col-xs-6">
                             <label for="mobile"><h4>Age:</h4></label>
                              <input type="text" class="form-control" name="mobile" style="font-family: serif; font-size: 15px; color: snow; background-color: #000000a1;"  value="<%=s.getAge()%>" id="mobile" placeholder="enter mobile number" title="enter your mobile number if any." disabled>
                          </div>
                      </div> 
                      <div class="form-group">
                          
                          <div class="col-xs-6">
                            <label for="password2"><h4>Height (cms):</h4></label>
                              <input type="text" class="form-control" name="date" style="font-family: serif; font-size: 15px; color: snow; background-color: #000000a1;" value="<%=s.getCms()%>" id="dob" placeholder="Date of birth" title="enter your password2." disabled>
                          </div>
                      </div> 
                  
                   <div class="form-group">
                          
                          <div class="col-xs-6">
                            <label for="password2"><h4>Weight:</h4></label>
                              <input type="text" class="form-control" name="date" style="font-family: serif; font-size: 15px; color: snow; background-color: #000000a1;" value="<%=s.getWeight()%>" id="dob" placeholder="Date of birth" title="enter your password2." disabled>
                          </div>
                      </div> 
                       <div class="form-group">
                          
                          <div class="col-xs-6">
                            <label for="password2"><h4>Activeness:</h4></label>
                              <input type="text" class="form-control" name="date" style="font-family: serif; font-size: 15px; color: snow; background-color: #000000a1;" value="<%=s.getActiveness()%>" id="dob" placeholder="Date of birth" title="enter your password2." disabled>
                          </div>
                      </div> 
                       <div class="form-group">
                          
                          <div class="col-xs-6">
                            <label for="password2"><h4>BMI:</h4></label>
                              <input type="text" class="form-control" name="date" style="font-family: serif; font-size: 15px; color: snow; background-color: #000000a1;" value="<%=s.getBmi()%>" id="dob" placeholder="Date of birth" title="enter your password2." disabled>
                          </div>
                      </div> 
                       <div class="form-group">
                          
                          <div class="col-xs-6">
                            <label for="password2"><h4>Health:</h4></label>
                              <input type="text" class="form-control" name="date" style="font-family: serif; font-size: 15px; color: snow; background-color: #000000a1;" value="<%=s.getMean()%>" id="dob" placeholder="Date of birth" title="enter your password2." disabled>
                          </div>
                      </div> 
                       <div class="form-group">
                          
                          <div class="col-xs-6">
                            <label for="password2"><h4>Calorie:</h4></label>
                              <input type="text" class="form-control" name="date" style="font-family: serif; font-size: 15px; color: snow; background-color: #000000a1;" value="<%=s.getCalorie()%>" id="dob" placeholder="Date of birth" title="enter your password2." disabled>
                          </div>
                      </div> 
                  
              
              <hr>
              
             </div><!--/tab-pane-->
             
            
               
              </div><!--/tab-pane-->
          </div><!--/tab-content-->

        </div><!--/col-9-->
    </div><!--/row-->
    
    
    	<script src="js/vendor/jquery-2.2.4.min.js"></script>
			<script src="js/popper.min.js"></script>
			<script src="js/vendor/bootstrap.min.js"></script>			
					
 			<script src="js/jquery-ui.js"></script>					
  			<script src="js/easing.min.js"></script>			
			<script src="js/hoverIntent.js"></script>
			<script src="js/superfish.min.js"></script>	
			<script src="js/jquery.ajaxchimp.min.js"></script>
			<script src="js/jquery.magnific-popup.min.js"></script>						
			<script src="js/jquery.nice-select.min.js"></script>					
			<script src="js/owl.carousel.min.js"></script>							
			<script src="js/mail-script.js"></script>	
			<script src="js/main.js"></script>	
			
			
			<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script>
        
     $(document).ready(function(){

         $("form input[type=text],form input[type=checkbox]").prop("disabled",true);

         $("input[name=edit]").on("click",function(){

                 $("input[type=text],input[type=checkbox],select").removeAttr("disabled");
         })

         $("input[name=save]").on("click",function(){

             $("input[type=text],input[type=checkbox],select").prop("disabled",true);
         })


     })
    </script>
</body>
 </html>                                                     