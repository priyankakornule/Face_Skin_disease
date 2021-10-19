<%@page import="com.model.Register"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%

Register helth=(Register)session.getAttribute("uinfo");
int uid=(int)session.getAttribute("uid");
%>

<table>
<tr><th>UID</th><br>
<th>Fname</th>
<th>Lname</th>
<th>Contact</th>
<th>Email</th>
<th>Disease</th></tr>

<tr><td><%=uid%></td><td><%=helth.getFname() %></td><td><%=helth.getLname()%></td><td><%=helth.getContact()%></td><td><%=helth.getEmail()%></td><td><%=helth.getDis() %></td></tr>


</table>


</body>
</html>