package kr.ac.kopo.bank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.product.Product;
import kr.ac.kopo.util.ConnectionFactory;

public class BankDAO {
	private Connection conn;
	private ResultSet rs;
	private PreparedStatement stmt;
	
	private static String GET_MEMBER = "select * from user_info";
	
	private static String ID_CHECK = "select user_id from user_info where user_id = ? ";

	private static String MEMBER_GET = "select * from user_info where user_id =? and password=?";

public BankDAO () {
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

public List<Product> getAllAccountProducts() {
    List<Product> accountProducts = new ArrayList<>();
    String sql = "SELECT * FROM account_products";
    try (Connection conn = getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql);
         ResultSet rs = pstmt.executeQuery()) {
        while (rs.next()) {
            int productID = rs.getInt("productID");
            String productName = rs.getString("productName");
            int interestRate = rs.getInt("interestRate");
            int minimumBalance = rs.getInt("minimumBalance");

            Product accountProduct = new Product();
            accountProduct.setProductID(productID);
            accountProduct.setProductName(productName);
            accountProduct.setInterestRate(interestRate);
            accountProduct.setMinimumBalance(minimumBalance);

            accountProducts.add(accountProduct);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return accountProducts;
}

//계좌 정보 디비에 추가
	public void insertaccount(Bank vo) {
		 try {
		        Connection conn = getConnection();
		        PreparedStatement stmt = conn.prepareStatement("INSERT INTO ACCOUNT ( ac_number, user_id, bank_cd, ac_pw, BALANCE, ac_op_date, PRODUCT_ID) VALUES (?, ?, ?, ?, ?, ?, ?)");
		        stmt.setString(1, vo.getAcc_num());
		        stmt.setString(2, vo.getId());
		        stmt.setString(3, vo.getBankcode());
		        stmt.setString(4, vo.getAcpw());
		        stmt.setString(5, vo.getBalance());
		        stmt.setString(6, vo.getAcmadedate());
		        stmt.setString(7, vo.getProductID()); 
		        stmt.executeUpdate();
		    } catch (Exception e) {
		        e.printStackTrace();
		    } finally {
		        ConnectionFactory.close(stmt, conn);
		    }
		}



public boolean createAccount(String accountNumber, String accountHolder, double balance, int productID) {
    String sql = "INSERT INTO accounts (accountNumber, accountHolder, balance) VALUES (?, ?, ?)";
    try (Connection conn = getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setString(1, accountNumber);
        pstmt.setString(2, accountHolder);
        pstmt.setDouble(3, balance);
        int rowsAffected = pstmt.executeUpdate();
        if (rowsAffected > 0) {
            // 계좌 개설 성공
            return true;
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    // 계좌 개설 실패
    return false;
}

public ArrayList<Bank> getAccountList(String userID) {
    ArrayList<Bank> accountList = new ArrayList<>();
    
    try {
        Connection conn = getConnection();
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM ACCOUNT WHERE USER_ID = ?");
        stmt.setString(1, userID);
        ResultSet rs = stmt.executeQuery();
        
        
        
        while (rs.next()) {
        	Bank account = new Bank();
        	 account.setAcc_num(rs.getString("AC_NUMBER"));
             account.setId(rs.getString("USER_ID"));
             account.setBankcode(rs.getString("BANK_CD"));
             account.setAcpw(rs.getString("AC_PW"));
             account.setBalance(rs.getString("BALANCE"));
             account.setAcmadedate(rs.getString("AC_OP_DATE"));
             account.setProductID(rs.getString("PRODUCT_ID"));

            accountList.add(account);
        }
        
        rs.close();
        stmt.close();
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        ConnectionFactory.close(stmt, conn);
    }
    
    return accountList;
}

}

