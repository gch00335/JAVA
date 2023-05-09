package kr.ac.kopo.service;


import java.util.List;

import kr.ac.kopo.dao.BoardDAO;
import kr.ac.kopo.vo.BoardVO;

public class BoardService {
//ui가 서비스를 호출하면 서비스가 여러개를 호출해서 ui에게 전달하는 시스템

	private BoardDAO boardDao;
	
	public BoardService() {
		boardDao = new BoardDAO();
		
	}
	public void insertBoard(BoardVO board) {
		
	
		
		boardDao.insertBoard(board);
	}
	
	public List<BoardVO> selectAll(){
		List<BoardVO> boardList = boardDao.selectAllBoard(); 
        return boardList; 
	}
	public BoardVO selectByNo(int boardNo) {
		
		BoardVO board = boardDao.selectBoardByNo(boardNo);
		return board;
	}
}



