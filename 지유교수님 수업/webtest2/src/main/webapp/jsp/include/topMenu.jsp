<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<table style="width:100%" border="1">
	<tr>
		<td rowspan="2">로고</td>
		<td align="right">
			<span style="padding-right: 5px">즐겨찾기</span>
			<c:if test="${ not empty loginUser }">
			[${ loginUser.name }(${ loginUser.id })님 로그인중...]
			</c:if>
		</td>
	</tr>
	<tr>
		<td>
			<c:if test="${ loginUser.type eq 'S' }">
				회원관리 |
			</c:if>
			 게시판 |
			<c:choose> 
				<c:when test="${ empty loginUser }"> 
			 		회원가입 | 
			 		<a href="/webtest2/jsp/login.jsp">로그인</a> |
			 	</c:when>
			 	<c:otherwise> 
			 		마이페이지 | 
			 		<a href="/webtest2/jsp/logout.jsp">로그아웃</a>
			 	</c:otherwise>
			</c:choose>  
		</td>
	</tr>
</table>
