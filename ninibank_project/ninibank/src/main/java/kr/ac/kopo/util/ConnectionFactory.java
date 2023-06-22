package kr.ac.kopo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
public class ConnectionFactory {
public Connection getConnection() throws Exception {
		
		Connection conn = null;
			
		Class.forName("oracle.jdbc.driver.OracleDriver");

		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String password = "hr";

		conn = DriverManager.getConnection(url, user, password);

		return conn;
	}

public static void close(PreparedStatement stmt, Connection conn) {
	// TODO Auto-generated method stub
	
}
	
}