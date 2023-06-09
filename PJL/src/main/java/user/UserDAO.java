package user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import user.User;
import bbs.Bbs;

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
		String insertSQL = "INSERT INTO USERS VALUES (?, ?, ?, ?, ?)";
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
				pstmt.setString(4, user.getGender());
				pstmt.setString(5, user.getEmail());
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
		return -2; // 회占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙
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
				user.setGender(rs.getString(4));
				user.setEmail(rs.getString(5));

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
				user.setGender(resultSet.getString("Gender"));
				user.setEmail(resultSet.getString("Email"));
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
	            user.setGender(resultSet.getString("Gender"));
	            user.setEmail(resultSet.getString("Email"));
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
	        String query = "UPDATE users SET password = ?,name = ?, gender = ?, email = ? WHERE id = ?";
	        statement = connection.prepareStatement(query);
	        statement.setString(1, user.getID());
	        statement.setString(2, user.getPASSWORD());
	        statement.setString(3, user.getName());
	        statement.setString(4, user.getGender());
	        statement.setString(5, user.getEmail());
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
}