<%@page import="kr.ac.kopo.util.ConnectionFactory"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="kr.ac.kopo.user.UserDAO"%>
<%@page import="kr.ac.kopo.user.User"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
      <jsp:useBean id="user" class="kr.ac.kopo.user.User" scope="page" />
    <jsp:setProperty name="user" property="ID"/>
    <jsp:setProperty name="user" property="PASSWORD"/>
<script>
	alert('${msg}')
	location.href = "${ pageContext.request.contextPath}";
	
	<%
String userID = null;
if(session.getAttribute("ID") != null ){
    userID = (String) session.getAttribute("ID");
}

if(userID != null){
    PrintWriter script = response.getWriter();
    script.println("<script>");
    script.println("alert('�̹� �α����� �Ǿ��ֽ��ϴ�.')");
    script.println("location.href = 'main.jsp'");
    script.println("</script>");
} else {
    ConnectionFactory connectionFactory = new ConnectionFactory();
    UserDAO userDAO = new UserDAO(connectionFactory);
    int result = userDAO.login(user.getID(), user.getPASSWORD());

    if (result == 1) {
        session.setAttribute("ID", user.getID());
        response.sendRedirect("main.jsp");
    } else if (result == 0) {
        PrintWriter script = response.getWriter();
        script.println("<script>");
        script.println("alert('��й�ȣ�� Ʋ���ϴ�.')");
        script.println("history.back()");
        script.println("</script>");
    } else if (result == -1) {
        PrintWriter script = response.getWriter();
        script.println("<script>");
        script.println("alert('�������� �ʴ� ���̵��Դϴ�.')");
        script.println("history.back()");
        script.println("</script>");
    } else if (result == -2) {
        PrintWriter script = response.getWriter();
        script.println("<script>");
        script.println("alert('�����ͺ��̽� ������ �߻��߽��ϴ�.')");
        script.println("history.back()");
        script.println("</script>");
    } else if (result == 2) {
        response.sendRedirect("managerindex.jsp");
    }
}
%>
</script>