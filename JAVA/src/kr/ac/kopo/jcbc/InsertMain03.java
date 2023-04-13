package kr.ac.kopo.jcbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertMain03 {

	public static void main(String[] args) {
		
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {

			// 1단계
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2단계
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "hr";
			String password = "hr";

			conn = DriverManager.getConnection(url, user, password);
			
			// 3단계
			Scanner sc = new Scanner(System.in);
			
			System.out.print("삽입할 ID를 입력 : ");
			String id = sc.nextLine();
			
			System.out.print("삽입할 이름을 입력 : ");
			String name = sc.nextLine();
			
			String sql = "insert into t_test(id, name) values(?, ?) "; 
			            // ? 를 사용한 것은 이 자리에 언젠가 어떤 것이 들어올거라는 표시임
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, name);
			
			// 4단계
			int cnt = pstmt.executeUpdate();
			System.out.println("총 " + cnt + "개 행 삽입...");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
	