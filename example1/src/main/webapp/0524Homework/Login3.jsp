<%@ page import="Homework0524.LoginBean2" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<jsp:useBean id="login" class="Homework0524.LoginBean2"/>
<jsp:setProperty name="login" property="id"/>
<jsp:setProperty name="login" property="password"/>
<%
if(login.dbCheck()){
%>
<jsp:getProperty property="id" name="login"/>님이 로그인 했습니다.
<%
}else{
%>
<jsp:forward page="Login3.html"/>
<%
}
%>
<%
	String id = request.getParameter("id");
    String password = request.getParameter("password");

    LoginBean2 loginBean = new LoginBean2();
    loginBean.setId(id);
    loginBean.setPassword(password);

    if (loginBean.dbCheck()) {
        // 로그인 성공
        response.sendRedirect("Main3.jsp");
    } else {
        // 로그인 실패
        response.sendRedirect("Error3.jsp");
    }
%>
</body>
</html>