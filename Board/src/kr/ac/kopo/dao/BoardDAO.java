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
		
	// 와 망했따..오늘 배운거 진짜 1도 모르겠다...
	
	}
}
