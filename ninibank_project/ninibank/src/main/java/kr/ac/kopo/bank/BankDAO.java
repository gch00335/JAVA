package kr.ac.kopo.bank;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.sql.Types;
import org.h2.util.JdbcUtils;

import kr.ac.kopo.openbank.Openbank;
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
		            "INSERT INTO ACCOUNT (ACCOUNT_NO, ID, BANK_CODE, ACCOUNT_PW, AC_NAME, ACCOUNT_BALANCE, AC_OP_DATE, AC_ED_DATE, PRODUCT_ID, MEMBER_NAME ,ACCOUNT_NAME) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		        stmt.setString(1, vo.getAcc_num());
		        stmt.setString(2, vo.getId());
		        stmt.setString(3, vo.getBankcode());
		        stmt.setString(4, vo.getAcpw());
		        stmt.setString(5, "NINI_BANK");
		        stmt.setString(6, vo.getBalance());
		        stmt.setString(7, vo.getAcmadedate());// AC_ED_DATE 설정
		        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		        Date acOpDate = dateFormat.parse(vo.getAcmadedate());
		        Calendar cal = Calendar.getInstance();
		        cal.setTime(acOpDate);
		        cal.add(Calendar.YEAR, 1); // 1년 추가
		        Date acEdDate = cal.getTime();
		        stmt.setDate(8, new java.sql.Date(acEdDate.getTime()));

		        stmt.setString(9, vo.getProductID());
		        stmt.setString(10, vo.getMemberName());
		        stmt.setString(11, vo.getAccountName());
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
				account.setAcmadedate2(rs.getString("AC_ED_DATE"));
				account.setProductID(rs.getString("PRODUCT_ID"));
				account.setAccountName(rs.getString("ACCOUNT_NAME"));
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
	    // 계좌이체
	    public int Transaction(TransactionHistory transD, TransactionHistory transW) {
	        int result = 0;
	        StringBuilder sql = new StringBuilder();
	      
	        
	        System.out.println(transD);
	        System.out.println(transW);
	        sql.append("{call P_Transaction(?, ?, ?, ?, ?, ?, ?, ?) }");
	        try {
	           
	            Connection conn = getConnection();
	            
	            CallableStatement cstmt = conn.prepareCall(sql.toString());
	            //출금계좌
	            cstmt.setString(1, transW.getTransactionId());
	            
	            //출금은행 코드
	            cstmt.setString(2, transW.getBankCode());
	            
	            //보내는사람 이름
	            cstmt.setString(3, transD.getSenderName());
	            
	            //입금계좌
	            cstmt.setString(4, transD.getTransactionId());
	            //입금은행 코드
	            cstmt.setString(5, transD.getBankCode());
	            //받는사람 이름
	            cstmt.setString(6, transW.getRecipientName());
	            //거래 금액
	            cstmt.setLong(7, transW.getAmount());
	            cstmt.registerOutParameter(8, Types.INTEGER);
	            cstmt.execute();

	            // 결과값 가져오기
	            result = cstmt.getInt(8);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return result;
	    }
		/*
		 * public boolean transferFunds(String fromAccountNumber, String
		 * toAccountNumber, double amount, String password) { try { // 계좌 비밀번호의 유효성 검사
		 * if (!isPasswordValid(fromAccountNumber, password)) { return false; // 계좌
		 * 비밀번호가 유효하지 않으면 이체 실패 }
		 * 
		 * Connection conn = getConnection(); PreparedStatement stmt = conn.
		 * prepareStatement("UPDATE ACCOUNT SET ACCOUNT_BALANCE = ACCOUNT_BALANCE - ? WHERE ACCOUNT_NO = ?"
		 * ); stmt.setDouble(1, amount); stmt.setString(2, fromAccountNumber); int
		 * rowsAffected = stmt.executeUpdate(); stmt.close();
		 * 
		 * if (rowsAffected > 0) { stmt = conn.
		 * prepareStatement("UPDATE ACCOUNT SET ACCOUNT_BALANCE = ACCOUNT_BALANCE + ? WHERE ACCOUNT_NO = ?"
		 * ); stmt.setDouble(1, amount); stmt.setString(2, toAccountNumber);
		 * rowsAffected = stmt.executeUpdate(); stmt.close();
		 * 
		 * if (rowsAffected > 0) { return true; // 이체 성공 } }
		 * 
		 * conn.close(); } catch (SQLException e) { e.printStackTrace(); }
		 * 
		 * return false; // 이체 실패 }
		 */
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
	    
		/*
		 * // 거래 내역을 저장하는 메서드 
		 * public void insertTransactionHistory(TransactionHistory
		 * history) { String query =
		 * "INSERT INTO TRANSACTION_HISTORY (TRANSACTION_ID, ACCOUNT_NUMBER, TRANSACTION_DATE, TRANSACTION_TYPE, AMOUNT,BANK_CODE, SENDER_NAME, RECIPIENT_NAME) "
		 * + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		 * 
		 * try (Connection conn = getConnection(); PreparedStatement stmt =
		 * conn.prepareStatement(query)) {
		 * 
		 * stmt.setString(1, history.getTransactionId().toString()); stmt.setString(2,
		 * history.getAccountNumber()); stmt.setTimestamp(3, new
		 * java.sql.Timestamp(history.getTransactionDate().getTime())); // Timestamp
		 * 타입으로 변환하여 저장 stmt.setString(4, history.getTransactionType());
		 * stmt.setDouble(5, history.getAmount()); stmt.setString(6,
		 * history.getBankCode()); stmt.setString(7, history.getSenderName());
		 * stmt.setString(8, history.getRecipientName());
		 * 
		 * stmt.executeUpdate(); } catch (SQLException e) { e.printStackTrace(); } }
		 */
	 

	    // 계좌 번호에 해당하는 거래 내역을 조회하는 메서드
	    public List<TransactionHistory> getTransactionHistory(String accountNumber) {
	        List<TransactionHistory> transactionHistoryList = new ArrayList<>();
	        String query = "SELECT * FROM TRANSACTION_HISTORY WHERE TRANSACTION_ID = ?";
	        
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
	                   
	                   history.setAmount(rs.getLong("AMOUNT"));
	                   
	                    if (history.getTransactionType().equals("입금")) {
	                        history.setSenderName(rs.getString("SENDER_NAME"));
	                    } else {
	                        history.setRecipientName(rs.getString("RECIPIENT_NAME"));
	                    }
	                 
	                    
	                    transactionHistoryList.add(history);
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        
	        return transactionHistoryList;
	    }
	    public String getUserName(String userID) {
	        String userName = null;

	        try {
	            PreparedStatement stmt = conn.prepareStatement("SELECT NAME FROM USERS WHERE ID = ?");
	            stmt.setString(1, userID);
	            ResultSet rs = stmt.executeQuery();

	            if (rs.next()) {
	                userName = rs.getString("NAME");
	            }

	            rs.close();
	            stmt.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            ConnectionFactory.close(stmt, conn);
	        }

	        return userName;
	    }
	    
	    public List<Openbank> getRelatedAccounts(String userID, String username) {
		    List<Openbank> accounts = new ArrayList<>();

		    // 타은행 계좌 정보를 가져오는 로직 작성
		    // 예시: @NA 테이블에서 이름으로 계좌 정보를 가져옴
		    String query = "SELECT * FROM ACCOUNT @NA WHERE MEMBER_NAME = ?";

		    System.out.println(username);
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
		            account.setOp_balance(resultSet.getString("ACCOUNT_BALANCE"));
		            account.setOp_memberName(resultSet.getString("MEMBER_NAME"));
		            account.setOp_accountName(resultSet.getString("ACCOUNT_NAME"));

		            accounts.add(account);
		            
		            
		            System.out.println(resultSet.getString("ACCOUNT_DATE"));
		            System.out.println(resultSet.getString("ACCOUNT_BALANCE"));
		            System.out.println(resultSet.getString("MEMBER_NAME"));
		            System.out.println(resultSet.getString("ACCOUNT_NAME"));
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		 // 두 번째 테이블 조회
		    String queryYJ = "SELECT * FROM ACCOUNT @YJ WHERE MEMBER_NAME = ?";
		    try (Connection connection = getConnection();
		         PreparedStatement statement = connection.prepareStatement(queryYJ)) {
		        statement.setString(1, username);
		        ResultSet resultSet = statement.executeQuery();

		        while (resultSet.next()) {
		            // 가져온 계좌 정보를 Openbank 객체로 변환하여 리스트에 추가
		            Openbank account = new Openbank();
		            // 계좌 정보 설정
		            accounts.add(account);
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }

		    return accounts;
		}
	    
	    // 계좌 번호에 해당하는 거래 내역을 조회하는 메서드
	    public List<TransactionHistory> getOpentransactionHistory(String accountNumber) {
	        List<TransactionHistory> transactionHistoryList = new ArrayList<>();
	        String query = "SELECT * FROM TRANSACTION @NA WHERE TRANS_ACCOUNT = ?";
	        
	        try (Connection conn = getConnection();
	             PreparedStatement stmt = conn.prepareStatement(query)) {
	            
	            stmt.setString(1, accountNumber);
	            
	            try (ResultSet rs = stmt.executeQuery()) {
	                while (rs.next()) {
	                    TransactionHistory history = new TransactionHistory();
	                    history.setTransactionId(rs.getString("TRANS_ACCOUNT"));
	                  
	                    history.setTransactionDate(rs.getDate("TRANS_DATE"));
	                    history.setTransactiontime(rs.getTime("TRANS_TIME"));
	                    history.setTransactionType(rs.getString("TRANS_TYPE"));
	                   
	                   history.setAmount(rs.getLong("TRANS_AMOUNT"));
	                   
	                    if (history.getTransactionType().equals("입금")) {
	                        history.setSenderName(rs.getString("TRANS_NAME"));
	                    } else {
	                        history.setRecipientName(rs.getString("TRANS_NAME"));
	                    }
	                 
	                    
	                    transactionHistoryList.add(history);
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        
	        return transactionHistoryList;
	    }
	    
	    // 계좌이체
	    public int Transaction2(TransactionHistory transD, TransactionHistory transW) {
	        int result = 0;
	        StringBuilder sql = new StringBuilder();
	      
	        
	        System.out.println(transD);
	        System.out.println(transW);
	        sql.append("{call P_Transaction(?, ?, ?, ?, ?, ?, ?, ?) }");
	        try {
	           
	            Connection conn = getConnection();
	            
	            CallableStatement cstmt = conn.prepareCall(sql.toString());
	            //출금계좌
	            cstmt.setString(1, transW.getTransactionId());
	            
	            //출금은행 코드
	            cstmt.setString(2, transW.getBankCode());
	            
	            //보내는사람 이름
	            cstmt.setString(3, transD.getSenderName());
	            
	            //입금계좌
	            cstmt.setString(4, transD.getTransactionId());
	            //입금은행 코드
	            cstmt.setString(5, transD.getBankCode());
	            //받는사람 이름
	            cstmt.setString(6, transW.getRecipientName());
	            //거래 금액
	            cstmt.setLong(7, transW.getAmount());
	            cstmt.registerOutParameter(8, Types.INTEGER);
	            cstmt.execute();

	            // 결과값 가져오기
	            result = cstmt.getInt(8);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return result;
	    }
	  
}
