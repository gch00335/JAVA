<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 


<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<c:out value="hello wrold"/>
<c:set var="price" scope="page" value="1000"/>
${price}
<c:if test = "${price > 500}">
<c:remove var="viggest!!!"/>
</c:if>
<c:remove var="price"/>

<c:choose>

	<c:when test="${price <=1000}">
	<c:out value="low"/>
	</c:when>	
	<c:when test="${price >1000}">
	<c:out value="big"/>
	</c:when>
	<c:otherwise>
	<c:out value="others"/>
	</c:otherwise>
</c:choose>
</body>
</html>