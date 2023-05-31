<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>



<jsp:useBean id="login" class="ex10.LoginBean"/>
<jsp:setProperty name="login" property="id"/>
<jsp:setProperty name="login" property="password"/>
<%
if(login.dbCheck()){
%>


<jsp:getProperty property="id" name="login"/>님이 로그인 했습니다.
<%

}else{
%>
<jsp:forward page="login.html"/>
<%
}
%>



</body>
</html>