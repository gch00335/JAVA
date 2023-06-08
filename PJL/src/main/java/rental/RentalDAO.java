package rental;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;

public class RentalDAO {
	
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
		

		public static boolean addRental(String title, String isbn, String thumbnai, String userID) {
		    boolean success = false;
		    try (Connection conn = getConnection();
		         PreparedStatement pstmt = conn.prepareStatement("INSERT INTO rental VALUES (?, ?, ?, ?)")) {

		        pstmt.setString(1, title);
		        pstmt.setString(2, thumbnai);
		        pstmt.setString(3, isbn);
		        pstmt.setString(4, userID);

		        int rowsAffected = pstmt.executeUpdate();
		        success = rowsAffected > 0;
		    } catch (Exception e) {
		        e.printStackTrace();
		    }

		    return success;
		}
}
