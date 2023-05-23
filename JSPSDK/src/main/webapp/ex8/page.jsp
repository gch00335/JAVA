<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
String id = request.getParameter("id");
request.setAttribute("id",id);
session.setAttribute("id",id);
application.setAttribute("id",id);
%>
<h1><%= id %>로 로그인 하였습니다. <br/></h1>

<a href="./twopage.jsp"> 이동</a>
</body>
</html>