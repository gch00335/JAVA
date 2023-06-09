<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter" %>
 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name = "viewport" content="width=device-width", initial-scale="1">
<link rel = "stylesheet" href="css/bootstrap.css">
<title>니니찌니 도서관</title>
<style>
  .transparent-image {
    opacity: 0.7; /* 투명도 조절 */
    width: 100%; /* 가로로 꽉 차게 */
    max-height: 300px; /* 세로 길이 조절 */
  }
</style>

</head>
<body>

<%   

	String userID = null;
	if (session.getAttribute("ID") != null){
		userID = (String) session.getAttribute("ID");
	}

%>



	<nav class="navbar navbar-default">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="main.jsp">니니찌니 도서관</a>
		</div>
		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li><a href="main.jsp">메인</a></li>
				<li><a href="bookList.jsp">도서대출</a></li>
				<li><a href="booksearch.jsp">전자도서검색</a></li>
				<li><a href="bbs.jsp">자유게시판</a></li>
			</ul>
			
			<% 
				if(userID == null){
			%>
			
			
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown">
					<a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">접속하기<span class="caret"></span> </a>
					<ul class="dropdown-menu">
						<li><a href="login.jsp">로그인</a></li>
						<li><a href="join.jsp">회원가입</a></li>
						<li><a href="manager.jsp">관리자모드</a></li>

					</ul>
				</li>
			</ul>
			<%
				} else {
			%>
			
						<ul class="nav navbar-nav navbar-right">
				<li class="dropdown">
					<a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">회원관리<span class="caret"></span> </a>
					<ul class="dropdown-menu">
						<li><a href="mypage.jsp">마이페이지</a></li>
						<li><a href="logoutAction.jsp">로그아웃</a></li>
			<%
				}
			%>
		</div>
	</nav>
	<div> <img src="css/책.jpg" alt="사진 설명" class="transparent-image"> </div> 
	
 	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
 	<script src="js/bootstrap.js"></script>
</body>
</html>