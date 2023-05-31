<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<center>
Include File...
<br/>
name : <%= request.getAttribute("name") %><br/>
data : <%= request.getParameter("data") %>
</center>

</body>
</html>