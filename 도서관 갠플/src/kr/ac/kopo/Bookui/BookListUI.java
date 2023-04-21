package kr.ac.kopo.Bookui;

import java.util.List;

import kr.ac.kopo.BookService.LibraryBookService;
import kr.ac.kopo.BookService.LibraryBookServiceFactory;
import kr.ac.kopo.BookVO.BookVO;


public class BookListUI extends BaseUI implements IboardUI  { // 관리자가 보는 전체출력용

	private LibraryBookService boardService;

	public BookListUI() {
		
		
		boardService = LibraryBookServiceFactory.getInstance();

	}


	public void execute() throws Exception { 
		List<BookVO> bookList = boardService.selectAll();
		IboardUI ui = null;
		System.out.println("========================================================");
		System.out.println("                     도서 전체 목록 조회                    ");
		System.out.println("========================================================");
		System.out.println("    번 호   ||    제 목    ||    저 자    ||    출 판 사"    );
		System.out.println("========================================================");
		if(bookList == null || bookList.size() == 0) {
		System.out.println("                  [책이 존재하지 않습니다]                   ");

		}else {
			for(BookVO board : bookList) { // 1.5버전의 구문
				System.out.println("\t"+
						board.getNo()+"\t" + 
				         board.getBookname() +"\t"+"\t"+
						board.getWriter()+ "\t"+
				         board.getPublisher());
					

		           
		      
		    }
		    System.out.println("========================================================");
		}
	}
}