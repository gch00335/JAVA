
<%@page import="org.h2.expression.function.SubstringFunction"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter"%>
<%@ page import="kr.ac.kopo.user.User"%>
<%@ page import="kr.ac.kopo.user.UserDAO"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="javax.servlet.http.HttpSession"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width" , initial-scale="1">
<link rel="stylesheet" href="css/bootstrap.css">
<title>니니찌니 도서관</title>
<style>
.book-image {
	max-width: 200px;
	height: auto;
	margin-bottom: 10px;
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
				<li><a href="main.jsp">메인</a></li>
				<li><a href="bookList.jsp">도서대출</a></li>
				<li><a href="booksearch.jsp">전자도서검색</a></li>
				<li><a href="bbs.jsp">자유게시판</a></li>
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
				<li><a href="#"> <%=userID%> 님 <!-- 로그인된 아이디 표시 -->
				</a></li>
				<ul class="nav navbar-nav navbar-right">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">회원관리<span class="caret"></span>
					</a>
						<ul class="dropdown-menu">
							<li><a href="mypage.jsp">마이페이지</a></li>
							<li><a href="logoutAction.jsp">로그아웃</a></li>

						</ul></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">마이페이지<span class="caret"></span>
					</a>
						<ul class="dropdown-menu">
							<li><a href="mypage.jsp">대여목록</a></li>
							<li><a href="updateUserInfo.jsp">회원정보수정</a></li>
							<li><a href="deleteUser.jsp">회원탈퇴</a></li>
						</ul> <%
 }
 %>
		</div>

	</nav>
	    <div class="container">
        <div class="col-lg-4"></div>
        <div class="col-lg-4">
            <div class="jumbotron" style="padding-top: 20px;">
                <form method="post" action="updateAction.jsp">
                    <h3 style="text-align: center;">회원 정보 수정</h3>

                    <div class="form-group">
                        <input type="password" class="form-control" placeholder="비밀번호" name="PASSWORD" maxlength="20">
                    </div>

                    <div class="form-group">
                        <input type="text" class="form-control" placeholder="이름" name="name" maxlength="20">
                    </div>

                    <div class="form-group" style="text-align: center;">
                        <div class="btn-group" data-toggle="buttons">
                            <label class="btn btn-primary active">
                                <input type="radio" name="gender" autocomplete="off" value="남자" checked>남자
                            </label>
                            <label class="btn btn-primary">
                                <input type="radio" name="gender" autocomplete="off" value="여자">여자
                            </label>
                        </div>
                    </div>

                    <div class="form-group">
                        <input type="email" class="form-control" placeholder="이메일" name="email" maxlength="20" value="">
                    </div>

                    <input type="submit" class="btn btn-primary form-control" value="수정">
                </form>
            </div>
        </div>
    </div>
		<div class="col-lg-4"></div>

	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="js/bootstrap.js"></script>
</body>
</html>