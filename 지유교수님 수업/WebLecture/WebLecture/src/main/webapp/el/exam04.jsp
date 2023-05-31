<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String[] nameArray = {"홍길동", "강길동", "고길동"};

	pageContext.setAttribute("names", nameArray);
	
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	첫번째 이름 : <%= nameArray[0] %><br>
	첫번째 이름 : <%= ((String[])pageContext.getAttribute("names"))[0] %><br>
	EL 첫번째 이름 : ${ names[0] }<br>
	EL 첫번째 이름 : ${ names[4] }<br>
</body>
</html>


