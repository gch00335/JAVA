package kr.ac.kopo.ui;

import kr.ac.kopo.dao.BoardDAO;
import kr.ac.kopo.vo.BoardVO;

public class  AddUI extends BaseUI {
	
	
	private BoardDAO boardDAO;
	
	public AddUI() {
		boardDAO = new BoardDAO();
	}
	
	@Override
	public void execute() throws Exception {

		 String title = scanStr("등록할 제목을 입력하세요 : ");
		 String writer = scanStr("글쓴이를 입력하세요 : ");
	
		 BoardVO board = new BoardVO();
		 board.setTitle(title);
		 board.setWriter(writer);
		 
		 boardDAO.insertBoard(board);
		 
		 System.out.println("새글 등록을 완료하였습니다");
	}

	
}