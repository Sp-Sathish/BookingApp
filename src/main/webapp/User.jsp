<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

   <% String message = (String)request.getAttribute("message"); %>
			<% if(message != null) { %>
				<h2> <%= message %></h2>
				<% } %>	

<div id="admin">
 <a href="UserLogin.jsp">User Login</a><br>
 <a href="UserSignup.jsp">User signup</a>


</body>
</html>