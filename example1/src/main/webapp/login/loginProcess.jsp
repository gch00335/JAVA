<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% 
	/*
	작업순서
	1. 피라미터 추출(아이디, 패스워드)
	2. 추출된 파라미터를 가진 회원 검색
	3. 검색결과에 따른 화면 구성
	*/
	
	request.setCharacterEncoding("utf-8");

	String id =request.getParameter("id");
	String password = request.getParameter("password");

			System.out.println("id : " + id + ", password : " + password);
	%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>

