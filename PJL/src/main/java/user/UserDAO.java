package user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserDAO {
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
//		public static void close( Statement stmt, Connection conn) {
//			
//			try {
//				if (stmt != null)
//					stmt.close();
//			} catch (Exception e) {
//				e.printStackTrace();
//			} finally {
//				stmt = null;
//			}
//			try {
//				if (conn != null)
//					conn.close();
//			} catch (Exception e) {
//				e.printStackTrace();
//			} finally {
//				conn = null;
//			}
//		}
//		
//		public static void close(ResultSet rs, Statement stmt, Connection conn) {
//			try {
//				if (rs != null)
//					rs.close();
//			} catch (Exception e) {
//				e.printStackTrace();
//			} finally {
//				stmt = null;
//			}
//			try {
//				if (stmt != null)
//					stmt.close();
//			} catch (Exception e) {
//				e.printStackTrace();
//			} finally {
//				stmt = null;
//			}
//			try {
//				if (conn != null)
//					conn.close();
//			} catch (Exception e) {
//				e.printStackTrace();
//			} finally {
//				conn = null;
//			}
//		}
	
	public int login(String ID, String PASSWORD) {
		 conn = getConnection(); // 데이터베이스 연결을 가져옴
		String SQL ="SELECT PASSWORD FROM USERS WHERE ID =?" ;
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, ID);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString(1).equals(PASSWORD))
					return 1 ; // 로그인 성공
			else 
					return 0 ; // 비밀번호 불일치
			}
			return -1;
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return -2; //  데이터베이스 오류
		}
	
	public int join(User user) {
		String checkSQL = "SELECT COUNT(*) FROM USERS WHERE ID = ?";
	    String insertSQL = "INSERT INTO USERS VALUES (?, ?, ?, ?, ?)";
	    try {
	        conn = getConnection();
	        
	        // 이미 존재하는 아이디인 경우
	        pstmt = conn.prepareStatement(checkSQL);
	        pstmt.setString(1, user.getID());
	        rs = pstmt.executeQuery();
	        if (rs.next() && rs.getInt(1) > 0) {
	          
	            return -1;
	        } else {  
	            pstmt = conn.prepareStatement(insertSQL);
	            pstmt.setString(1, user.getID());
	            pstmt.setString(2, user.getPASSWORD());
	            pstmt.setString(3, user.getName());
	            pstmt.setString(4, user.getGender());
	            pstmt.setString(5, user.getEmail());
	            return pstmt.executeUpdate(); 
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally { // 리소스 반환p
	        try {
	            if (rs != null) {
	                rs.close();
	            }
	            if (pstmt != null) {
	                pstmt.close();
	            }
	            if (conn != null) {
	                conn.close();
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    return -2; // 회원가입 실패
	}
}
