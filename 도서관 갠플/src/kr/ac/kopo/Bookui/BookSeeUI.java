package kr.ac.kopo.Bookui;

import java.util.Set;

import kr.ac.kopo.BookService.LibraryBookService;
import kr.ac.kopo.BookService.LibraryBookServiceFactory;
import kr.ac.kopo.BookVO.BookVO;

public class BookSeeUI extends BaseUI implements IboardUI  { // 일반회원한테만 보이는 목록 -- 대출,반납을 하면 도서가 사라졌다 안보였다가 하는 거!
	
	private LibraryBookService boardService;


		public BookSeeUI() {
		boardService = LibraryBookServiceFactory.getInstance();

	}


	public void execute() throws Exception {
		Set<BookVO> bookList = boardService.selectSee();
		IboardUI ui = null;
		System.out.println("========================================================");
		System.out.println("                    [  도서 전체 목록  ]                   ");
		System.out.println("========================================================");
		System.out.println("    번 호   ||    제 목    ||    저 자    ||    출 판 사"    );
		if(bookList == null || bookList.size() == 0) {
			System.out.println("\t [책이 존재하지 않습니다]");

		}else {
			for(BookVO board : bookList) { // 1.5버전의 구문
				System.out.println("\t"+
						board.getNo()+"\t" + 
				         board.getBookname() +"\t"+"\t"+
						board.getWriter()+ "\t"+
				         board.getPublisher());
			
				System.out.println("========================================================");
			
		}
		
		
	}
		ui = new RentalUI();
		ui.execute();
}
}
