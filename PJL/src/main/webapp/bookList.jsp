<%@page import="java.util.List"%>
<%@page import="org.h2.expression.function.SubstringFunction"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page import="java.io.PrintWriter"%>

<%@ page import="java.util.ArrayList"%>

<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.SQLException"%>
<%@page import="book.Book"%>
<%@page import="user.User"%>
<%@page import="user.UserDAO"%>
<%@page import="book.BookDAO"%>
<%@page import="rental.Rental"%>
<%@page import="rental.RentalDAO"%>


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
    .book-info-container {
        text-align: center;
        /
    }

    .book-info {
        padding: 20px;
      
        border: 1px solid #dee2e6;
        
        margin: 0 auto; /* 가운데로 위치하도록 설정 */
        max-width: 600px; /* 최대 너비 설정 */
        margin-bottom: 30px;
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
</style>
</head>
<%
    // BookDAO를 이용하여 모든 책 정보 가져오기
    List<Book> bookList = BookDAO.getAllBooks();
%>
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
						<%
						}
						%>
					
		</div>
	</nav>

	<div class="container">
		<div class="row">
			<div class="col-md-6">
				<div class="input-group">
					<input id="searchInput" type="text" class="form-control"
						placeholder=" 도서명 입력"> <span class="input-group-btn">
						<button id="searchButton" class="btn btn-primary" type="button">도서
							검색</button>
					</span>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div id="book-info"></div>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.7.0.js"
		integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM="
		crossorigin="anonymous"></script>

<body>




 <table class="book-info">
 
    <tbody>
        <% for (Book book : bookList) { %>
        <tr>
          <td colspan="5">
                <div class="book-info">
                    <h3 class="book-table h3"><%= book.getTitle() %></h3>
                    <img class="book-info img" src="<%= book.getThumbnai() %>">
                    <p class="book-info p"><%= book.getIsbn() %></p>
                    <p class="book-info p"><%= book.getAuthors() %></p>
                    <p class="book-info p"><%= book.getContents() %></p>
                    
                    
          <button class="rent-button" data-title="<%= book.getTitle() %>" data-thumbnai="<%= book.getThumbnai() %>"
    data-isbn="<%= book.getIsbn() %>" data-ID="<%= userID %>">대출</button>
            </div>
               
            </td>
        </tr>
        <% } %>
    </tbody>
    
<script>
    $(document).ready(function() {
        $(".rent-button").click(function() {
            var title = $(this).data("title");
            var thumbnai = $(this).data("thumbnai");
            var isbn = $(this).data("isbn");
            var ID = $(this).data("id");

            var button = $(this); // 대출 버튼을 변수에 저장

            $.ajax({
                method: "post",
                url: "rentalProcess.jsp",
                data: {
                    title: title,
                    thumbnai: thumbnai,
                    isbn: isbn,
                    ID: ID
                }
            }).done(function(response) {
                console.log("Response:", response); // response 값 출력

                var bookInfo = button.closest(".book-info");
                var success = response.trim() === "true"; // 대출 성공 여부 확인

                if (success) {
                    //alert('대출 완료되었습니다.');

                    // 대출중 상태 표시(아 왜 계속 안되냐고 좋아 계쏙 안되면 반대로 해본다. 쒸익)
                   // bookInfo.append($("<p>").addClass("status").text("대출중").css("color", "red"));
                  //  button.remove(); // 대출 버튼 삭제
                } else {
                	 alert('대출 완료되었습니다.');
                    // 대출중 상태 표시
                    bookInfo.append($("<p>").addClass("status").text("대출중").css("color", "red"));
                    button.remove(); // 대출 버튼 삭제
                }
            });
        });
    });
    </script>
</table>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="js/bootstrap.js"></script>
</body>
</html>