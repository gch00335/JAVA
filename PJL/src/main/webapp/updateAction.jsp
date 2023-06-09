<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="user.User"%>
<%@ page import="user.UserDAO"%>
<%@ page import="java.io.PrintWriter"%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="user" class="user.User" scope="page" />
<jsp:setProperty name="user" property="ID" />
<jsp:setProperty name="user" property="PASSWORD" />
<jsp:setProperty name="user" property="name" />
<jsp:setProperty name="user" property="gender" />
<jsp:setProperty name="user" property="email" />

<%
// 폼으로부터 전송된 데이터를 받아옴
String password = request.getParameter("PASSWORD");
String name = request.getParameter("name");
String gender = request.getParameter("gender");
String email = request.getParameter("email");

// 세션에 저장된 userID를 확인
String userID = (String) session.getAttribute("userID");

// UserDAO 인스턴스 생성
UserDAO userDAO = new UserDAO();

// getUserInfo 메서드를 사용하여 현재 로그인한 사용자의 정보를 가져옴
User currentUser = userDAO.getUserInfo(userID);

    // updateUser 메서드를 사용하여 사용자 정보 업데이트
    int result = userDAO.updateUser(user);

    if (result > 0) {
        // 업데이트 성공
        PrintWriter script = response.getWriter();
        script.println("<script>");
        script.println("alert('사용자 정보가 업데이트되었습니다.')");
        script.println("location.href='userProfile.jsp'");
        script.println("</script>");
    } else {
        // 업데이트 실패
        PrintWriter script = response.getWriter();
        script.println("<script>");
        script.println("alert('사용자 정보 업데이트에 실패하였습니다.')");
        script.println("history.back()");
        script.println("</script>");
    }

%>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>니니찌니 도서관</title>
<body>

</body>
</html>