<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>Login</h1>
 <form action = "LoginProcess.jsp" method="post">
 	<label for="username">Username:</label>
 	<input type="text" id="username" name="username" required><br><br>
 	<label for="password">Password:</label>
 	<input type="password" id="password" name="password" required><br><br>
 	<input type="submit" value="Login">
 	
</body>
</html>