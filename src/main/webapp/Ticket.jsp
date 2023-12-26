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
<h3>Welcome to ticket page</h3>
<h3>Your tickets are::</h3>

 <table  border="2px" >
   <tr>
   <th>BookingId</th>
   <th>UserId</th>
   <th>Username</th>
   <th>TrainNo</th>
   <th>startpoint</th>
   <th>destination</th>
   <th>TotalSeats</th>
   <th>Price</th>
   <th>Cancel</th>
  
  </tr>
 <% List<Booking> flights =(List)request.getAttribute("tickets");%>
 <% for (Booking p : flights) { %>
 <tr>
  <td><%= p.getBookingId() %></td> 
   <td><%= p.getUserId()  %></td> 
   <td><%= p.getUserName()  %></td> 
   <td><%= p.getTrainNo()  %></td> 
   <td><%= p.getStartPoint()  %></td> 
   <td><%= p.getDestination()  %></td> 
   <td><%=p.getTotalSeats() %></td>
   <td><%= p.getPrice()  %></td> 
   <td><button><a href="cancel?bookingId=<%= p.getBookingId() %>&trainno=<%= p.getTrainNo()  %>&seats=<%=p.getTotalSeats() %>" style="text-decoration: none">Cancel</a></button></td>
 </tr>
 <% } %>
  </table>
<br>
<button><a href="goBack" style="text-decoration: none">Goto back</a></button>

</body>
</html>