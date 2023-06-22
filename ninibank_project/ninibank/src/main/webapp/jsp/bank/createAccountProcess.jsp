<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="java.sql.*" %>
<%
	// DB 연결 정보
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String username = "hr";
	String password = "hr";
    
    // 전달받은 파라미터 추출
    int productID = Integer.parseInt(request.getParameter("productID"));
    
    // DB 연결 및 계좌 개설 처리
    Connection conn = null;
    PreparedStatement pstmt = null;
    try {
        // JDBC 드라이버 로드
        Class.forName("oracle.jdbc.driver.OracleDriver");
        
        // DB 연결
        conn = DriverManager.getConnection(url, username, password);
        
        // 선택된 상품 정보 조회
        String productQuery = "SELECT * FROM account_products WHERE productID = ?";
        pstmt = conn.prepareStatement(productQuery);
        pstmt.setInt(1, productID);
        ResultSet rs = pstmt.executeQuery();
        
        if (rs.next()) {
            // 상품 정보 가져오기
            String productName = rs.getString("productName");
            double interestRate = rs.getDouble("interestRate");
            double minimumBalance = rs.getDouble("minimumBalance");
            
            // 계좌 개설 로직 구현
            // ... 계좌 개설 처리 및 필요한 작업 수행 ...
            
            // 개설된 계좌 정보 출력
            out.println("계좌 개설이 완료되었습니다.<br>");
            out.println("상품명: " + productName + "<br>");
            out.println("이자율: " + interestRate + "<br>");
            out.println("최소잔액: " + minimumBalance + "<br>");
        } else {
            out.println("상품을 선택하지 않았습니다.");
        }
        
        rs.close();
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

