package kr.ac.kopo.Bookui;

import java.util.List;
import java.util.Set;

import kr.ac.kopo.BookService.LibraryBookService;
import kr.ac.kopo.BookService.LibraryBookServiceFactory;
import kr.ac.kopo.BookVO.BookVO;

public class RentalGoUI extends BaseUI implements IboardUI {
	private LibraryBookService boardService;


	public  RentalGoUI() {
		boardService = LibraryBookServiceFactory.getInstance();

	}


	@Override
	public void execute() throws Exception {
		
		Set<BookVO> bookList1 = boardService.selectSee();
		IboardUI ui = null;
		
		System.out.println("========================================================");
		System.out.println("                     도서 전체 목록 조회                    ");
		System.out.println("========================================================");
		System.out.println(  "번호   ||  책 제목  ||   글쓴이   ||   출판사  ");
		System.out.println("========================================================");
		if(bookList1 == null || bookList1.size() == 0) {
			System.out.println("\t 책이 존재하지 않습니다");

		}else {
			for(BookVO board : bookList1) { // 1.5버전의 구문
				System.out.println(
						board.getNo()+"\t" + 
				         board.getBookname() +"\t"+"\t"+
						board.getWriter()+ "\t"+ 
				         board.getPublisher());
					
			}
		
		List<BookVO> bookList = boardService.Rental(); 
		
		ui = new BooKRentalUI();
		ui.execute();
	}
	}
}
	
