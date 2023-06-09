<%@page import="org.h2.expression.function.SubstringFunction"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter"%>
<%@ page import="bbs.Bbs"%>
<%@ page import="bbs.BbsDAO"%>
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
<style>
.book-info {
	padding: 20px;
	background-color: #f8f9fa;
	border: 1px solid #dee2e6;
	border-radius: 5px;
	margin-bottom: 20px;
}

.book-info img {
	max-width: 200px;
	height: auto;
	margin-bottom: 10px;
}

.book-info h3 {
	font-size: 18px;
	margin-bottom: 10px;
}

.book-info .isbn {
	font-size: 12px;
	margin-bottom: 10px;
}

.book-info p {
	font-size: 14px;
	margin-bottom: 10px;
}

.book-info .contents {
	font-size: 12px;
}

.book-info . contents {
	font-size: 12px;
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
		
				<%
				}
				%>
			
		</div>

		</div>
	</nav>

	<div class="container">
		<div class="row">
			<div class="col-md-6">
				<div class="input-group">
					<input id="searchInput" type="text" class="form-control"
						placeholder="도서 검색어 입력"> <span class="input-group-btn">
						<button id="searchButton" class="btn btn-primary" type="button">도서
							검색</button>
					</span>
				</div>
			</div>
		</div>
		<div class="row">
			<div id="bookInfo"></div>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.7.0.js"
		integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM="
		crossorigin="anonymous"></script>

	<script>
		$(document)
				.ready(
						function() {
							$("#searchButton")
									.click(
											function() {
												var searchQuery = $(
														"#searchInput").val();

												$
														.ajax(
																{
																	method : "GET",
																	url : "https://dapi.kakao.com/v3/search/book?target=title",
																	data : {
																		query : $(
																				"#searchInput")
																				.val()
																	},
																	headers : {
																		Authorization : "KakaoAK 5cb56e48a85f67e5073a5e69238d8b71"
																	}
																})

														.done(
																function(msg) {
																	console
																			.log(msg.documents[0].title);
																	console
																			.log(msg.documents[0].thumbnail);
																	console
																			.log(msg.documents[0].isbn);
																	console
																			.log(msg.documents[0].authors);
																	console
																			.log(msg.documents[0].contents);

																	var bookInfoDiv = $("#bookInfo");
																	bookInfoDiv
																			.empty();

																	for (var i = 0; i < msg.documents.length; i++) {
																		var currentBook = msg.documents[i];

																		var bookInfo = $(
																				"<div>")
																				.addClass(
																						"book-info");
																		bookInfo
																				.append($(
																						"<img>")
																						.attr(
																								"src",
																								currentBook.thumbnail));
																		bookInfo
																				.append($(
																						"<h3>")
																						.text(
																								currentBook.title));
																		bookInfo
																				.append($(
																						"<p>")
																						.addClass(
																								"isbn")
																						.text(
																								"ISBN: "
																										+ currentBook.isbn));
																		bookInfo
																				.append($(
																						"<p>")
																						.text(
																								"저자: "
																										+ currentBook.authors));
																		bookInfo
																				.append($(
																						"<p>")
																						.addClass(
																								"contents")
																						.text(
																								currentBook.contents));

																		bookInfoDiv
																				.append(bookInfo);
																	}
																})
														.fail(
																function(
																		jqXHR,
																		textStatus,
																		errorThrown) {
																	console
																			.log("요청 실패: "
																					+ textStatus
																					+ ", "
																					+ errorThrown);
																});
											});
						});
	</script>
	</div>
	</div>

	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="js/bootstrap.js"></script>
</body>
</html>