
<%@page import="com.model.Food"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
input[type=text], select, textarea {
	width: 50%;
	padding: 12px;
	border: 1px solid #ccc;
	border-radius: 4px;
	resize: vertical;
}

input[type=submit] {
	background-color: #4CAF50;
	color: white;
	padding: 12px 20px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
	float: center;
}

input[type=submit]:hover {
	background-color: #45a049;
}

.topnav {
	overflow: hidden;
	background-color: #333;
}

.topnav a {
	float: right;
	display: block;
	color: #f2f2f2;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
	font-size: 17px;
}

.topnav a:hover {
	background-color: #ddd;
	color: black;
}

.topnav a.active {
	background-color: #de3133;
	color: white;
}

h2 {
	font-family: "Times New Roman", Times, serif;
}

body {
	background-image: url("images/bg.jpg");
	background-size: cover;
}

label {
	padding: 12px 12px 12px 0;
	display: inline-block;
}
</style>
<script>
		function myFunction(id) {
			var x = document.getElementById(id);
			if (x.className.indexOf("w3-show") == -1) {
				x.className += " w3-show";
			} else {
				x.className = x.className.replace(" w3-show", "");
			}
		}
	</script>
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

	<div class="topnav"
		style="margin-top: -1%; width: 101.5%; margin-left: -1%;">
		<div class="topnav">
			

		<li><a class="navactive color_animation" href="Logout_controller">LOGOUT</a></li>

		</div>

	</div>


	<%  
		List<Food> fruits =(List<Food>)session.getAttribute("fruitset");
		List<Food> beverage = (List<Food>) session.getAttribute("mornning");
		List<Food> breakfast = (List<Food>) session.getAttribute("breakfast");
		List<Food> lunch = (List<Food>) session.getAttribute("lunch");
		List<Food> dinner = (List<Food>) session.getAttribute("dinner");
	%>
	<%
			/* String result = session.getAttribute("result").toString(); */
		%>
	<div style="    border: solid 1px;
    border-color: #d8d8d2;
    background-color: #eaeae8;
    opacity: 0.7;
    color: black;
    width: 72%;
    margin-top: 1%;">
	<%-- <%=result%> --%>
	</div>
	
	<h3>Diet chart suggested for you :</h3>

	<div class="w3-container" style="width: 70% !important;">


		<button onclick="myFunction('Demo1')"
			style="color: #000 !important; background-color: #d8d8d2 !important;"
			class="w3-btn w3-block w3-black w3-left-align">Click to view
			Morning Beverages</button>
		<div id="Demo1" class="w3-container w3-hide">
		<h3>Select one of following list</h3>
		
			<table>
				<%
					for (Food f : beverage) {
				%>
				<tr>
					<td><%=f.getFoodname()%></td>
					<%System.out.println("get unit ---->"+f.getUnit()); %>
					<td><%=f.getUnit()%>(calories:<%=f.getCalories()%> )</td>
				</tr>
				<%
					}
				%>
			</table>
		</div>
		<br>
		<button onclick="myFunction('Demo2')"
			style="color: #000 !important; background-color: #d8d8d2 !important;"
			class="w3-btn w3-block w3-black w3-left-align">Click to view
			Fruits</button>
		<div id="Demo2" class="w3-container w3-hide">
		<h3> Eat atleast one fruits from the following in a day</h3>
			<table>
				<%
					for (Food f : fruits) {
				%>
				<tr>
					<td><%=f.getFoodname()%></td>
					<td><%=f.getUnit()%>(calories :<%=f.getCalories()%>)</td>
				</tr>
				<%
					}
				%>
			</table>
		</div>
		<br>
		<button onclick="myFunction('Demo3')"
			style="color: #000 !important; background-color: #d8d8d2 !important;"
			class="w3-btn w3-block w3-black w3-left-align">Click to view
			Breakfast</button>
		<div id="Demo3" class="w3-container w3-hide">
		<h3>Select one item from
							list</h3>
			<table>
				<%
					for (Food f : breakfast) {
				%>
				<tr>
					<td><%=f.getFoodname()%></td>
					<td><%=f.getUnit()%>(calories:<%=f.getCalories()%>)</td>
				</tr>
				<%
					}
				%>
			</table>
		</div>
		<br>
		<button onclick="myFunction('Demo4')"
			style="color: #000 !important; background-color: #d8d8d2 !important;"
			class="w3-btn w3-block w3-black w3-left-align">Click to view
			Lunch</button>
		<div id="Demo4" class="w3-container w3-hide">
			<table>
				<tr>
					<td>compulary:</td>
					<td>2-4 chappati</td>
				<tr>
					<td>compulary:</td>
					<td>1 cup Rice</td>
				<tr>
					<td>optional:</td>
					<td>1 cup dal</td>
				<tr>
					<td><h1 style="font-size: 14px;"><h3>Select one item from
							list</h3></td>
					<%
						for (Food f : lunch) {
					%>
				
				<tr>
					<td><%=f.getFoodname()%></td>
					<td><%=f.getUnit()%> (calories:<%=f.getCalories()%>)</td>
				</tr>
				<%
					}
				%>
			</table>
		</div>
		<br>
		<button onclick="myFunction('Demo5')"
			style="color: #000 !important; background-color: #d8d8d2 !important;"
			class="w3-btn w3-block w3-black w3-left-align">Click to
			Dinner</button>
		<div id="Demo5" class="w3-container w3-hide">
			<table>
				<tr>
					<td>compulsary:</td>
					<td>2-3 chappati or veg soup</td>
					<%
						for (Food f : dinner) {
					%>
				
				<tr>
					<td><%=f.getFoodname()%></td>
					<td><%=f.getUnit()%> (calories:<%=f.getCalories()%>)</td>
				</tr>
				<%
					}
				%>
			</table>
		</div>
	</div>
</body>
</html>