<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<!-- http://localhost:8080/example1/el/exam08.jsp?type=S 요청시
	관리자 회원님 안ㄴ여하\ㅅ[요ㅗ 
	http://localhost:8080/example1/el/exam08.jsp?type=U
	일반사용자님 환영합니다 메세지 출력
	
	

-->
	<c:choose>
		<c:when test="${ param.type == 'S' }">
			<H2>관리자님 환영합니다!!</H2>
			</c:when>
		<c:when test="${ param.type eq 'U' }">
		<h2>일반자님 환영합니다!</H2>
		</c:when>
		<c:otherwise>
		<h2>파라미터가 잘못되었습니다</h2>
		</c:otherwise>
	</c:choose>		




<%-- 
	<c:if test="${ param.type == 'S' }">
	<h2>관리자님 환영합니다.</h2>
	</c:if>
	
	<c:if test="${ param.type eq 'U' }">
	<h2>일반사용자님 환영합니다</h2>
	</c:if>
			 --%>
</body>
</html>