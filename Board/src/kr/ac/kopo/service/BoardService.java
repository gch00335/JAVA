package kr.ac.kopo.service;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import kr.ac.kopo.BoardSequence;
import kr.ac.kopo.dao.BoardDAO;
import kr.ac.kopo.vo.BoardVO;

public class BoardService {
//ui가 서비스를 호출하면 서비스가 여러개를 호출해서 ui에게 전달하는 시스템

	private BoardDAO boardDao;
	
	public BoardService() {
		boardDao = new BoardDAO();
		
	}
	public void insertBoard(BoardVO board) {
		
	// 게시물 일련번호 저장
		board.setNo(BoardSequence.getBoardNO());
	
	// 현재시간 저장
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		board.setRegDate(sdf.format(new Date()));
		
		boardDao.insertBoard(board);
	}
	// 전게체시글을 따로 뭐하는 활동이 아닌 토스~ 토스~ 전달만 하는 클래스임! 
	public List<BoardVO> selectAll(){
		List<BoardVO> boardList = boardDao.selectAllBoard(); // 날라오는 타입은 list지만 0개..
        return boardList; 
	}
}



// 게시물 번호를 만들건데 ..! 게시물 번호는 static으로 해야함!!
// 그래서 게시물 번호를 따로 추출할 수 있는 클래스를 만들려고 함 
// 그 이름을 BoardSequence