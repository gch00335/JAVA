<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="kr.ac.kopo.bank.Bank"%>
<%@page import="java.util.ArrayList"%>
<%@page import="kr.ac.kopo.bank.BankDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
    // 데이터베이스 연결 설정
     // DB 연결 정보
    String url = "jdbc:oracle:thin:@localhost:1521:xe";
    String username = "hr";
    String password = "hr";

    Connection conn = null;
    try {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        conn = DriverManager.getConnection(url, username, password);
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    } catch (SQLException e) {
        e.printStackTrace();
    }
%>
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
    } 
 	// BankDAO 인스턴스 생성
   BankDAO bankDAO = new BankDAO();

    // getAccountList 메서드 호출 시 userID 전달
   ArrayList<Bank> accountList = bankDAO.getAccountList(userID);
	
%>

<%
    // 계좌 목록을 가져오기 위해 데이터베이스 연결을 설정한 상태로 가정

    String sql = "SELECT * FROM account WHERE user_id = ?";
	PreparedStatement pstmt = conn.prepareStatement(sql);
    pstmt.setString(1, userID);
    ResultSet rs = pstmt.executeQuery();

    // 결과 집합을 반복하며 계좌 세부 정보를 표시
    while (rs.next()) {
        String accountNumber = rs.getString("ac_number");
        // ... 다른 필요한 계좌 세부 정보를 가져오고 표시
%>
    <!-- 계좌 세부 정보를 테이블 또는 다른 적합한 형식으로 표시. -->
    <p>계좌 번호: <%= accountNumber %></p>
    <!-- 계좌 삭제를 위한 버튼 또는 링크를 추가합니다. -->
    <form action="deleteAccountProcess.jsp" method="post">
        <input type="hidden" name="accountNumber" value="<%= accountNumber %>">
        <button type="submit">계좌 삭제</button>
    </form>
<%
    }

    String accountNumberToDelete = request.getParameter("accountNumber");
    // 계좌 삭제를 위해 데이터베이스 연결을 설정한 상태로 가정
    String deleteSql = "DELETE FROM account WHERE ac_number = ?";
    PreparedStatement deletePstmt = conn.prepareStatement(deleteSql);
    deletePstmt.setString(1, accountNumberToDelete);
    deletePstmt.executeUpdate();
%>
</body>
</html>