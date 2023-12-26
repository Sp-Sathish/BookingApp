<%@page import="java.util.*"%>
<%@page import="Dto.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EditTrain</title>
</head>
<body>

 <%TrainsDetails  train = (TrainsDetails)request.getAttribute("trains"); %>
<h2>Flight Details</h2>
<form action="EditTrains" method="post">
TrainNo: <input type="number" name="no" readonly="readonly" value="<%= train.getTrainNo()  %>" ><br>
<br>
TrainName: <input type="text" name="name" value="<%= train.getTrainName() %>"><br>
<br>
TotalSeats: <input type="number" name="totalSeats" value="<%= train.getTotalSeats()  %>"><br>
<br>
StartPoint: <input type="text" name="startpoint" value="<%= train.getStartPoint()  %>"><br>
<br>
Destination: <input type="text" name="destination" value="<%= train.getDestination()  %>"><br>
<br>
TotalPrice: <input type="number" name="totalprice" value="<%= train.getTotalPrice()  %>"><br>
<br>
StartTime: <input type="text" name="StartTime" value="<%= train.getStartTime()  %>"><br>
<br>
ReachTime: <input type="text" name="ReachTime" value="<%= train.getReachTime()  %>"><br>
<br>
<input type="submit">
</form>


</body>
</html>