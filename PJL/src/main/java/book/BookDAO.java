package book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    private static List<Book> books = new ArrayList<>();
    private static Long idCounter = 1L;

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

    public static boolean insertBook(String thumbnai, String isbn, String title, String authors, String contents) {
        Connection connection = getConnection();
        if (connection != null) {
            try {
                String insertQuery = "INSERT INTO books VALUES (?, ?, ?, ?, ?)";
                PreparedStatement statement = connection.prepareStatement(insertQuery);
               
                Book book = new Book(title, thumbnai, isbn, authors, contents);

                statement.setString(1, book.getTitle());
                statement.setString(2, book.getThumbnai());
                statement.setString(3, book.getIsbn());
                statement.setString(4, book.getAuthors());
                statement.setString(5, book.getContents());

                int rowsAffected = statement.executeUpdate();
                statement.close();
                return rowsAffected > 0;
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }




    public static List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        Connection connection = getConnection();
        if (connection != null) {
            try {
                String selectQuery = "SELECT * FROM books";
                PreparedStatement statement = connection.prepareStatement(selectQuery);
                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    String title = resultSet.getString("title");
                    String thumbnai = resultSet.getString("thumbnai");
                    String isbn = resultSet.getString("isbn");
                    String authors = resultSet.getString("authors");
                    String contents = resultSet.getString("contents");

                    Book book = new Book(title, thumbnai, isbn, authors, contents);
                    books.add(book);
                }

                resultSet.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return books;
    }
}
