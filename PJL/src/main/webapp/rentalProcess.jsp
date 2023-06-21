<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
	
<%@ page import="rental.Rental" %>
<%@ page import="rental.RentalDAO" %>
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
    // 전달된 파라미터 가져오기
    String title = request.getParameter("title");
	String thumbnai = request.getParameter("thumbnai");
    String isbn = request.getParameter("isbn");
    String ID = request.getParameter("ID");
    

    System.out.println("title: " + title);
    System.out.println("thumbnai: " + thumbnai);
    System.out.println("isbn: " + isbn);
    System.out.println("ID: " + ID);

    // 대출 요청 처리
  boolean success = new RentalDAO().addRental(title, isbn, thumbnai, ID);
  // 대출 성공 여부에 따라 처리
  
    if (success) {
        out.println("true");
    } else {
        out.println("false");
    }
%>

</body>
</html>