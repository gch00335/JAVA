<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%@ page import="javax.servlet.http.HttpSession" %>  

<% 
	// 세션을 초기화하여 로그아웃
	HttpSession mysession = request.getSession();
	session.invalidate();
	// 3초 후에 자동으로 Login.jsp로 리다이렉트
	
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1> </h1>
</body>
</html>