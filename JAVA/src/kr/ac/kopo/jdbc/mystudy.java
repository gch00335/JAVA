package kr.ac.kopo.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.ac.kopo.util.ConnectionFactory;
import kr.ac.kopo.util.JDBCClose;

public class mystudy {

	public static void main(String[] args) {
	//1 접속
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			//2. 쿼리를 만들어
			
			conn = new ConnectionFactory().getConnection();
			
			//3. 실행을 해보기
			String sql = "select to_char(hire_date, 'yyyy-mm') as date1 from employees "+ 
			              "group by to_char(hire_date, 'yyyy-mm') " + "order by date1";
			
			pstmt = conn.prepareStatement(sql);
			
	
			//4. 결과 출력
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				String date = rs.getString("date1");
				System.out.println(date);
			}
			
		}catch (Exception e){
			e.printStackTrace();

			//5. 종료
		} finally {
			JDBCClose.close(pstmt, conn);
		}
 
	}

}
