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


<h2>welcome to Home</h2>
<% String message = (String)request.getAttribute("name"); %>
<% if(message != null){ %>
 <h2>hello <%= message %></h2>
 <% } %>
 
 <% String mess = (String)request.getAttribute("message1"); %>
<% if(mess != null){ %>
 <h2> <%= mess %></h2>
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
  <th>TotalPrice</th>
  <th>edit</th>
  <th>delete</th>
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
   
   
   <td><button><a href="edits?no=<%= t.getTrainNo()  %>" style="text-decoration: none">Edit</a></button></td>
   <td><button><a href="delete?no=<%= t.getTrainNo()  %>" style="text-decoration: none">delete</a></button></td>
  
  
 </tr>
 <% } %>
  </table>
  
   <h3><a href="AddTrain.jsp"  style ="text-decoration: none">Add Trains</a></h3>
   
   <h3><a href="AdminLogout"  style ="text-decoration: none">LogOut</a></h3>


</body>
</html>