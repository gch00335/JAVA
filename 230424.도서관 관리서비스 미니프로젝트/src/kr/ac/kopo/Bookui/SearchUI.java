package kr.ac.kopo.Bookui;

import java.util.List;

import kr.ac.kopo.BookService.LibraryBookService;
import kr.ac.kopo.BookService.LibraryBookServiceFactory;
import kr.ac.kopo.BookVO.BookVO;

public class SearchUI extends BaseUI implements IboardUI  {
	
	
	 private LibraryBookService boardService;

		public SearchUI() {
		    boardService = LibraryBookServiceFactory.getInstance();
		}

		 @Override
		    public void execute() throws Exception {
			
			 List<BookVO> bookList = boardService.search2(null);
			
		 }
}
