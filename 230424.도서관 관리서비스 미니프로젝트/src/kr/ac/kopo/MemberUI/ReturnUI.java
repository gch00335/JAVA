package kr.ac.kopo.MemberUI;

import java.util.List;

import kr.ac.kopo.BookService.LibraryBookService;
import kr.ac.kopo.BookService.LibraryBookServiceFactory;
import kr.ac.kopo.BookVO.BookVO;

public class ReturnUI extends BaseUI implements IboardUI, kr.ac.kopo.Bookui.IboardUI{
	
	private LibraryBookService boardService;

		public ReturnUI() {
		    boardService = LibraryBookServiceFactory.getInstance();
		}

		@Override
		public void execute() throws Exception {
			 List<BookVO> bookList = boardService.returnbook();
			
		}


}
