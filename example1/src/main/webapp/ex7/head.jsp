<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ page import = "java.util.Date" %>
  	<%@ page session = "false" %>
  
  <%!
  Date date;
  String name;
  String email;
  %>
  
  <%!
  public int getLength(){
	  	int len=email.length();
	  	return len;
  } 
  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
 <h1> 스크립트 테스트</h1>
 <%
  date = new Date();
 
 %>
현재날짜 : <%= date.toLocaleString() %>
 
</body>
</html>