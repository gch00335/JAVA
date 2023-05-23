<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%@ page import="javax.servlet.http.HttpSession" %>    
<%@ page import="java.io.*" %> 
<%@ page import="java.util.*" %>

<%
	//고정된 ID,PW 설정
	String fixedID = "a";
    String fixedPW = "1234";
    
    // 넘겨받은 ID와 PW을 가져오기
    String inputID =request.getParameter("username");
    String inputPW =request.getParameter("password");
    
    
    //로그인 상태를 확인.
    boolean isLoggedIn = false;
    if(fixedID.equals(inputID)&& fixedPW.equals(inputPW)){
    	isLoggedIn = true;
    	}
    
    //로그인 상태를 세션에 저장
     HttpSession mysession = request.getSession();
     session.setAttribute("isLoggedIn", isLoggedIn);
%>
    
    
    <% 
    	if(isLoggedIn){
    		//등록되어있으면 메인 페이지로 이동
    		response.sendRedirect("Main.jsp");
    	} else {
    		// 등록되지 않았으면 에러 페이지로 이동
    		response.sendRedirect("Error.jsp");
    	}
    %>

   
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

</body>
</html>
