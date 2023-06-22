package kr.ac.kopo.product;

import java.sql.Connection;
import java.sql.ResultSet;

import kr.ac.kopo.util.ConnectionFactory;

public class ProductDAO {
	private Connection conn;
	private ResultSet rs;

public ProductDAO () {
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
}