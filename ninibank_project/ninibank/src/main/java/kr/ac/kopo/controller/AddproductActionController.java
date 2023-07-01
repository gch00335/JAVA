package kr.ac.kopo.controller;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddproductActionController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
		}

		// DB 연결 정보
	
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "hr";
		String password = "hr";
		String url2 = "";
		// 전달받은 파라미터 추출
		String productName = request.getParameter("productName");
		double interestRate = Double.parseDouble(request.getParameter("interestRate"));
		double minimumBalance = Double.parseDouble(request.getParameter("minimumBalance"));

		// DB 연결 및 상품 추가 처리
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			// JDBC 드라이버 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// DB 연결
			conn = DriverManager.getConnection(url, username, password);

			// 상품 번호를 입력받는 변수
			int productID = Integer.parseInt(request.getParameter("productID"));

			// SQL 쿼리 실행
			String sql = "INSERT INTO account_products (productID, productName, interestRate, minimumBalance) VALUES (?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, productID);
			pstmt.setString(2, productName);
			pstmt.setDouble(3, interestRate);
			pstmt.setDouble(4, minimumBalance);

			int rowsAffected = pstmt.executeUpdate();
			if (rowsAffected > 0) {
				// 상품 추가 성공
				url2 = "jsp/bank/productManagement.jsp";
				return "redirect:" + url2;
			} else {
				// 상품 추가 실패
				PrintWriter out = response.getWriter();
				out.println("상품 추가에 실패했습니다.");
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

		return url2;
	}

}
