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
    // �����ͺ��̽� ���� ����
     // DB ���� ����
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
	}	    // īī���� �α��� Ȯ��
	boolean isKakaoLoggedIn = false;
	String kakaoID = (String) session.getAttribute("kakaoID");
    if (kakaoID != null) {
        isKakaoLoggedIn = true;
        userID = (String) session.getAttribute("kakaoID");
    } 
 	// BankDAO �ν��Ͻ� ����
   BankDAO bankDAO = new BankDAO();

    // getAccountList �޼��� ȣ�� �� userID ����
   ArrayList<Bank> accountList = bankDAO.getAccountList(userID);
	
%>

<%
    // ���� ����� �������� ���� �����ͺ��̽� ������ ������ ���·� ����

    String sql = "SELECT * FROM account WHERE user_id = ?";
	PreparedStatement pstmt = conn.prepareStatement(sql);
    pstmt.setString(1, userID);
    ResultSet rs = pstmt.executeQuery();

    // ��� ������ �ݺ��ϸ� ���� ���� ������ ǥ��
    while (rs.next()) {
        String accountNumber = rs.getString("ac_number");
        // ... �ٸ� �ʿ��� ���� ���� ������ �������� ǥ��
%>
    <!-- ���� ���� ������ ���̺� �Ǵ� �ٸ� ������ �������� ǥ��. -->
    <p>���� ��ȣ: <%= accountNumber %></p>
    <!-- ���� ������ ���� ��ư �Ǵ� ��ũ�� �߰��մϴ�. -->
    <form action="deleteAccountProcess.jsp" method="post">
        <input type="hidden" name="accountNumber" value="<%= accountNumber %>">
        <button type="submit">���� ����</button>
    </form>
<%
    }

    String accountNumberToDelete = request.getParameter("accountNumber");
    // ���� ������ ���� �����ͺ��̽� ������ ������ ���·� ����
    String deleteSql = "DELETE FROM account WHERE ac_number = ?";
    PreparedStatement deletePstmt = conn.prepareStatement(deleteSql);
    deletePstmt.setString(1, accountNumberToDelete);
    deletePstmt.executeUpdate();
%>
</body>
</html>