package kr.ac.kopo.ui;

import kr.ac.kopo.service.BoardService;
import kr.ac.kopo.vo.BoardVO;

public class SearchOneUI  extends BaseUI {
 
	private BoardService service;

	public SearchOneUI() {
		service = new BoardService();
	}
	
	@Override
	public void execute() throws Exception {

		int no = scanInt("조회할 글번호를 입력하세요 : ");
		BoardVO board = service.selectByNo(no);
		
		
		System.out.println("-------------------------");
		if (board != null) {
			System.out.println("  번    호 : " + board.getNo());
			System.out.println("  제    목 : " + board.getTitle());
			System.out.println("  작 성 자 : " + board.getWriter());
			System.out.println("  등 록 일 : " + board.getRegDate());
		} else {
			System.out.println("[" + no + "]번 게시글은 존재하지 않습니다");
		}
		System.out.println("-------------------------");
	}

}
