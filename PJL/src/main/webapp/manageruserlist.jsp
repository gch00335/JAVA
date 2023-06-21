<%@page import="org.h2.expression.function.SubstringFunction"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter"%>
<%@ page import="kr.ac.kopo.user.User"%>
<%@ page import="kr.ac.kopo.user.UserDAO"%>
<%@ page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width" , initial-scale="1">
<link rel="stylesheet" href="css/bootstrap.css">
<title>니니찌니 도서관</title>
<style type="text/css">
	a, a:hover {
	color: #000000;
	test-dacoration: none;
	}
</style>
</head>
<body>
	<%
	String userID = null;
	if (session.getAttribute("ID") != null) {
		userID = (String) session.getAttribute("ID");
	}
	int pageNumber = 1;
	if (request.getParameter("pageNumber") != null) {
		pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
	}
	%>



	<nav class="navbar navbar-default">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="main.jsp">니니찌니 도서관</a>
		</div>
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
							<li><a href="managermain.jsp">메인</a></li>
			  <li><a href="managermain.jsp">메인</a></li>
			   	<li><a href="managerbookList.jsp">도서대출</a></li>
			   	 <li><a href="managerbooksearch.jsp">전자도서검색</a></li>
				<li><a href="managerbbs.jsp">자유게시판</a></li>
				<li><a href="addbooksearch.jsp">도서관리</a></li>
				<li><a href="userlist.jsp">회원목록</a></li>


			</ul>

			<%
			if (userID == null) {
			%>


			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">접속하기<span class="caret"></span>
				</a>
					<ul class="dropdown-menu">
						<li><a href="login.jsp">로그인</a></li>
						<li><a href="join.jsp">회원가입</a></li>
						<li><a href="manager.jsp">관리자모드</a></li>

					</ul></li>
			</ul>
			<%
			} else {
			%>

			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">관리자모드<span class="caret"></span>
				</a>
					<ul class="dropdown-menu">
						<li><a href="logoutAction.jsp">로그아웃</a></li>
						<%
						}
						%>
					
		</div>
	</nav>

	<div class="container">
		<div class="row">
			<table class="table table-striped"
				style="text-align: center; border: 1px solid #E6E6E6">
				<thead>
				<h1> 가 입 회 원 목 록 </h1>
					<tr>
					
						
						<th style="background-color: #BDBDBD; text-align: center;">아이디</th>
						<th style="background-color: #BDBDBD; text-align: center;">비밀번호</th>
						<th style="background-color: #BDBDBD; text-align: center;">이름</th>
						<th style="background-color: #BDBDBD; text-align: center;">성별</th>
						<th style="background-color: #BDBDBD; text-align: center;">이메일</th>
					</tr>
				</thead>
				<tbody>
					<%
					UserDAO userDAO = new UserDAO();
					ArrayList<User> list = userDAO.getList(pageNumber);
					for (int i = 0; i < list.size(); i++) {
					%>

					<tr>
						<td><%=list.get(i).getID()%></td>
						<td><%=list.get(i).getPASSWORD()%></td>
						<td><%=list.get(i).getName()%></td>
						<td><%=list.get(i).getGender()%></td>
						<td><%=list.get(i).getEmail()%></td>

					</tr>
					<%
					}
					%>
				</tbody>
			</table>
		
		</div>
	</div>

	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="js/bootstrap.js"></script>
</body>
</html>