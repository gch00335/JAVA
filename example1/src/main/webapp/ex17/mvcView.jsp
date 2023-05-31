<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id = "login" class = "ex17.ModelBeans" scope="session"></jsp:useBean>
<center>
<jsp:getProperty property="id" name="login"/>님 환영합니다.

</center>

</body>
</html>