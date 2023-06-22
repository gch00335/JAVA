<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="java.sql.*" %>
<meta charset="EUC-KR">
<%
      // DB 연결 정보
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String username = "hr";
	String password = "hr";

    // 전달받은 파라미터 추출
    int productID = Integer.parseInt(request.getParameter("productID"));
    
    // DB 연결 및 상품 삭제 처리
    Connection conn = null;
    PreparedStatement pstmt = null;
    try {
        // JDBC 드라이버 로드
        Class.forName("oracle.jdbc.driver.OracleDriver");
        
        // DB 연결
        conn = DriverManager.getConnection(url, username, password);
        
        // SQL 쿼리 실행
        String sql = "DELETE FROM account_products WHERE productID = ?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, productID);
        
        int rowsAffected = pstmt.executeUpdate();
        if (rowsAffected > 0) {
            // 상품 삭제 성공
            response.sendRedirect("productManagement.jsp");
        } else {
            // 상품 삭제 실패
            out.println("상품 삭제에 실패했습니다.");
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        // 리소스 해제
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