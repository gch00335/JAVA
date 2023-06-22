<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.sql.*" %>
    <%@ page import="java.io.PrintWriter"%>
<%@ page import="kr.ac.kopo.bank.Bank"%>
<%@ page import="kr.ac.kopo.bank.BankDAO"%>
<%@ page import="kr.ac.kopo.product.ProductDAO"%>
<%@ page import="kr.ac.kopo.product.Product"%>
<!DOCTYPE html>
<meta charset="EUC-KR">
<%
    // DB ���� ����
    String url = "jdbc:oracle:thin:@localhost:1521:xe";
    String username = "hr";
    String password = "hr";
    
    // ���޹��� �Ķ���� ����
    String productName = request.getParameter("productName");
    double interestRate = Double.parseDouble(request.getParameter("interestRate"));
    double minimumBalance = Double.parseDouble(request.getParameter("minimumBalance"));
    
    // DB ���� �� ��ǰ �߰� ó��
    Connection conn = null;
    PreparedStatement pstmt = null;
    try {
        // JDBC ����̹� �ε�
        Class.forName("oracle.jdbc.driver.OracleDriver");
        
        // DB ����
        conn = DriverManager.getConnection(url, username, password);
        
     	// ��ǰ ��ȣ�� �Է¹޴� ����
        int productID = Integer.parseInt(request.getParameter("productID"));

        // SQL ���� ����
        String sql = "INSERT INTO account_products (productID, productName, interestRate, minimumBalance) VALUES (?, ?, ?, ?)";
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, productID);
        pstmt.setString(2, productName);
        pstmt.setDouble(3, interestRate);
        pstmt.setDouble(4, minimumBalance);
        
        int rowsAffected = pstmt.executeUpdate();
        if (rowsAffected > 0) {
            // ��ǰ �߰� ����
            response.sendRedirect("productManagement.jsp");
        } else {
            // ��ǰ �߰� ����
            out.println("��ǰ �߰��� �����߽��ϴ�.");
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