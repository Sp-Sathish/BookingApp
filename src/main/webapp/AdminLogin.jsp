<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
   #div1{
   border:1px solid blue;
      background-image:url("C:\Users\Sathish S\Pictures\Acer\railway-7.jpg");
      height:600px;
       
       background-size: cover;
   }
</style>
</head>
<body>

<div id="div1">
<form action="AdminLogin"  method="post">
   
   
         <h3>Admin Login</h3>
	     email:<input type="email" name="adminEmail" >
	     <br>
	     <br>
	     password:<input type="password" name="adminPass" >
	     <br>
	     <br>
	    
	     <input type="submit">
   </form>
   </div>


</body>
</html>