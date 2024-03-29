<%@page import="kr.ac.kopo.util.ConnectionFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>	
<%@ page import="kr.ac.kopo.user.User"%>
<%@ page import="kr.ac.kopo.user.UserDAO"%>
<%@ page import="java.io.PrintWriter"%>

<%
request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="user" class="kr.ac.kopo.user.User" scope="page" />
<jsp:setProperty name="user" property="ID" />
<jsp:setProperty name="user" property="PASSWORD" />
<jsp:setProperty name="user" property="name" />
<jsp:setProperty name="user" property="phone" />
<jsp:setProperty name="user" property="email" />
<jsp:setProperty name="user" property="post" />
<jsp:setProperty name="user" property="addr" />
<jsp:setProperty name="user" property="DETAILADDRESS" />
<jsp:setProperty name="user" property="birth" />

<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>니니찌니 도서관</title>
<body>
	<%
	String userID = null;
	if (session.getAttribute("userID") != null) {
		userID = (String) session.getAttribute("userID");
	}
	System.out.print("addr");
	if (userID != null) {
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('이미 로그인이 되어있습니다.')");
		script.println("location.href = 'main.jsp'");
		script.println("</script>");
	}

	if (user.getID() == null || user.getPASSWORD() == null || user.getName() == null
			|| user.getEmail() == null   || user.getPhone() == null || user.getPost()== null 
			|| user.getAddr()== null|| user.getBirth() == null) {
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('입력이 안 된 사항이 있습니다.')");
		script.println("history.back()");
		script.println("</script>");
	} else {
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		UserDAO userDAO = new UserDAO(connectionFactory);
		int result = userDAO.join(user);

		if (result == -1) {
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('이미 존재하는 아이디입니다.')");
			script.println("history.back()");
			script.println("</script>");
		} else {
			session.setAttribute("ID", user.getID());
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('회원가입이 완료되었습니다.')");
			script.println("location.href = 'main.jsp'");
			script.println("</script>");
		}
	}
	%>
</body>
</html>