<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="kr.ac.kopo.book.BookVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
/*
	// 1. 자바빈즈클래스 + 배열
	BookVO book = new BookVO();
	book.setTitle("성공");
	
	BookVO[] books = {book};
	
	pageContext.setAttribute("books", books);
*/

/*
	// 2. Map 객체 + 배열
	Map<String, String> book = new HashMap<>();
	book.put("title", "성공");
	
	Map[] books = {book};
	
	pageContext.setAttribute("books", books);
*/
/*
	// 3. 자바빈즈클래스 + 콜렉션
	BookVO book = new BookVO();
	book.setTitle("성공");
	
	List<BookVO> books = new ArrayList<>();
	books.add(book);
	
	pageContext.setAttribute("books", books);
*/

	// 4. Map 객체 + 컬렉션
	Map<String, String> book = new HashMap<>();
	book.put("title", "성공");
	
	List<Map<String, String>> books = new ArrayList<>();
	books.add(book);
	
	pageContext.setAttribute("books", books);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- 성공 출력 --%>
	성공/실패?? ${ books[0].title }<br>
</body>
</html>