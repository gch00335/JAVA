package kr.ac.kopo.BookDAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.BookVO.BookVO;
import kr.ac.kopo.util.ConnectionFactory;



public class LibraryBookDAO {
	
	public LibraryBookDAO() {// 도서전체 조회 , 도서추가, 도서 삭제, 도서정보수정, 도서검색
	}
	
	public void insertBoard(BookVO book) { // 도서 추가
		//1.7구문 사용
		
		StringBuilder sql = new StringBuilder();
		sql.append("insert into ttt_book(no, Bookname, writer,publisher)"); 
	    sql.append("values(seq_ttt_book_no.nextval, ? ,?, ?)");
		
	    try(
	    		Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
	    	){
	    	
	    
	    	pstmt.setString(1, book.getBookname());
	    	pstmt.setString(2, book.getWriter());
	    	pstmt.setString(3, book.getPublisher());
	    
	    	pstmt.executeUpdate();
	    	
	    }catch(Exception e ) {
	    		e.printStackTrace();	
	    }
	}
	
	public List<BookVO> selectAllBoard(){ // 도서전체조회
		StringBuilder sql = new StringBuilder();
		sql.append("select no, Bookname, writer,publisher "); 
		sql.append("  from ttt_book ");
		sql.append("order by no desc");
	    List<BookVO> bookList = new ArrayList<>();
	    
		try(
	    		Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
	    	){
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) { 
				  int no = rs.getInt("no");
			      String Bookname = rs.getString("Bookname");
			      String writer = rs.getString("writer");
			      String publisher = rs.getString("publisher");
	    
	    	BookVO board = new BookVO(no, Bookname, writer, publisher);


	    	bookList.add(board);
			}
	    }catch(Exception e ) {
	    		e.printStackTrace();	
	    }
		return bookList;
	}


		
		
public BookVO selectBoardByNo(int bookNo) {
	
	BookVO board = null ;
	
	StringBuilder sql = new StringBuilder();
	
	sql.append("select no ,Bookname, writer,publisher");
	sql.append(" from ttt_book");
	sql.append(" where no = ?");
	
	try(
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			
			){
		
		pstmt.setInt(1, bookNo);
		
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			int no = rs.getInt("no");
			String Bookname  = rs.getString("Bookname"); 
		    String writer = rs.getString("writer");
		    String publisher = rs.getString("publisher");
		    		
		    board = new BookVO(no, Bookname, writer,publisher);
		    		
		}

	}catch(Exception e) {
		e.printStackTrace();
	}
	
	return board;
}
}
	
		
		
		
		
		
	/*	
	 * public void insertBoard(BookVO board) {
	 * StringBuilder sql = new StringBuilder();
		sql.append("insert into t_board(no, bookname, writer)"); 
	    sql.append("values(seq_t_board_no.nextval, ? ,?)");
		
	    try(
	    		Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
	    	){
	    
	    	pstmt.setString(1, board.getBookname());
	    	pstmt.setString(2, board.getWriter());
	    
	    	pstmt.executeUpdate();
	    	
	    }catch(Exception e ) {
	    		e.printStackTrace();	
	    }
	}
	public List<BookVO> selectAllBoard(){ 

		List<BookVO> boardList = new ArrayList<>();
		
		
		StringBuilder sql = new StringBuilder();
		sql.append("select no, title, writer ");
		sql.append("  from t_board ");
		sql.append("order by no desc");
		
		
		
	 try (
			 Connection conn = new ConnectionFactory().getConnection();
			 PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			 
			 ){
		 
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) { 
		      int no = rs.getInt("no");
		      String title = rs.getString("title");
		      String writer = rs.getString("writer");

		      BookVO board = new BookVO(no, title, writer);
		    
		      boardList.add(board);
		      
		  
		}
	 }catch (Exception e) {
		 e.printStackTrace();
	 }
	 
	 return boardList;
	}
	
	public BookVO selectBoardByNo(int boardNo) {
		
		BookVO board = null ;
		
		StringBuilder sql = new StringBuilder();
		
		sql.append("select no ,title, writer");
		sql.append(" from t_board");
		sql.append(" where no = ?");
		
		try(
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				
				){
			
			pstmt.setInt(1, boardNo);
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				int no = rs.getInt("no");
				String title  = rs.getString("title"); 
			    String writer = rs.getString("writer");
			   
			    board = new BookVO(no, title, writer);
			    		
			}
	
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return board;
	}
}

*/
