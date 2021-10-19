<%@page import="com.model.Nutrientinfo"%>
<%@page import="com.DAO.DataAccessLayer"%>
<%@page import="com.model.Register"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="assets/css/table.css">
<title>Insert title here</title>
<style type="text/css">
.blue_button {
	background: none repeat scroll 0 0 #468CD2;
	border-bottom: 3px solid #3277BC;
	text-shadow: 1px 1px 0 #214D73;
	border: medium none;
	border-radius: 0.3em;
	color: #FFFFFF;
	cursor: pointer;
	font-weight: bold;
	margin: 10px 0;
	padding: 7px 14px;
}

.frms input[type="text"], [type="password"], [type="file"], textarea,
	select {
	background: none repeat scroll 0 0 #fff;
	border: 1px solid #ddd;
	border-radius: 0.35em;
	height: 35px;
	margin-bottom: 15px;
	margin-top: 5px;
	padding: 0 0.5%;
	width: 99%;
}

.resp_code {
	background: none repeat scroll 0 0 #f8f8f8;
	border: 1px solid #ddd;
	border-radius: 0.25em;
	color: #333;
	font: 1em/1.3em Tahoma, Geneva, sans-serif;
	margin: 5px 10px 10px 20%;
	overflow: auto;
	padding: 10px 20px;
	width: 50%;
}

@media only screen and (max-width:650px) {
	.resp_code {
		margin: 5px 1px 10px !important;
		width: auto !important;
	}
}

