<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%@ page import="javax.servlet.http.HttpSession" %>  

<% 
	// ������ �ʱ�ȭ�Ͽ� �α׾ƿ�
	HttpSession mysession = request.getSession();
	session.invalidate();
	response.sendRedirect("Login2.jsp");

%>


<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

</body>
</html>