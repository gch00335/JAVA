<%@page import="book.Book"%>
<%@page import="kr.ac.kopo.user.User"%>
<%@page import="rental.Rental"%>
<%@page import="rental.RentalDAO"%>
<%@page import="kr.ac.kopo.user.UserDAO"%>
<%@page import="org.h2.expression.function.SubstringFunction"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter"%>
<%@ page import="bbs.Bbs"%>
<%@ page import="bbs.BbsDAO"%>
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
    <li>
        <a href="#">
            <%= userID %> 님 <!-- 로그인된 아이디 표시 -->
        </a>
    </li>
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
				</ul>
			
			<%
			}
			%>
		</div>

</div>
	</nav>

	<div class="container">
		<div class="row">
			<table class="table table-striped"
				style="text-align: center; border: 1px solid #E6E6E6">
				<thead>
					<h1>대출 목록</h1>
					<tr>
						<th style="background-color: #BDBDBD; text-align: center;">이미지</th>
						<th style="background-color: #BDBDBD; text-align: center;">도서명</th>
						<th style="background-color: #BDBDBD; text-align: center;">ISBN</th>
						<th style="background-color: #BDBDBD; text-align: center;">반납</th>
					</tr>
				</thead>
				<tbody>
					<%
					UserDAO userDAO = new UserDAO();
					User user = userDAO.getID(userID);

					RentalDAO rentalDAO = new RentalDAO();
					ArrayList<Book> rentalList = rentalDAO.getRentalListByUserID(userID);

					for (Book book : rentalList) {
					%>
					<tr>
						<td><img class="book-image" src="<%=book.getThumbnai()%>"
							alt="Book Image"></td>
						<td style="vertical-align: middle; text-align: center;"><%=book.getTitle()%></td>
						<td style="vertical-align: middle; text-align: center;"><%=book.getIsbn()%></td>
						<td style="vertical-align: middle; text-align: center;">
							<form action="returnBook.jsp" method="post">
								<input type="hidden" name="title" value="<%=book.getTitle()%>">
								<input type="submit" value="반납">
							</form>
						</td>
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