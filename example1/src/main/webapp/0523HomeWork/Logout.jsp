<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%@ page import="javax.servlet.http.HttpSession" %>  

<% 
	// ������ �ʱ�ȭ�Ͽ� �α׾ƿ�
	HttpSession mysession = request.getSession();
	session.invalidate();
	// 3�� �Ŀ� �ڵ����� Login.jsp�� �����̷�Ʈ
	
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