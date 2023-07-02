package kr.ac.kopo.bbs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import kr.ac.kopo.util.ConnectionFactory;

public class BbsDAO {
	private Connection conn;
	private ResultSet rs;
	
	 public BbsDAO() {
	        conn = getConnection();
	    }

	 public Connection getConnection() {
			try {
				ConnectionFactory connectionFactory = new ConnectionFactory();
				return connectionFactory.getConnection();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}


	 public String getDate() {
			String SQL = "SELECT TO_CHAR(SYSDATE, 'YYYY-MM-DD') FROM DUAL";
			try {
				 conn = getConnection(); // 수정된 부분
				PreparedStatement pstmt = conn.prepareStatement(SQL);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					return rs.getString(1);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return ""; // 데이터베이스 오류
		}

		public int getNext() {
			String SQL = "SELECT bbsID FROM BBS ORDER BY bbsID DESC";
			try {
				 conn = getConnection(); // 수정된 부분
				PreparedStatement pstmt = conn.prepareStatement(SQL);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					return rs.getInt(1) + 1;
				}
				return 1; // 첫번째 게시물인 경우
			} catch (Exception e) {
				e.printStackTrace();
			}
			return -1; // 데이터베이스 오류
		}
		public ArrayList<Bbs> getReplyList(int pbbsID) {
		    conn = getConnection();
		    String SQL = "SELECT * FROM BBS WHERE bbsID = ? OR pbbsID = ? AND bbsAvailable = 1 ORDER BY bbsID";
		    ArrayList<Bbs> list = new ArrayList<Bbs>();
		    try {
		        PreparedStatement pstmt = conn.prepareStatement(SQL);
		        pstmt.setInt(1, pbbsID);
		        pstmt.setInt(2, pbbsID);
		        rs = pstmt.executeQuery();
		        while (rs.next()) {
		            Bbs bbs = new Bbs();
		            bbs.setBbsID(rs.getInt(1));
		            bbs.setBbsTitle(rs.getString(2));
		            bbs.setUserID(rs.getString(3));
		            bbs.setBbsDate(rs.getString(4));
		            bbs.setBbsContent(rs.getString(5));
		            bbs.setBbsAvailable(rs.getInt(6));
		            bbs.setPbbsID(rs.getInt("pbbsID")); // 답변의 경우 pbbsID로 설정

		            list.add(bbs);
		         
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		    return list;
		}
		public int write(String bbsTitle, String userID, String bbsContent, int pbbsID) {
			
			  String SQL = "INSERT INTO BBS VALUES(?, ?, ?, ?, ?, ?, ?)";
			    try {
			        conn = getConnection();
			        PreparedStatement pstmt = conn.prepareStatement(SQL);
			        pstmt.setInt(1, getNext());
			        pstmt.setString(2, bbsTitle);
			        pstmt.setString(3, userID);
			        pstmt.setString(4, getDate());
			        pstmt.setString(5, bbsContent);
			        pstmt.setInt(6, 1);
			        pstmt.setInt(7, pbbsID); 

			        return pstmt.executeUpdate();
			    } catch (Exception e) {
			        e.printStackTrace();
			    }
			    return -1; // 데이터베이스 오류
			}
		
		public ArrayList<Bbs> getList(int pageNumber) {
		    conn = getConnection();
		    int startRow = (pageNumber - 1) * 10 + 1;
		    int endRow = pageNumber * 10;
		    String SQL = "SELECT * FROM (SELECT M.*, ROWNUM AS RN FROM (SELECT bbsid, bbstitle, userid, bbsdate, bbscontent, bbsAvailable, pbbsid FROM bbs START WITH pbbsid = 0 CONNECT BY PRIOR bbsid = pbbsid ORDER SIBLINGS BY bbsid DESC) M) WHERE RN BETWEEN ? AND ?";
		    
		    
		    ArrayList<Bbs> list = new ArrayList<Bbs>();
		    try {
		        PreparedStatement pstmt = conn.prepareStatement(SQL);
		        pstmt.setInt(1, startRow);
		        pstmt.setInt(2, endRow);
		        rs = pstmt.executeQuery();
		        while (rs.next()) {
		            Bbs bbs = new Bbs();
		            bbs.setBbsID(rs.getInt(1));
		            bbs.setBbsTitle(rs.getString(2));
		            bbs.setUserID(rs.getString(3));
		            bbs.setBbsDate(rs.getString(4));
		            bbs.setBbsContent(rs.getString(5));
		            bbs.setBbsAvailable(rs.getInt(6));

		            int pbbsid = rs.getInt("pbbsid");
		            bbs.setPbbsID(pbbsid);

		            list.add(bbs);
		            
		      
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		    return list;
		}
	
	public boolean nextPage(int pageNumber) {
	    conn = getConnection();
	    int startRow = (pageNumber - 1) * 10 + 1;
	    int endRow = pageNumber * 10;
	    String SQL = "SELECT * FROM (SELECT M.*, ROWNUM AS RN FROM (SELECT bbsid, bbstitle, userid, bbsdate, bbscontent, bbsAvailable, pbbsid FROM bbs START WITH pbbsid = 0 CONNECT BY PRIOR bbsid = pbbsid ORDER SIBLINGS BY bbsid DESC) M) WHERE RN BETWEEN ? AND ?";
	    ArrayList<Bbs> list = new ArrayList<Bbs>();
	    try {
	        PreparedStatement pstmt = conn.prepareStatement(SQL);
	        pstmt.setInt(1, startRow);
	        pstmt.setInt(2, endRow);
	        rs = pstmt.executeQuery();
	        if (rs.next()) {
	            return true;
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return false;
	}
	
	public Bbs getBbs(int bbsID) {
		  conn = getConnection();
		String SQL = "SELECT * FROM BBS WHERE bbsID = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, bbsID);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				Bbs bbs = new Bbs();
				bbs.setBbsID(rs.getInt(1));
				bbs.setBbsTitle(rs.getString(2));
				bbs.setUserID(rs.getString(3));
				bbs.setBbsDate(rs.getString(4));
				bbs.setBbsContent(rs.getString(5));
				bbs.setBbsAvailable(rs.getInt(6));
				
				
				
				return bbs;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
		public int update(int bbsID, String bbsTitle, String bbsContent ) {
			conn = getConnection();
			String SQL = "UPDATE BBS SET bbsTitle = ?, bbsContent = ? WHERE bbsID = ?" ;
			try {
				PreparedStatement pstmt = conn.prepareStatement(SQL);
				pstmt.setString(1, bbsTitle);
				pstmt.setString(2, bbsContent);
				pstmt.setInt(3, bbsID);

				return pstmt.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return -1; // 데이터베이스 오류
		}
			public int delete (int bbsID) {
				conn = getConnection();
				String SQL = "UPDATE BBS SET bbsAvailable= 0 where bbsID = ?" ;
				try {
					PreparedStatement pstmt = conn.prepareStatement(SQL);
					pstmt.setInt(1, bbsID);
					

					return pstmt.executeUpdate();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				return -1; // 데이터베이스 오류
			}
		
		
}