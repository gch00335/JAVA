<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%@ page import="javax.servlet.http.HttpSession" %>    
<%@ page import="java.io.*" %> 
<%@ page import="java.util.*" %>

<%
	//������ ID,PW ����
	String fixedID = "a";
    String fixedPW = "1234";
    
    // �Ѱܹ��� ID�� PW�� ��������
    String inputID =request.getParameter("username");
    String inputPW =request.getParameter("password");
    
    
    //�α��� ���¸� Ȯ��.
    boolean isLoggedIn = false;
    if(fixedID.equals(inputID)&& fixedPW.equals(inputPW)){
    	isLoggedIn = true;
    	}
    
    //�α��� ���¸� ���ǿ� ����
     HttpSession mysession = request.getSession();
     session.setAttribute("isLoggedIn", isLoggedIn);
%>
    
    
    <% 
    	if(isLoggedIn){
    		//��ϵǾ������� ���� �������� �̵�
    		response.sendRedirect("Main.jsp");
    	} else {
    		// ��ϵ��� �ʾ����� ���� �������� �̵�
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