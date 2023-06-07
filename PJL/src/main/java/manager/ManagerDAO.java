package manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ManagerDAO {
 
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

		public static Connection getConnection() {
			try {
				Class.forName("org.h2.Driver");
				String url = "jdbc:h2:tcp://localhost/~/test";
				return DriverManager.getConnection(url, "sa", "");
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		
		public int login2(String ID, String PASSWORD) {
			 conn = getConnection(); // �����ͺ��̽� ������ ������
			String SQL ="SELECT PASSWORD FROM MANAGER WHERE ID =?" ;
			try {
				pstmt = conn.prepareStatement(SQL);
				pstmt.setString(1, ID);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					if(rs.getString(1).equals(PASSWORD))
						return 1 ; // �α��� ����
				else 
						return 0 ; // ��й�ȣ ����ġ
				}
				return -1;
				
			} catch(Exception e) {
				e.printStackTrace();
			}
			return -2; //  �����ͺ��̽� ����
			}
}
