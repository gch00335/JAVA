package kr.ac.kopo.ui;

import java.util.List;

import kr.ac.kopo.BoardServiceFactory;
import kr.ac.kopo.service.BoardService;
import kr.ac.kopo.vo.BoardVO;

public class SearchAllUI extends BaseUI {
	/*
	 *   alt +shift+ s누른 후 S선택 : toString() 오버라이딩 생성자
     *   alt +shift+ s누른 후 v선택 : 오버라이드에 대한 메소드 생성
	 * 
	 */
	
	// 전체게시글 목록을 보여달라할때 리턴값의 타입은 무엇일까?
			// List형이 날라와야 함!
			// 
	

	private BoardService boardService;
	
	public SearchAllUI() {
		boardService = BoardServiceFactory.getInstance();
	}
	
	@Override
	public void execute() throws Exception {
		List<BoardVO> boardList = boardService.selectAll();
		
		System.out.println("============================");
		System.out.println("NO\t 글쓴이\t 등록일\t 제목");
		System.out.println("============================");
		if(boardList == null || boardList.size() == 0) {
			System.out.println("\t 게시글이 존재하지 않습니다");
			
		}else {
			for(BoardVO board : boardList) { // 1.5버전의 구문
				System.out.println(board.getNo()+"\t" + board.getWriter() +"\t"
						            +board.getRegDate()+"\t" + board.getTitle());      
			}
		}
  
		System.out.println("============================");
	
	}
}