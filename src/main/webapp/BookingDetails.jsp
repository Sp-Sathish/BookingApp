<%@page import="Dto.*"%>
<%@page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% TrainsDetails t = (TrainsDetails)request.getAttribute("trainDetails"); %>
<% User u = (User)request.getAttribute("userDetails"); %>
<h3>Booking Details Page</h3>
<form action="booking">
  UserId:<input type="number" readonly value="<%= u.getUserId()  %>" name="UserID"><br>
  <br>
  UserName:<input type="text" readonly  value="<%= u.getUserName()  %>" name="UserName"><br>
  <br>
  TrainNo:<input type="number" readonly  value="<%= t.getTrainNo()  %>" name="TrainNo"><br>
  <br>
  StartPoint:<input type="text" readonly  value="<%= t.getStartPoint()  %>" name="StartPoint"><br>
  <br>
  Destination:<input type="text" readonly  value="<%= t.getDestination()  %>"  name="Destination"><br>
  <br>
  TotalSeats:<input type="number"   value="1" name="totalTickets"   ><br>
  <br>
  price:<input type="number" readonly  value="<%=t.getTotalPrice() %>" name="price"   ><br>
  <br>
  <button type="submit">Book</button>
</form>

</body>
</html>