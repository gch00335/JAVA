package kr.ac.kopo.jcbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBMain {

	public static void main(String[] args) {
		//1.드라이버 로딩
	
		try {
			// 1. 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이빙 로딩 완료");
	
			
			//2. DB접속
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr"); 
			// 남에 컴에 들어가고 싶을 때 접속하고 싶은 아이디를 써주면 됨
			// 연결되면 커넥션을 받을 수 있다.
			System.out.println("DB연결 성공");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 오라클 jdbc.driver에 있는 오라클 드라이브클래스에 의해서 접속하고 싶어!
		// 컴파일 예외처리로 인해 오류가 안나도록 하라라고 저렇게 빨간색 오류가 나는거임
	}

}
//이제 접속을 해볼건데 드라이버 매니저가 필요하다!
//추상클래스, 인터페이스와 같은느낌이라 생각하면됨
// 