body {
	margin: 0;
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

input[type=submit] {
	background-color: #4CAF50; /* Green */
	border: none;
	color: white;
	padding: 15px 32px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
}

nav ul {
	list-style-type: none;
	padding: 0;
}

nav ul a {
	text-decoration: none;
}

body {
	background-image: url("images/122.jpg");
	background-size: cover;
}

nutrient {
	margin: center;
}
</style>
</head>
<body>
	<div class="topnav">
		<left> <a href="Nutritionjsp.jsp" style="float: left;">Home</a>
		<a href="Profile.jsp" style="float: left;">Profile</a> <a
			href="weightloss.jsp" style="float: left;">Weight loss</a> <a
			href="weightgain.jsp" style="float: left;">Weight gain</a> <a
			href="Exercise.jsp" style="float: left;">Calculate Count calories</a>

		</left>
		<a href="Home.jsp" class="active">Logout </a><br> <br>

	</div>


	<center>
<%
int uid=(int)session.getAttribute("uid");
System.out.println("uid jsp "+uid);

%>


<%
		

		Register hid=DataAccessLayer.getHealthFormInfo(uid);
		System.out.println(hid.getAge());
		System.out.println(hid.getGender());
		System.out.println(hid.getHeight());
		System.out.println(hid.getCms());
		System.out.println(hid.getWeight());
		System.out.println(hid.getActiveness());

	

		String foodname = (String)session.getAttribute("Dis");
                    		System.out.println("DIS 1111111111111111: "+foodname);
		
                    		
        Nutrientinfo fd=DataAccessLayer.getNutrientInfo(foodname);
		
	
		
		 
		 System.out.println("energy : "+fd.getEnergy()); 
		 System.out.println("calcium : "+fd.getCalcium());
		 System.out.println(fd.getCalories());
		 System.out.println(fd.getFiber());
		%>
		<center>
			<h1 style="color: wheat;">
				Nutritient fact of
			<%--  <%=name%> --%></h1> 
		</center>
		<div
			style="width: 750px; height: 400px; border: 1px solid black; background-image: url(images/llll.jpg); background: rgba(200, 54, 54, 0.5); border-radius: 128px;">
			<br> <br>

			<div class='resp_code align='
				center'' style="margin-top: -28px; margin-left: -53px; width: 794px;">
				<table id='tab' align='center' cellspacing='0' cellpadding='0'
					style="width: 100%;">
					<tr>
						<td align=center><br> <b>Calorie Calculator</b><br>
							<br>
							<form name="frm" action="CalculateController" method="post"
								class='frms noborders'>
								<table>
									
									<tr>
										<td style="color: #3D366F; font-size: 13px;">Age:</td>
										<td><input type="text" name="age" id="age" align="left" value="<%=hid.getAge() %>"
											size="3" maxlength="2" onkeypress="return cknum(event,age)"></td>
										<td><font color="#3D366F" size="2">years</font></td>
									</tr>
									<tr>
										<td style="color: #3D366F; font-size: 13px;">Gender:</td>
										<td><input type="text" name="gender" id="gender" align="left" value=<%=hid.getGender() %>
											size="6" maxlength="6" style=" margin-top: 20%;" disabled="true"></td>
									</tr>
							
									<tr>
										<td style="color: #3D366F; font-size: 13px;">Cms :</td>
										<td><input type="text" name="height" id="cen" size="4" value="<%=hid.getCms() %>"
											onkeyup="con(cen)" required true></td>
									</tr>
									<tr>
										<td style="color: #3D366F; font-size: 13px;">Weight:</td>
										<td><input type="text" name="weight" id="weight" value="<%=hid.getWeight() %>"
											maxlength="3" size="3" onkeyup="isNumberKey(this.id)" disabled="true"></td>
										<td><font color="#3D366F" size="2">kg</font></td>
									</tr>
									<tr>
										<td style="color: #3D366F; font-size: 13px;">Activeness:</td>
										<td><input type="text" name="activeness" id="activeness" value="<%=hid.getActiveness() %>" disabled="true">
										</td>
									</tr>
									
								</table>
								<table
									class="table table-striped table-bordered bootstrap-datatable datatable"
									style="width: 50%;">

									<tr>
										<th>Food Name</th>
										<th>Energy:</th>
										<th>Protein:</th>
										<th>Sugar:</th>
										<th>Fats:</th>
										<th>Fiber:</th>
										<th>Calcium:</th>
										<th>Calories:</th>
										<th>Vitamin A:</th>
										<th>Vitamin C:</th>
										<th>Iron:</th>

									</tr>

									<tr>
										<td></td>
										<td><input type='text' id="energy" name="energy"
											value=<%=fd.getEnergy()%> readonly="true"
											style="width: 88%; border: none; background: none;"></td>








										<!-- <td align='right'>Protein:</td> -->
										<td><input type='text' id="protein" name="protein"
											value=<%=fd.getProtein()%> readonly="true"
											style="width: 88%; border: none; background: none;"></td>




										<!-- <td align='right'>Sugar:</td> -->
										<td><input type='text' id="sugar" name="sugar"
											value=<%=fd.getSugar()%> readonly="true"
											style="width: 88%; border: none; background: none;"></td>



										<!-- <td align='right'>Fats:</td> -->
										<td><input type='text' id="fats" name="fats"
											value=<%=fd.getFat()%> readonly="true"
											style="width: 88%; border: none; background: none;"></td>

										<!-- <td align='right'>Fiber:</td> -->
										<td><input type='text' id="fiber" name="fiber"
											value=<%=fd.getFiber()%> readonly="true"
											style="width: 88%; border: none; background: none;"></td>

										<!-- 	<td align='right'>Calcium:</td> -->
										<td><input type='text' id="calcium" name="calcium"
											value=<%=fd.getCalcium()%> readonly="true"
											style="width: 88%; border: none; background: none;"></td>

										<!-- <td align='right'>Calories:</td> -->
										<td><input type='text' id="calories" name="calories"
											value=<%=fd.getCalories()%> readonly="true"
											style="width: 88%; border: none; background: none;"></td>

										<!-- <td align='right'>Vitamin A:</td> -->
										<td><input type='text' id="vitaminA" name="VitaminA"
											value=<%=fd.getVitaminA()%> readonly="true"
											style="width: 88%; border: none; background: none;"></td>

										<!-- <td align='right'>Vitamin C:</td> -->
										<td><input type='text' id="vitaminB" name="VitaminC"
											value=<%=fd.getIron()%> readonly="true"
											style="width: 88%; border: none; background: none;"></td>

										<!-- <td align='right'>Iron:</td> -->
										<td><input type='text' id="iron" name="iron"
											value=<%=fd.getIron()%> readonly="true"
											style="width: 88%; border: none; background: none;"></td>
									</tr>
								</table>

								<!-- <tr><td colspan='2' align="center"> -->


								<input class='blue_button' type="button" id="eval"
									value="Calculate The Calorie" onclick="cc()"
									style="display: none;"> <span id="dumdiv"
									align="center" style="font-size: 10px; color: #dadada;">
									<input type="submit" id="submit" onclick="return myFunction()"
									value="submit" style="border-radius: 20px;"> <a
									id="dum"
									style="padding-right: 0px; text-decoration: none; color: green; text-align: center;"
									href="https://www.hscripts.com"></a>
								</span>
								<!-- </td></tr></table>< -->
								<br>
								<table align="center" border="0" class="frms noborders">
									<caption>
										<b>
											<tr>
												<td style="color: white;"><h1 style="color: black">
										</b>
									</caption>
									<tr>
										<td align="right" style="color: #3D366F; font-size: 13px;">
											<!-- Calorie Needed: -->
										</td>
										<td><input type="hidden" name="calorie2" id="rc"
											style="font-size: 13px;" size="15" readonly></td>
										<!-- <td><select name="caltype" id="caltype" onChange="convert()"><option value="g">Grams</option> -->
										<!-- <option value="kg">Kilograms</option>
<option value="pounds">Pounds</option> -->
										</select>
										</td>
									</tr>
								</table>
								<div style="color: #3D366F; font-size: 13px;">
									<!-- You Must Intake The Following Daily -->
								</div>
								<table class="frms noborders">
									<tr>
										<td style="color: #3D366F; font-size: 13px;">
											<!-- Fat: -->
										</td>
										<td style="color: #3D366F; font-size: 13px;"><input
											type="hidden" name="fatty" id="rf" style="font-size: 13px;"
											size="10" readonly></td>
										<td><font color="#3D366F" size="2" style='float: right'><label
												id="l1"></label> <!-- per day --></font></td>
									</tr>
									<tr>
										<td style="color: #3D366F; font-size: 13px;">
											<!-- Protein: -->
										</td>
										<td style="color: #3D366F; font-size: 13px;"><input
											type="hidden" name="protein2" id="rp"
											style="font-size: 13px;" size="10" readonly></td>
										<td><font color="#3D366F" size="2" style='float: right'><label
												id="l2"></label> <!-- per day --></font></td>
									</tr>
									<tr>
										<td style="color: #3D366F; font-size: 13px;">
											<!-- Carbohydrate: -->
										</td>
										<td style="color: #3D366F; font-size: 13px;"><input
											type="hidden" name="carbo2" id="rh" style="font-size: 13px;"
											size="10" readonly></td>
										<td><font color="#3D366F" size="2" style='float: right'><label
												id="l3"></label> <!-- per day --></font></td>
									</tr>
									<tr>
										<td style="color: #3D366F; font-size: 13px;">
											<!-- Alcohol: -->
										</td>
										<td style="color: #3D366F; font-size: 13px;"><input
											type="hidden" id="ra" name="alhocol1"
											style="font-size: 13px;" size="10" readonly></td>
										<td><font color="#3D366F" size="2" style='float: right'><label
												id="l4"></label> <!-- per day --></font></td>
									</tr>
								</table>
					</tr>
					</td>
				</table>

			</div>
	</center>


	</form>





	</div>

	</div>
	</div>
	</center>
	<script type="text/javascript">
		function myFunction() {
			document.getElementById("eval").click(); // Click on the checkbox
			return true;
		}
	</script>
	<script type="text/javascript">
		function mul() {
			var qty = document.getElementById('quantity').value;
			var energy =
	<%=fd.getEnergy()%>
		;
			var protein =
	<%=fd.getProtein()%>
		var sugar =
	<%=fd.getSugar()%>
		var fats =
	<%=fd.getFat()%>
		var fiber =
	<%=fd.getFiber()%>
		var calcium =
	<%=fd.getCalcium()%>
		var calories =
	<%=fd.getCalories()%>
		var vitaminA =
	<%=fd.getVitaminA()%>
		var vitaminC =
	<%=fd.getVitaminC()%>
		var iron =
	<%=fd.getIron()%>
		var result = parseInt(qty) * parseInt(energy);
			var result1 = parseInt(qty) * parseInt(protein);
			var result2 = parseInt(qty) * parseInt(sugar);
			var result3 = parseInt(qty) * parseInt(fats);
			var result4 = parseInt(qty) * parseInt(fiber);
			var result5 = parseInt(qty) * parseInt(calcium);
			var result6 = parseInt(qty) * parseInt(calories);
			var result7 = parseInt(qty) * parseInt(vitaminA);
			var result8 = parseInt(qty) * parseInt(vitaminC);
			var result9 = parseInt(qty) * parseInt(iron);

			if (!isNaN(result)) {
				document.getElementById('energy').value = result;
				document.getElementById('protein').value = result1;
				document.getElementById('sugar').value = result2;
				document.getElementById('fats').value = result3;
				document.getElementById('fiber').value = result4;
				document.getElementById('calcium').value = result5;
				document.getElementById('calories').value = result6;
				document.getElementById('vitaminA').value = result7;
				document.getElementById('vitaminC').value = result8;
				document.getElementById('iron').value = result9;

			}
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

</body>
</html>