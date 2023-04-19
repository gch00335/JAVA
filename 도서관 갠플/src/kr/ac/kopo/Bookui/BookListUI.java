package kr.ac.kopo.Bookui;

import java.util.List;

import kr.ac.kopo.OverseeUI;
import kr.ac.kopo.BookService.LibraryBookService;
import kr.ac.kopo.BookService.LibraryBookServiceFactory;
import kr.ac.kopo.BookVO.BookVO;


public class BookListUI extends BaseUI implements IboardUI  {

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
		System.out.println("번호  || 책 제목 || 글쓴이 || 출판사");
		if(bookList == null || bookList.size() == 0) {
			System.out.println("\t 책이 존재하지 않습니다");

		}else {
			for(BookVO board : bookList) { // 1.5버전의 구문
				System.out.println(
						board.getNo()+"\t" + 
				         board.getBookname() +"\t"
						+board.getWriter()+ "\t"
				         +board.getPublisher());
					
			}
			
			System.out.println("============================");
			ui = new OverseeUI();
			ui.execute();
		}
		
		
	}
	
}