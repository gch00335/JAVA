<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ page import="book.Book"%>
<%@ page import="book.BookDAO"%>
<%@ page import="java.io.PrintWriter"%>

<%
request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="book" class="book.Book" scope="page" />
<jsp:setProperty name="book" property="isban" />
<jsp:setProperty name="book" property="title" />
<jsp:setProperty name="book" property="thumbnai" />
<jsp:setProperty name="book" property="contents" />
<jsp:setProperty name="book" property="authors" />
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>니니찌니 도서관</title>
<body>
<script>
<%
	String isbn = request.getParameter("isbn");
    String title = request.getParameter("title");
    String thumbnai = request.getParameter("thumbnai");
    String contents = request.getParameter("contents");
    String authors = request.getParameter("authors");


    // BookDAO를 이용하여 book 테이블에 책 정보 등록
    boolean success = BookDAO.insertBook(thumbnai, isbn, title, authors, contents);
    if (success) {
        out.println("책 등록 성공");
    } else {
        out.println("책 등록 실패");
    }
%>
</body>

</script>
</html>