package kr.ac.kopo.Bookui;

import kr.ac.kopo.BookService.LibraryBookService;
import kr.ac.kopo.BookService.LibraryBookServiceFactory;
import kr.ac.kopo.BookVO.BookVO;

public class BookAddUI extends BaseUI implements IboardUI  {
	
	private LibraryBookService boardService;

	public BookAddUI() {

		boardService = LibraryBookServiceFactory.getInstance();

	}

	@Override
	public void execute() throws Exception {
		
		 System.out.println("========================================================");
		 String title = scanStr("[제 목]을 입력하세요 : ");
		 String writer = scanStr("[저 자]를 입력하세요 : ");
		 String publisher = scanStr("[출 판 사]를 입력하세요 : ");
		 System.out.println("========================================================");
		 BookVO board = new BookVO();
		 board.setBookname(title);   // 제목
		 board.setWriter(writer); // 작성자
		 board.setPublisher(publisher);// 출판사

		 boardService.insertBoard(board);
		 System.out.println("========================================================");
		 System.out.println("                 [등록을 완료하였습니다]                     ");
		 System.out.println("========================================================");
	}
}

	