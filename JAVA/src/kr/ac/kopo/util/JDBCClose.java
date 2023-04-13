package kr.ac.kopo.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement; //이게 에러의 문제였음..항상..잘확인하기...후..

public class JDBCClose {

public static void close(Statement stmt, Connection conn) {
		
		if(stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
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
