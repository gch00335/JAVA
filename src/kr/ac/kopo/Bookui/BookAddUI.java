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

		 String title = scanStr("등록할 제목을 입력하세요 : ");
		 String writer = scanStr("글쓴이를 입력하세요 : ");
		 String publisher = scanStr("출판사를 입력하세요 : ");
	
		 BookVO board = new BookVO();
		 board.setBookname(title);   // 제목
		 board.setWriter(writer); // 작성자
		 board.setPublisher(publisher);// 출판사

		 boardService.insertBoard(board);
		 
		 System.out.println(" 등록을 완료하였습니다");

	}
}

	