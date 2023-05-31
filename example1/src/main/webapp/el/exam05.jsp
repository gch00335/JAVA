<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ArrayList<String> nameList = new ArrayList<>();
	nameList.add("홍길동");
	nameList.add("강길동");
	nameList.add("고길동");
	
	pageContext.setAttribute("names", nameList);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	첫번째 이름 : <%= nameList.get(0) %><br>
	첫번째 이름 : <%= ((ArrayList)pageContext.getAttribute("names")).get(0) %><br>
	EL 첫번째 이름 : ${ names[0] }<br>
</body>
</html>