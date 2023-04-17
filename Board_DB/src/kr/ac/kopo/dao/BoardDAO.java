package kr.ac.kopo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.util.ConnectionFactory;
import kr.ac.kopo.vo.BoardVO;


public class BoardDAO {

	public BoardDAO() {
	}
	
	public void insertBoard(BoardVO board) {
		//1.7구문 사용
		
		StringBuilder sql = new StringBuilder();
		sql.append("insert into t_board(no, title, writer)"); // sysdate를 입력받기 때문에 굳이 regdate를 적을 필요가없다.
	    sql.append("values(seq_t_board_no.nextval, ? ,?)");
		
	    try(
	    		Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
	    	){
	    	pstmt.setString(1,board.getTitle());
	    	pstmt.setString(2, board.getWriter());
	    
	    	pstmt.executeUpdate();
	    	
	    }catch(Exception e ) {
	    		e.printStackTrace();	
	    }
	}
	public List<BoardVO> selectAllBoard(){ //board 적는거 계속 헷갈리네 ㅠㅠ 잘 기억해두자..꼬이지 않기

		List<BoardVO> boardList = new ArrayList<>();
		
		
		StringBuilder sql = new StringBuilder();
		sql.append("select no, title, writer ");
		sql.append("     , to_char(reg_date, 'yyyy-mm-dd') reg_date ");
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
		      String regDate = rs.getString("reg_date");

		     // BoardVO board = new BoardVO(no, title, writer, regDate);
		     //이게 싫으면 다른 방법으로 적는 것도 가능
		    
		      BoardVO board = new BoardVO();
				board.setNo(no);
				board.setTitle(title);
				board.setWriter(writer);
				board.setRegDate(regDate);
				
		        boardList.add(board);
		      
		     // System.out.println(board);
		}
	 }catch (Exception e) {
		 e.printStackTrace();
	 }
	 
	 return boardList;
	}
	
	public BoardVO selectBoardByNo(int boardNo) {
		
		BoardVO board = null ;
		
		StringBuilder sql = new StringBuilder();
		
		sql.append("select no ,title, writer");
		sql.append("    , to_char(reg_date, 'yyyy-mm-dd') as reg_date");
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
			    String regDate = rs.getString("reg_date");
			    		
			    board = new BoardVO(no, title, writer, regDate);
			    		
			}
	
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return board;
	}
}
