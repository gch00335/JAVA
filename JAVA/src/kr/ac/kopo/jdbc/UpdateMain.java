package kr.ac.kopo.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import kr.ac.kopo.util.ConnectionFactory;
import kr.ac.kopo.util.JDBCClose;

/*
 * 아이디 입력 : hong
 * 수정할 이름을 입력 : 홍길수
 * 이름변경이 완료되었습니다.
 * 
 * 아이디를 입력 : hong2
 	수정할 이름을 입력 : 홍길수
 	아이디가 존재하지 않습니다
 */


public class UpdateMain {

	
	public static void main(String[] args) {

		Connection conn = null ;
		PreparedStatement pstmt = null; 
		
		try {
			
			conn =new ConnectionFactory().getConnection();
			
			Scanner sc = new Scanner(System.in);
			System.out.println("아이디를 입력 : ");
			String id = sc.nextLine();
			System.out.println("변경할 이름을 입력 :");
			String name = sc.nextLine();
			
			String sql = "update t_test ";
			       sql += "set name = ? ";
			       sql += " where id = ? ";
			        // 자세히 보면 " 앞에 공백으로 한칸 씩 띄어져 있는 것을 볼 수 있다.
			        // 간혹가다 밑에문장과 자동으로 연결이 될때가 있으므로 , 꼭 이렇게 한 칸씩 띄어쓰는 
			       // 쿼리만드는 습관을 하면 좋다.
			       
			       
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,name);
			pstmt.setString(2, id);
			
			int cnt = pstmt.executeUpdate();
			if(cnt == 0) {
				System.out.println("해당아이디가 존재하지 않습니다.");
			}else {
				System.out.println("이름변경이 완료되었습니다.");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCClose.close(pstmt, conn);
		}
	}
}
