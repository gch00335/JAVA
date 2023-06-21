<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page import="rental.Rental"%>
<%@ page import="rental.RentalDAO"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.SQLException"%>
<%@page import="book.Book"%>
<%@page import="kr.ac.kopo.user.User"%>
<%@page import="kr.ac.kopo.user.UserDAO"%>
<%@page import="book.BookDAO"%>


<%@ page import="java.io.PrintWriter"%>
<%
request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="rental" class="rental.Rental" scope="page" />
<jsp:setProperty name="rental" property="isbn" />
<jsp:setProperty name="rental" property="title" />
<jsp:setProperty name="rental" property="thumbnai" />
<jsp:setProperty name="rental" property="userID" />

<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>니니찌니 도서관</title>
</head>
<body>
	<%
	String title = request.getParameter("title");

	RentalDAO rentalDAO = new RentalDAO();
	rentalDAO.returnBook(title);

	response.sendRedirect("mypage.jsp");
	%>
</body>
</html>