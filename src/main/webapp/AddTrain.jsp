<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Train Details</h2>
<form action="AddTrain" method="post">
TrainNo: <input type="number" name="no" ><br>
<br>
trainName: <input type="text" name="name" ><br>
<br>
TotalSeats: <input type="number" name="totalSeats" ><br>
<br>
StartPoint: <input type="text" name="startpoint" ><br>
<br>
Destination: <input type="text" name="destination" ><br>
<br>
TotalPrice: <input type="number" name="totalprice" ><br>
<br>
StartTime: <input type="text" name="StartTime" ><br>
<br>
ReachTime: <input type="text" name="ReachTime" ><br>
<br>
<input type="submit">
</form>


</body>
</html>