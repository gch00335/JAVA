<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

<script type="text/javascript">
    setTimeout(function() {
        window.location.href = "Login.jsp";
    }, 3000); // 3초 후에 Login.jsp로 이동
</script>
</head>
<body>
<h1>Main Page</h1>
<p> 로그인을 환영합니다<p>

<a href ="/example1/0523Homework2/Logout2.jsp">로그아웃</a>
<br>
<hr>
 <h3>3초 후에 자동으로 로그아웃 됩니다.</h3>

</body>
</html>