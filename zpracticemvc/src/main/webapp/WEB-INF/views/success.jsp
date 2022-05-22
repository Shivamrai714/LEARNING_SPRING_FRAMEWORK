<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>



<body>

	<h2 class="text-center"> ${Header} </h2>
   <p class="text-center"> ${desc} </p>
	
	<h1 class="text-center" style="color:green">${msg }</h1>
	
	<hr>

	<h1>Your User Name is : ${user.userName}</h1>
	<h1>Your Email is : ${user.email }</h1>
	<h1>Your Password is: ${user.password} : pls secure it</h1>



</body>
</html>