package kr.ac.kopo.dao;

import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.vo.BoardVO;

public class BoardDAO {
// 여러개 저장하기 위해서 LIST가 필요함

	private List<BoardVO> boardList;

	public BoardDAO() {
		boardList = new ArrayList<>();
		
	}
	
	public void insertBoard(BoardVO board) {
		boardList.add(board);
		
	
	}
	public List<BoardVO> selectAllBoard(){ // 앗 이거 Allboard 로 해줘야함..
		return boardList;
	}
}
