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
String requestID = (String)request.getAttribute("id");
String sessionID = (String)session.getAttribute("id");
String applicationID = (String)application.getAttribute("id");
%>
request : <%= requestID %></br>
session : <%= sessionID %></br>
application : <%= applicationID %>

</body>
</html>