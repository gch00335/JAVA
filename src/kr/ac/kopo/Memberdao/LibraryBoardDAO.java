package kr.ac.kopo.Memberdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.Membervo.LibraryBoardVO;
import kr.ac.kopo.util.ConnectionFactory;

public class LibraryBoardDAO {
	
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
	
	public List<LibraryBoardVO> selectAllBoard(){ //board 적는거 계속 헷갈리네 ㅠㅠ 잘 기억해두자..꼬이지 않기

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
			        	System.out.println("!!!");
			            int no = rs.getInt("no");
			            String name = rs.getString("name");
			            String birth = rs.getString("birth");
			            String mail = rs.getString("mail");
			            String phone = rs.getString("phone");
			            
			            board = new LibraryBoardVO(no, loginID, loginPW, name, birth, mail, phone);
			        }

			        conn.close();
			    } catch (Exception e) {
			        e.printStackTrace();
			    }
			    return board;
			}

	public LibraryBoardVO[] getUsers() {
		// TODO Auto-generated method stub
		return null;
	}
}
	
	
	
	
	/*
//임시테이블 만들어서 로그인정보 저장하려했는뎁..안되네 
public void einsertBoard(LibraryBoardVO board) {
	//1.7구문 사용
	
	StringBuilder sql = new StringBuilder();
	sql.append("insert into e_member(no, loginID, loginPW, name, birth, mail, phone)"); 
    sql.append("values(seq_e_member_no.nextval , ?, ?, ? ,? ,? ,?)");
	
    try(
    		Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
    	){
    
    	pstmt.setString(1, board.getLoginID());
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
*/










