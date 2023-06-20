package kr.ac.kopo.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import kr.ac.kopo.user.User;
import kr.ac.kopo.util.ConnectionFactory;

public class UserDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
    private ConnectionFactory connectionFactory;
   
    public UserDAO(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
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

	public int login(String ID, String PASSWORD) {
		conn = getConnection(); // 占쏙옙占쏙옙占싶븝옙占싱쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙
		String SQL = "SELECT PASSWORD FROM USERS WHERE ID =?";
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, ID);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				if (rs.getString(1).equals(PASSWORD))
					return 1; // 占싸깍옙占쏙옙 占쏙옙占쏙옙
				else
					return 0; // 占쏙옙橘占싫� 占쏙옙占쏙옙치
			}
			return -1;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return -2; // 占쏙옙占쏙옙占싶븝옙占싱쏙옙 占쏙옙占쏙옙
	}

	public int join(User user) {
		String checkSQL = "SELECT COUNT(*) FROM USERS WHERE ID = ?";
		String insertSQL = "INSERT INTO USERS VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			conn = getConnection();

			// 占싱뱄옙 占쏙옙占쏙옙占싹댐옙 占쏙옙占싱듸옙占쏙옙 占쏙옙占�
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
		            pstmt.setString(4, user.getEmail());
		            pstmt.setString(5, user.getBirth()); // 추가: 생년월일 설정
		            pstmt.setString(6, user.getPhone()); // 추가: 전화번호 설정
		            pstmt.setString(7, user.getPost()); // 추가: 우편번호 설정
		            pstmt.setString(8, user.getAddr()); // 추가: 주소 설정
		            pstmt.setString(9, user.getDETAILADDRESS());
		            pstmt.setString(10, user.getAdmin());
		            pstmt.setString(11, user.getAgree());
		            return pstmt.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally { // 占쏙옙占쌀쏙옙 占쏙옙환p
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

	public ArrayList<User> getList(int pageNumber) {
		conn = getConnection();
		String SQL = "SELECT * FROM USERS ";
		ArrayList<User> list = new ArrayList<User>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setID(rs.getString(1));
				user.setPASSWORD(rs.getString(2));
				user.setName(rs.getString(3));
				user.setEmail(rs.getString(4));

				list.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public User getID(String userID) {
		User user = null;

		String query = "SELECT * FROM USERS WHERE ID = ?";
		try (Connection conn = getConnection(); PreparedStatement statement = conn.prepareStatement(query)) {
			statement.setString(1, userID);

			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				user = new User();
				user.setID(resultSet.getString("ID"));
				user.setPASSWORD(resultSet.getString("PASSWORD"));
				user.setName(resultSet.getString("Name"));
				user.setEmail(resultSet.getString("Email"));
				user.setBirth(resultSet.getString("Bireth"));
				user.setPost(resultSet.getString("Post")); 
		        user.setAddr(resultSet.getString("Addr")); 
		        user.setDETAILADDRESS(resultSet.getString("DETAILADDRESS"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return user;
	}

	public User getUserInfo(String userID) {
	    Connection connection = null;
	    PreparedStatement statement = null;
	    ResultSet resultSet = null;

	    try {
	        connection = getConnection();
	        String query = "SELECT * FROM USERS WHERE ID = ?";
	        statement = connection.prepareStatement(query);
	        statement.setString(1, userID);
	        resultSet = statement.executeQuery();
	        if (resultSet.next()) {
	            User user = new User();
	            user.setID(resultSet.getString("ID"));
	            user.setPASSWORD(resultSet.getString("PASSWORD"));
	            user.setName(resultSet.getString("Name"));
	            user.setEmail(resultSet.getString("Email"));
	        	user.setBirth(resultSet.getString("Bireth"));
				user.setPost(resultSet.getString("Post")); 
		        user.setAddr(resultSet.getString("Addr"));
		        user.setDETAILADDRESS(resultSet.getString("DETAILADDRESS"));
	            return user;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        closeResultSet(resultSet);
	        closeStatement(statement);
	        closeConnection(connection);
	    }
	    return null;
	}

	public int updateUser(User user) {
	    Connection connection = null;
	    PreparedStatement statement = null;

	    try {
	        connection = getConnection();
	        String query = "UPDATE userS SET password = ?,name = ?, email = ?,Birth = ?, Post = ?, Addr = ?,DETAILADDRESS = ?  WHERE id = ?";
	        statement = connection.prepareStatement(query);
	        statement.setString(1, user.getID());
	        statement.setString(2, user.getPASSWORD());
	        statement.setString(3, user.getName());
	        statement.setString(4, user.getEmail());
	        statement.setString(5, user.getBirth());
	        statement.setString(6, user.getPost());
	        statement.setString(7, user.getAddr());
	        statement.setString(8, user.getDETAILADDRESS());
	        return statement.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return -1;
	    } finally {
	        closeStatement(statement);
	        closeConnection(connection);
	    }
	}

	private void closeResultSet(ResultSet resultSet) {
	    if (resultSet != null) {
	        try {
	            resultSet.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}

	private void closeStatement(PreparedStatement statement) {
	    if (statement != null) {
	        try {
	            statement.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}

	private void closeConnection(Connection connection) {
	    if (connection != null) {
	        try {
	            connection.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}
	
	
	public void saveKakaoID(String kakaoID) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = connectionFactory.getConnection();
            System.out.println("카카오에서 넘어온 ID: " + kakaoID);
            // 데이터베이스에 카카오 ID 저장
            String query = "INSERT INTO KAKAO (ID) VALUES (?)";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, kakaoID);
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();

            // 세션에 저장 완료 메시지 출력
            System.out.println("세션에 카카오 ID 및 데이터베이스 저장 완료");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("세션 및 데이터베이스 저장 실패");
        }
    }
	}