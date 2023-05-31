<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Main Page</title>
</head>
<body>


<% 
    String sessionID = (String) session.getAttribute("id");
    String password = (String) session.getAttribute("password");
    %>

    <% if (sessionID != null) { %>
        <h1><%= sessionID %> 님 메인페이지</h1>
        <h3><%= sessionID %>님 환영합니다</h3>
         <form method="post" action="logOut.jsp">
        <input type="submit" value="로그아웃">
</form>
        
        
    <% } else { %>
        <h1>로그인되지 않았습니다.</h1>
        <a href="login.jsp">로그인 페이지로 이동</a>
    <% } %>

	
</body>
</html>
  