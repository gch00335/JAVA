<%@ page import="kr.ac.kopo.user.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="kr.ac.kopo.bbs.Bbs"%>
<%@ page import="kr.ac.kopo.bbs.BbsDAO"%>
<%@ page import="java.io.PrintWriter"%>

<%
request.setCharacterEncoding("UTF-8");
%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" 
href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" 
integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" 
crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" 
integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" 
crossorigin="anonymous"></script>

<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" 
integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" 
crossorigin="anonymous"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>NINI_BANK</title>
</head>
<body>
	<%
	String userID = null;
	if (session.getAttribute("ID") != null){
		userID = (String) session.getAttribute("ID");
	}	    // 카카오톡 로그인 확인
	boolean isKakaoLoggedIn = false;
	String kakaoID = (String) session.getAttribute("kakaoID");
    if (kakaoID != null) {
        isKakaoLoggedIn = true;
        userID = (String) session.getAttribute("kakaoID");
        
        System.out.println(userID);   
        
    } 
    if(userID == null){
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('로그인을 하세요.')");
		script.println("location.href = '${pageContext.request.contextPath}/login.do'");
		script.println("</script>");
    }
    
    
	int bbsID = 0;
	if (request.getParameter("bbsID") != null) {
		bbsID = Integer.parseInt(request.getParameter("bbsID"));
	
	}
	
	Bbs bbs = new BbsDAO().getBbs(bbsID);
	
	System.out.println(bbs.getUserID());

	if (!userID.equals(bbs.getUserID())) {
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('권한이 없습니다.')");
		script.println("location.href = '${pageContext.request.contextPath}/bbs.do'");
		script.println("</script>");
	}
	else {
		

		if (request.getParameter("bbsTilte") == null || request.getParameter("bbsContent")== null 
			|| request.getParameter("bbsTilte").equals("") || request.getParameter("bbsContent").equals(""))  {
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('입력이 안 된 사항이 있습니다.')");
		script.println("history.back()");
		script.println("</script>");
		} else {
			BbsDAO bbsDAO = new BbsDAO();
				int result = bbsDAO.update(bbsID,request.getParameter("bbsTilte"), request.getParameter("bbsContent"));

			if (result == -1) {
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('글 수정에 실패했습니다.')");
			script.println("history.back()");
			script.println("</script>");
		} else {
			
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("location.href = '/jsp/bbs/bbs.jsp'");
			script.println("</script>");
		}
	}
}
	%>
</body>
</html>