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
request.setAttribute("name","hokim");
%>
<jsp:include page="include.jsp" flush="true">
<jsp:param name="data" value="hello"/>
</jsp:include>


</body>
</html>