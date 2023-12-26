<%@page import="Dto.*"%>
<%@page import="java.util.*" %>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3> welcome to the Train Booking App....</h3>
<form action="searchTrain">
 From :<input type = "text" placeholder="Enter the startpoint" name = "starting">  To:<input type = "text" placeholder="Enter the EndPoint" name = "endpoint">
 <button type="submit">Search</button>
</form><br>

<% String mess = (String)request.getAttribute("message1"); %>
<% if(mess != null){ %>
 <h3> <%= mess %></h3>
 <% } %>
 <table  border="2px" >
   <tr>

   <th>TrainNo</th>
   <th>TrainName</th>
   <th>TotalSeats</th>
   <th>startpoint</th>
  <th>destination</th>
  <th>StartTime</th>
  <th>ReachTime</th>
  <th>Price</th>
  <th>Book</th>
  
  </tr>
 <% List<TrainsDetails> trains =(List)request.getAttribute("trains");%>
 <% for (TrainsDetails t : trains) { %>
 <tr>
   <td><%= t.getTrainNo()  %></td> 
   <td><%= t.getTrainName()  %></td> 
   <td><%= t.getTotalSeats()  %></td> 
   <td><%= t.getStartPoint()  %></td> 
   <td><%= t.getDestination()  %></td> 
   <td><%= t.getStartTime()  %></td> 
   <td><%= t.getReachTime()  %></td> 
   <td><%= t.getTotalPrice()  %></td> 
   <td><button><a href="bookingpage?no=<%= t.getTrainNo()  %>"  style="text-decoration: none">Book</a></button></td>
 </tr>
 <% } %>
  </table>

  
  <h3><a href="goBack">show All Trains</a></h3>
  <h3><a href="AllTicket">show ticket</a></h3>
  <h3><a href="UserLogout">Logout</a></h3>
  
  
  
</body>
</html>