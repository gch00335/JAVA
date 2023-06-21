package rental;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import book.Book;

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
		

		public boolean addRental(String title, String isbn, String thumbnai, String userID) {
		    // 이미 대출 중인 도서인지 확인
		    if (this.isBookAlreadyRented(isbn)) {
		        return false;
		    }

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

		    public ArrayList<Book> getRentalListByUserID(String userID) {
		        ArrayList<Book> rentalList = new ArrayList<>();

		        String query = "SELECT * FROM rental WHERE userID = ?";
		        try {
		            conn = getConnection();
		            PreparedStatement statement = conn.prepareStatement(query);
		            statement.setString(1, userID);
		            ResultSet resultSet = statement.executeQuery();

		            while (resultSet.next()) {
		                String title = resultSet.getString("title");
		                String thumbnai = resultSet.getString("thumbnai");
		                String isbn = resultSet.getString("isbn");

		                Book book = new Book();
		                book.setTitle(title);
		                book.setThumbnai(thumbnai);
		                book.setIsbn(isbn);

		                rentalList.add(book);
		            }
		        } catch (SQLException e) {
		            e.printStackTrace();
		        } finally {
		            if (conn != null) {
		                try {
		                    conn.close();
		                } catch (SQLException e) {
		                    e.printStackTrace();
		                }
		            }
		        }

		        return rentalList;
		    }

		    public boolean isBookAlreadyRented(String isbn) {
		        try (Connection conn = getConnection();
		             PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM rental WHERE isbn = ?")) {

		            pstmt.setString(1, isbn);

		            try (ResultSet rs = pstmt.executeQuery()) {
		                return rs.next(); // 결과가 존재하면 이미 대출 중인 도서
		            }
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }

		        return false;
		    }
		    
		    // 대출 목록에서 책을 반납하는 메서드
		    public void returnBook(String title) {
		        Connection conn = null;
		        PreparedStatement pstmt = null;

		        try {
		            conn = getConnection();
		            String query = "DELETE FROM rental WHERE title = ?";
		            pstmt = conn.prepareStatement(query);
		            pstmt.setString(1, title);
		            pstmt.executeUpdate();
		        } catch (SQLException e) {
		            e.printStackTrace();
		        } finally {
		            if (pstmt != null) {
		                try {
		                    pstmt.close();
		                } catch (SQLException e) {
		                    e.printStackTrace();
		                }
		            }
		            if (conn != null) {
		                try {
		                    conn.close();
		                } catch (SQLException e) {
		                    e.printStackTrace();
		                }
		            }
		        }
		    }
		    
}