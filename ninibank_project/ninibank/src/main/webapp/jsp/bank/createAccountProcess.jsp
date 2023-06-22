<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="java.sql.*" %>
<%
	// DB ���� ����
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String username = "hr";
	String password = "hr";
    
    // ���޹��� �Ķ���� ����
    int productID = Integer.parseInt(request.getParameter("productID"));
    
    // DB ���� �� ���� ���� ó��
    Connection conn = null;
    PreparedStatement pstmt = null;
    try {
        // JDBC ����̹� �ε�
        Class.forName("oracle.jdbc.driver.OracleDriver");
        
        // DB ����
        conn = DriverManager.getConnection(url, username, password);
        
        // ���õ� ��ǰ ���� ��ȸ
        String productQuery = "SELECT * FROM account_products WHERE productID = ?";
        pstmt = conn.prepareStatement(productQuery);
        pstmt.setInt(1, productID);
        ResultSet rs = pstmt.executeQuery();
        
        if (rs.next()) {
            // ��ǰ ���� ��������
            String productName = rs.getString("productName");
            double interestRate = rs.getDouble("interestRate");
            double minimumBalance = rs.getDouble("minimumBalance");
            
            // ���� ���� ���� ����
            // ... ���� ���� ó�� �� �ʿ��� �۾� ���� ...
            
            // ������ ���� ���� ���
            out.println("���� ������ �Ϸ�Ǿ����ϴ�.<br>");
            out.println("��ǰ��: " + productName + "<br>");
            out.println("������: " + interestRate + "<br>");
            out.println("�ּ��ܾ�: " + minimumBalance + "<br>");
        } else {
            out.println("��ǰ�� �������� �ʾҽ��ϴ�.");
        }
        
        rs.close();
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

