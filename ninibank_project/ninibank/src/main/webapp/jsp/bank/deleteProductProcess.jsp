<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="java.sql.*" %>
<meta charset="EUC-KR">
<%
      // DB ���� ����
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String username = "hr";
	String password = "hr";

    // ���޹��� �Ķ���� ����
    int productID = Integer.parseInt(request.getParameter("productID"));
    
    // DB ���� �� ��ǰ ���� ó��
    Connection conn = null;
    PreparedStatement pstmt = null;
    try {
        // JDBC ����̹� �ε�
        Class.forName("oracle.jdbc.driver.OracleDriver");
        
        // DB ����
        conn = DriverManager.getConnection(url, username, password);
        
        // SQL ���� ����
        String sql = "DELETE FROM account_products WHERE productID = ?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, productID);
        
        int rowsAffected = pstmt.executeUpdate();
        if (rowsAffected > 0) {
            // ��ǰ ���� ����
            response.sendRedirect("productManagement.jsp");
        } else {
            // ��ǰ ���� ����
            out.println("��ǰ ������ �����߽��ϴ�.");
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        // ���ҽ� ����
        if (pstmt != null) {
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
%>