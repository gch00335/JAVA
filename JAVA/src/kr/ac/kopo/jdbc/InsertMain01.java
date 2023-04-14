package kr.ac.kopo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertMain01 {

	public static void main(String[] args) {
		
		Connection conn = null;
		Statement stmt = null;
		try {
			// 1. 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 2. DB 연결 후 연결객체 얻어오기
			String url = "jdbc:oracle:dthin:@localhost:1521:xe";
			String user = "hr";
			String password = "hr";
			conn = DriverManager.getConnection(url, user, password);
			//그런데 이렇게 오르는 건 추천하지 않는다
			//왜냐하면 이건 정보를 다 적는 것이기에 이상태로 깃허브에 올리게 되면 모든 정보가 
			//남들한테 공유가 되는 것이기 때문이다.
			
			
			System.out.println("conn : " + conn);
			
			// 3. 쿼리 생성
			
		   stmt = conn.createStatement();
			String sql = " update t_test "
					+ " set name ='박길동'"
					+ " where id = 'kang'";
			
			// 4. 실행 결과 얻어오기
			int cnt = stmt.executeUpdate(sql);
			System.out.println("총 " + cnt + "개 행이 삽입되었습니다");
			
			//sql이 가지고 있는 쿼리를 실행하라는 뜻!
			// 수행을 다하고나서는 연결되어 있는 것을 지워줘야 한다.
			// 그 종료를 finally에 해주면 된다.		
			
			
		} catch(Exception e) {
			e.printStackTrace();
			
		} finally {
			// 5. 종료
			if(stmt != null) {
				try {
					stmt.close();
				}catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}