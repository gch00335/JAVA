<%@page import="kr.ac.kopo.util.ConnectionFactory"%>
<%@page import="kr.ac.kopo.user.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter"%>
<%@ page import="java.io.PrintWriter"%>
<%@ page import="kr.ac.kopo.user.User"%>
<%@ page import="kr.ac.kopo.user.UserDAO"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>

<head>

<meta charset="EUC-KR">
<title>NINI_BBS</title>

</head>

<body>

	<% 
// ConnectionFactory 객체 생성
ConnectionFactory connectionFactory = new ConnectionFactory();
UserDAO userDAO = new UserDAO(connectionFactory);

// 현재 로그인된 회원의 ID를 가져옴
String userID = null;
if (session.getAttribute("ID") != null) {
    userID = (String) session.getAttribute("ID");
}

// 카카오톡 로그인 확인
boolean isKakaoLoggedIn = false;
String kakaoID = (String) session.getAttribute("kakaoID");
if (kakaoID != null) {
    isKakaoLoggedIn = true;
    userID = (String) session.getAttribute("kakaoID");
}

// 회원 정보 조회
User user = null;
if (userID != null) {
    user = userDAO.getList(userID);
}

String action = request.getParameter("action");

if ("passwordCheck".equals(action)) {
    String currentPassword = request.getParameter("currentPassword");

    boolean passwordMatch = userDAO.checkPassword(userID, currentPassword);
    
    // 현재 비밀번호 확인 로직 구현
    if (!passwordMatch) {
        // 비밀번호가 일치하지 않는 경우 처리
        // 예를 들어, 오류 메시지를 설정하고 다시 회원정보 수정 페이지로 포워딩
        request.setAttribute("errorMessage", "현재 비밀번호가 일치하지 않습니다.");
        request.getRequestDispatcher("/jsp/login/updateUserInfo.jsp").forward(request, response);
    } else {
        request.setAttribute("message", "비밀번호가 일치합니다.");
        
        // 수정 폼을 보여주기 위해 userInfoForm을 보이도록 설정
        request.setAttribute("showUserInfoForm", true);
        
        // 회원 정보를 request에 설정하여 폼에서 사용할 수 있도록 함
        request.setAttribute("user", user);
        
        request.getRequestDispatcher("/jsp/login/updateUserInfo.jsp").forward(request, response);
    }
} else if ("update".equals(action)) {
    // 회원정보 수정 로직 구현
    
    // 예를 들어, 수정된 정보를 DB에 업데이트
    String password = request.getParameter("password");
    String name = request.getParameter("name");
    String email = request.getParameter("email");
    String post = request.getParameter("post");
    String addr = request.getParameter("addr");
    String detailAddress = request.getParameter("detailAddress");

    // 사용자 입력값으로 회원 정보 업데이트
    user.setPASSWORD(password);
    user.setName(name);
    user.setEmail(email);
    user.setPost(post);
    user.setAddr(addr);
    user.setDETAILADDRESS(detailAddress);

    // 회원 정보 업데이트
    userDAO.updateUser(user);
    
    request.getRequestDispatcher("/jsp/login/updateUserInfo.jsp").forward(request, response);
}
%>
 
</body>

</html>