<%@page import="user.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>니니찌니 도서관</title>
<body>
<%
	session.invalidate();
%>
	<script>
		location.href = 'main.jsp';
	</script>
</body>
</html>