<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<%@ include file= "head.jsp" %>


<br/>

<% 
	name = request.getParameter("name");
 	email = request.getParameter("email");
 %>
 name : <%= name %> <br/>
 email : <%= email %><br/>
 	
 	<%= date.getDate() %> �� �Դϴ�. �̹迭�� ���̴� <%= getLength() %>�Դϴ�.
</body>
</html>