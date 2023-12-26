<html>
<head>
 <style >
    body{
   
     /*background-color: aquamarine; */
    background-image:url(file:///C:/Users/Sathish%20S/eclipse-workspace/BokkingApp/src/main/webapp/railway-8.jpg);
    height:850px
    background-size:cover;
    text-align: center;
    background-color: #4C3A93;
    
    
  
    /* cover it will strech the image */
    /*background-size: 550px 550px;
    background-position:top right;
    background-attachment:fixed;*/
}
a{
 text-decoration: none ;
 font-family: sans-serif;
 color:#E1DFEE;
 
 
}
#main_div{
   border : 1px solid black ;
   margin-top: 300px;
   height:350px;
   width:400px;
   margin-left:500px;
   
  
}
#user{
margin-left: 30px;

}
button{
  background-color: #F96398;
  width:80px ;
  border-color: #F96398;
  border-radius: 5px;
}
  

 </style>
</head>

<body>


<div id="main_div"   >

<h3> Welcome to the booking App</h3>


<button id="admin"><a href="Admin.jsp" > Admin</a></button>
<button id="user"><a href="User.jsp" >User</a></button>

<% String message = (String)request.getAttribute("message"); %>
			<% if(message != null) { %>
				<h2> <%= message %></h2>
				<% } %>	
 </div>  
</body>
</html>
