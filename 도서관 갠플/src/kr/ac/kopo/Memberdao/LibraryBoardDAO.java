package kr.ac.kopo.Memberdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.Membervo.LibraryBoardVO;
import kr.ac.kopo.util.ConnectionFactory;

public class LibraryBoardDAO {
	
	private static LibraryBoardVO loggedInUser; // 로그인한 사용자 정보를 저장할 필드
	
	public LibraryBoardDAO() {
	}
	
	public void insertBoard(LibraryBoardVO board) {
		//1.7구문 사용
		
		StringBuilder sql = new StringBuilder();
		sql.append("insert into  t_member(no, loginID, loginPW, name, birth, mail, phone) "); 
	    sql.append("values(seq_t_member_no.nextval , ?, ?, ? ,? ,? ,?) ");
		
	    try(
	    		Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
	    	){
	    
	    	pstmt.setString(1,board.getLoginID());
	    	pstmt.setString(2, board.getLoginPW());
	    	pstmt.setString(3, board.getName());
	    	pstmt.setString(4, board.getBirth());
	    	pstmt.setString(5, board.getMail());
	    	pstmt.setString(6, board.getPhone());
	    	
	    	
	    
	    	pstmt.executeUpdate();
	    	
	    }catch(Exception e ) {
	    		e.printStackTrace();	
	    }
	}
	
	public void insertManager(LibraryBoardVO user) { //관리자모드 정보 넣기
		//1.7구문 사용
		
		StringBuilder sql = new StringBuilder();
		sql.append("insert into  e_member(loginID, loginPW) "); 
	    sql.append("values(?, ?) ");
		
	    try(
	    		Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
	    	){
	    
	    	pstmt.setString(1, user.getLoginID());
	    	pstmt.setString(2, user.getLoginPW());
	    	
	    	
	    	
	    
	    	pstmt.executeUpdate();
	    	
	    }catch(Exception e ) {
	    		e.printStackTrace();	
	    }
	}
	
	public List<LibraryBoardVO> selectAllBoard(){ 

		List<LibraryBoardVO> boardList = new ArrayList<>();
		
		
		StringBuilder sql = new StringBuilder();
		sql.append("select no, loginID, loginPW, name, birth, mail, phone ");
		sql.append("  from  t_member ");
		sql.append("order by no desc");
		
		
		
	 try (
			 Connection conn = new ConnectionFactory().getConnection();
			 PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			 
			 ){
		 
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) { 
		      int no = rs.getInt("no");
		      String loginID = rs.getString("loginID");
		      String loginPW = rs.getString("loginPW");
		      String name = rs.getString("name");
		      String birth = rs.getString("birth");
		      String mail = rs.getString("mail");
		      String phone = rs.getString("phone");
		      
		      
		      LibraryBoardVO  board = new LibraryBoardVO (no, loginID, loginPW, name, birth, mail, phone);
		     
				
		        boardList.add(board);
		      
		    
		}
	 }catch (Exception e) {
		 e.printStackTrace();
	 }
	 
