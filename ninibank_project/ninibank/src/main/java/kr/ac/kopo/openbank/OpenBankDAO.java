package kr.ac.kopo.openbank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.util.ConnectionFactory;

public class OpenBankDAO {
	
	private Connection conn;
	private ResultSet rs;
	private PreparedStatement stmt;

	public  OpenBankDAO() {
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
	
	
	

	public List<Openbank> getRelatedAccounts(String userID, String username) {
	    List<Openbank> accounts = new ArrayList<>();

	    // 타은행 계좌 정보를 가져오는 로직 작성
	    // 예시: @NA 테이블에서 이름으로 계좌 정보를 가져옴
	    String query = "SELECT * FROM ACCOUNT @NA WHERE MEMBER_NAME = ?";

	    try (Connection connection = getConnection();
	         PreparedStatement statement = connection.prepareStatement(query)) {
	        statement.setString(1, username);
	        ResultSet resultSet = statement.executeQuery();

	        while (resultSet.next()) {
	            // 가져온 계좌 정보를 Openbank 객체로 변환하여 리스트에 추가
	            Openbank account = new Openbank();
	            account.setOp_acc_num(resultSet.getString("ACCOUNT_NO"));
	            account.setOp_id(resultSet.getString("ID"));
	            account.setOp_bankcode(resultSet.getString("BANK_CODE"));
	            account.setOp_acpw(resultSet.getString("ACCOUNT_PW"));
	            account.setOp_acmadedate(resultSet.getString("ACCOUNT_DATE"));
	            account.setOp_acmadedate2(resultSet.getString("ACCOUNT_DATE2"));
	            account.setOp_balance(resultSet.getString("ACCOUNT_BALANCE"));
	            account.setOp_memberName(resultSet.getString("MEMBER_NAME"));
	            account.setOp_accountName(resultSet.getString("ACCOUNT_NAME"));

	            accounts.add(account);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return accounts;
	}
}
