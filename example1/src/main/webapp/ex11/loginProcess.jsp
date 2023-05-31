<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="login" class="ex10.LoginBean" />
   <jsp:setProperty name="login" property="id" />
   <jsp:setProperty name="login" property="password" />
   <%
   String id = request.getParameter("id");
   String password = request.getParameter("password");

   if (login.dbCheck()) {
      Cookie idCookie = new Cookie("id", id);
      Cookie passwordCookie = new Cookie("password", password);

      session.setAttribute("id", id);
      session.setAttribute("password", password);

      idCookie.setMaxAge(3600);
      passwordCookie.setMaxAge(3600);

      response.addCookie(idCookie);
      response.addCookie(passwordCookie);

      response.sendRedirect("mainPage.jsp");
   } else {
      response.sendRedirect("error.jsp");
   }
   %>


	

</body>
</html>
  