	 return boardList;
	}
	
	public LibraryBoardVO selectBoardByNo(String boardID ) {
		
		LibraryBoardVO board = null ;
		
		StringBuilder sql = new StringBuilder();
		
		sql.append("select no, loginID, loginPW,");
		sql.append(" from  t_member");
		sql.append(" where loginID = ?");
		
		try(
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				
				){
			
			pstmt.setString(1, boardID);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				int no = rs.getInt("no");
				String loginID  = rs.getString("loginID"); 
			    String loginPW = rs.getString("");
			    String name = rs.getString("name");
			    String birth = rs.getString("birth");
			      String mail = rs.getString("mail");
			      String phone = rs.getString("phone");		
			    
			    
			    
			    board = new LibraryBoardVO(no, loginID, loginPW, name, birth, mail, phone);
			    		
			}
	
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return board;
	}
	///////// 로그인 및 로그인 기록 계속 나오게 하기 /////////////
	public LibraryBoardVO login(String loginID, String loginPW) {
			    LibraryBoardVO board = null;
			    
			    StringBuilder sql = new StringBuilder();
			    sql.append("SELECT no, loginID, loginPW, name, birth, mail, phone ");
			    sql.append("FROM t_member ");
			  // sql.append("WHERE loginID = \'" + loginID + "\' AND loginPW = \'"+ loginPW + "\'");
		       sql.append("WHERE loginID = ? AND loginPW = ?");

			    try (
			    		Connection conn = new ConnectionFactory().getConnection();
						PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			    		) {

				        pstmt.setString(1, loginID);
				        pstmt.setString(2, loginPW);
			        
			    	
				        ResultSet rs = pstmt.executeQuery();
			        
			        if (rs.next()) {
			        	// System.out.println("!!!");  // if 절이 도는지 확인해보기
			            int no = rs.getInt("no");
			            String name = rs.getString("name");
			            String birth = rs.getString("birth");
			            String mail = rs.getString("mail");
			            String phone = rs.getString("phone");
			            
			            board = new LibraryBoardVO(no, loginID, loginPW, name, birth, mail, phone);
			            
			            loggedInUser = new LibraryBoardVO();  // loggedInUser 객체 생성
				         LibraryBoardVO[] users = new LibraryBoardVO[1];
				         users[0] = board;
				         
				         loggedInUser.setUsers(users);// setUsers() 메서드 호출하여 배열 저장
				         
				         //System.out.println(board.getLoginID());     // 보드에 저장됬는지 확인하기
				         //System.out.println(Arrays.toString(users)); // uesr에 잘 저장됬는지 확인
				         //System.out.println(loggedInUser.getUsers()); // 저장된 정보가 어떻게 불러오는지 확인하기
			        }

			        conn.close();
			    } catch (Exception e) {
			        e.printStackTrace();
			    }
			    return board;
			}
	// 다른클래스에서 배열 불러올때의 리턴 값
		public static LibraryBoardVO getLoggedInUser() {
		    if (loggedInUser != null) {
		        return loggedInUser;
		    } else {
		        return null;
		}
		    
	}
		
	public LibraryBoardVO[] getUsers() {
		return null;
	}
	///관리자 로그인 확인
	public LibraryBoardVO Managerlogin(String loginID, String loginPW) {
	    LibraryBoardVO Manager = null;
	    
	    StringBuilder sql = new StringBuilder();
	    sql.append("SELECT  loginID, loginPW ");
	    sql.append("FROM e_member ");
        sql.append("WHERE loginID = ? AND loginPW = ?");

	    try (
	    		Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
	    		) {

		        pstmt.setString(1, loginID);
		        pstmt.setString(2, loginPW);
	        
	    	
		        ResultSet rs = pstmt.executeQuery();
	        
	        if (rs.next()) {
	        	
		            
	        	Manager = new LibraryBoardVO(0, loginID, loginPW, loginPW, loginPW, loginPW, loginPW);
		            
		            loggedInUser = new LibraryBoardVO();  // loggedInUser 객체 생성
			         LibraryBoardVO[] users = new LibraryBoardVO[1];
			         users[0] = Manager;
			         
			         loggedInUser.setUsers(users);
	        }

	        conn.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return  Manager;
	}
	// 다른클래스에서 배열 불러올때의 리턴 값
	public static LibraryBoardVO Manager1() {
	    if (loggedInUser != null) {
	        return loggedInUser;
	    } else {
	        return null;
	}
	    
}
	
public LibraryBoardVO[] Manager() {
	return null;
}
	
	
///////// 여기서부터 개인정보 수정 //////////////////////////////	

	public void UpdateLoginPW(LibraryBoardVO user) {
	    String sql = "UPDATE t_member SET loginPW = ? ";
	    try (
	        Connection conn = new ConnectionFactory().getConnection();
	        PreparedStatement pstmt = conn.prepareStatement(sql);
	    ) {
	    	
	    
	    	pstmt.setString(1, user.getLoginPW());
	    	
	       
	        pstmt.executeUpdate();
	       
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	public void UpdateUserName(LibraryBoardVO user)  {



		String sql = "UPDATE t_member SET name = ?";

		try(
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				){

			pstmt.setString(1, user.getName());
	    	
		       
	        pstmt.executeUpdate();

		}catch(Exception e ) {
			e.printStackTrace();	
		}
	}
	

	public void UpdateUserMail(LibraryBoardVO user) {
	    String sql = "UPDATE t_member SET mail = ? ";
	    try (
	        Connection conn = new ConnectionFactory().getConnection();
	        PreparedStatement pstmt = conn.prepareStatement(sql);
	    ) {
	    	
	    
	    	pstmt.setString(1, user.getMail());
	    	
	        pstmt.executeUpdate();
	       
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	public void UpdateUserPhone(LibraryBoardVO user)  {



		String sql = "UPDATE t_member SET phone = ?";

		try(
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				){

			pstmt.setString(1, user.getPhone());
	    	
		       
	        pstmt.executeUpdate();

		}catch(Exception e ) {
			e.printStackTrace();	
		}
	}
	
}











