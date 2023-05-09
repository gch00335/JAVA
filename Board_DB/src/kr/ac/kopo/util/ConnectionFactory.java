package kr.ac.kopo.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
//여기에 있던 주석을 지우니까..실행이 되었다.
//ㅠㅠ 교수님 수업을 따라가려면 주석을 달아야하는데,, 항상 주석때문에 오류가 나니 미치겠다..하..
// 일단 실행을 하면 오른쪽 화면처럼 저렇게 뜬다...
	
	//주석달린 방법과 밑 방법 중 하나를 선택해서 사용하면 된다.
	
	
	
	public Connection getConnection() throws Exception {
		
		Connection conn = null;
			
		Class.forName("oracle.jdbc.driver.OracleDriver");

		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String password = "hr";

		conn = DriverManager.getConnection(url, user, password);

		return conn;
	}
	/*
	public Connection getConnection() {
		
		Connection conn = null;
		try {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String password = "hr";
		
		conn = DriverManager.getConnection(url, user, password);
		
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return conn;
	}
	*/
}
