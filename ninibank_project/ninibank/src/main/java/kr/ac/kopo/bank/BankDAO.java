package kr.ac.kopo.bank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.product.Product;
import kr.ac.kopo.transactionHistory.TransactionHistory;
import kr.ac.kopo.util.ConnectionFactory;

public class BankDAO {
	private Connection conn;
	private ResultSet rs;
	private PreparedStatement stmt;

	private static String GET_MEMBER = "select * from user_info";

	private static String ID_CHECK = "select user_id from user_info where user_id = ? ";

	private static String MEMBER_GET = "select * from user_info where user_id =? and password=?";

	public BankDAO() {
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
	        PreparedStatement stmt = conn.prepareStatement(
	                "INSERT INTO ACCOUNT (ACCOUNT_NO, ID, BANK_CODE, ACCOUNT_PW, AC_NAME, ACCOUNT_BALANCE, AC_OP_DATE, PRODUCT_ID) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
	        stmt.setString(1, vo.getAcc_num());
	        stmt.setString(2, vo.getId());
	        stmt.setString(3, vo.getBankcode());
	        stmt.setString(4, vo.getAcpw());
	        stmt.setString(5, "NINI_BANK"); // AC_NAME에 "NINI_BANK" 값을 설정합니다.
	        stmt.setString(6, vo.getBalance());
	        stmt.setString(7, vo.getAcmadedate());
	        stmt.setString(8, vo.getProductID());
	        stmt.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        ConnectionFactory.close(stmt, conn);
	    }
	}

	public boolean createAccount(String accountNumber, String accountHolder, double balance, int productID) {
		String sql = "INSERT INTO accounts (accountNumber, accountHolder, ACCOUNT_BALANCE) VALUES (?, ?, ?)";
		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
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
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM ACCOUNT WHERE ID = ?");
			stmt.setString(1, userID);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Bank account = new Bank();
				account.setAcc_num(rs.getString("ACCOUNT_NO"));
				account.setId(rs.getString("ID"));
				account.setAcName(rs.getString("AC_NAME"));
				account.setBankcode(rs.getString("BANK_CODE"));
				account.setAcpw(rs.getString("ACCOUNT_PW"));
				account.setBalance(rs.getString("ACCOUNT_BALANCE"));
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
//계좌 해지 메소드
	 public void deleteAccount(String accountNumber) {
	        PreparedStatement stmt = null;

	        try {
	            stmt = conn.prepareStatement("DELETE FROM ACCOUNT WHERE ACCOUNT_NO = ?");
	            stmt.setString(1, accountNumber);
	            stmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            // 자원 해제
	            close(stmt);
	        }
	    }

	    private void close(PreparedStatement stmt) {
	        if (stmt != null) {
	            try {
	                stmt.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	    
	    public boolean transferFunds(String fromAccountNumber, String toAccountNumber, double amount, String password) {
	        try {
	            // 계좌 비밀번호의 유효성 검사
	            if (!isPasswordValid(fromAccountNumber, password)) {
	                return false; // 계좌 비밀번호가 유효하지 않으면 이체 실패
	            }

	            Connection conn = getConnection();
	            PreparedStatement stmt = conn.prepareStatement("UPDATE ACCOUNT SET ACCOUNT_BALANCE = ACCOUNT_BALANCE - ? WHERE ACCOUNT_NO = ?");
	            stmt.setDouble(1, amount);
	            stmt.setString(2, fromAccountNumber);
	            int rowsAffected = stmt.executeUpdate();
	            stmt.close();

	            if (rowsAffected > 0) {
	                stmt = conn.prepareStatement("UPDATE ACCOUNT SET ACCOUNT_BALANCE = ACCOUNT_BALANCE + ? WHERE ACCOUNT_NO = ?");
	                stmt.setDouble(1, amount);
	                stmt.setString(2, toAccountNumber);
	                rowsAffected = stmt.executeUpdate();
	                stmt.close();

	                if (rowsAffected > 0) {
	                    return true; // 이체 성공
	                }
	            }

	            conn.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return false; // 이체 실패
	    }
	    
	    private boolean isPasswordValid(String accountNumber, String password) {
	        try {
	            Connection conn = getConnection();
	            PreparedStatement stmt = conn.prepareStatement("SELECT ACCOUNT_NO FROM ACCOUNT WHERE ACCOUNT_NO = ? AND ACCOUNT_PW = ?");
	            stmt.setString(1, accountNumber);
	            stmt.setString(2, password);
	            ResultSet rs = stmt.executeQuery();

	            boolean isValid = rs.next(); // 결과가 존재하면 비밀번호가 일치함을 의미함

	            rs.close();
	            stmt.close();
	            conn.close();

	            return isValid;
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return false; // 유효성 검사 실패
	    }
	    
	    // 거래 내역을 저장하는 메서드
	    public void insertTransactionHistory(TransactionHistory history) {
	        String query = "INSERT INTO TRANSACTION_HISTORY (TRANSACTION_ID, ACCOUNT_NUMBER, TRANSACTION_DATE, TRANSACTION_TYPE, AMOUNT) " +
	                       "VALUES (?, ?, ?, ?, ?)";

	        try (Connection conn = getConnection();
	             PreparedStatement stmt = conn.prepareStatement(query)) {

	        	stmt.setString(1, history.getTransactionId().toString());
	            stmt.setString(2, history.getAccountNumber());
	            stmt.setTimestamp(3, new java.sql.Timestamp(history.getTransactionDate().getTime())); // Timestamp 타입으로 변환하여 저장
	            stmt.setString(4, history.getTransactionType());
	            stmt.setDouble(5, history.getAmount());

	            stmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	 

	    // 계좌 번호에 해당하는 거래 내역을 조회하는 메서드
	    public List<TransactionHistory> getTransactionHistory(String accountNumber) {
	        List<TransactionHistory> transactionHistoryList = new ArrayList<>();
	        String query = "SELECT * FROM TRANSACTION_HISTORY WHERE ACCOUNT_NUMBER = ?";
	        
	        try (Connection conn = getConnection();
	             PreparedStatement stmt = conn.prepareStatement(query)) {
	            
	            stmt.setString(1, accountNumber);
	            
	            try (ResultSet rs = stmt.executeQuery()) {
	                while (rs.next()) {
	                    TransactionHistory history = new TransactionHistory();
	                    history.setTransactionId(rs.getString("TRANSACTION_ID"));
	                    history.setAccountNumber(rs.getString("ACCOUNT_NUMBER"));
	                    history.setTransactionDate(rs.getDate("TRANSACTION_DATE"));
	                    history.setTransactionType(rs.getString("TRANSACTION_TYPE"));
	                    history.setAmount(rs.getDouble("AMOUNT"));
	                    
	                    transactionHistoryList.add(history);
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        
	        return transactionHistoryList;
	    }
	}

