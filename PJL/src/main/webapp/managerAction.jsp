<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import = "manager.ManagerDAO" %>
    <%@ page import = "java.io.PrintWriter" %>
    <% request.setCharacterEncoding("UTF-8"); %>
    <jsp:useBean id="manager" class="manager.Manager" scope="page" />
    <jsp:setProperty name="manager" property="ID"/>
    <jsp:setProperty name="manager" property="PASSWORD"/>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name = "viewport" content="width=device-width", initial-scale="1">
<link rel = "stylesheet" href="css/bootstrap.css">
<title>니니찌니 도서관</title>
<body>
<%
	String userID = null;
	if(session.getAttribute("ID") != null ){
	 userID = (String) session.getAttribute("ID");
	}
	
	
	if(userID != null){
		PrintWriter script =response.getWriter();
		script.println("<script>");
		script.println("alert('이미 로그인이 되어있습니다.')");
		script.println("location.href = 'main.jsp'");
		script.println("</script>");
	}
	ManagerDAO managerDAO = new ManagerDAO();
	int result = managerDAO.login2(manager.getID(), manager.getPASSWORD());
	if(result == 1){
		session.setAttribute("ID", manager.getID());
		PrintWriter script =response.getWriter();
		script.println("<script>");
		script.println("location.href = 'managermain.jsp'");
		script.println("</script>");
	}
	else if (result == 0){
		PrintWriter script =response.getWriter();
		script.println("<script>");
		script.println("alert('비밀번호가 틀립니다.')");
		script.println("history.back()");
		script.println("</script>");
	}	
	 else if (result == -1){
		PrintWriter script =response.getWriter();
		script.println("<script>");
		script.println("alert('존재하지 않는 아이디입니다.')");
		script.println("history.back()");
		script.println("</script>");
	}
	 else if (result == -2){
			PrintWriter script =response.getWriter();
			script.println("<script>");
			script.println("alert('데이터베이스 오류가 발생했습니다.')");
			script.println("history.back()");
			script.println("</script>");
		}
%>
</body>
</html>