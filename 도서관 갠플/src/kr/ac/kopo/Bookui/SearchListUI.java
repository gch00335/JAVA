package kr.ac.kopo.Bookui;

import java.util.List;

import kr.ac.kopo.BookService.LibraryBookService;
import kr.ac.kopo.BookService.LibraryBookServiceFactory;
import kr.ac.kopo.BookVO.BookVO;

public class SearchListUI  extends BaseUI implements IboardUI  {
	private LibraryBookService boardService;

	public SearchListUI() {
	    boardService = LibraryBookServiceFactory.getInstance();
	}

	 @Override
	    public void execute() throws Exception {
			List<BookVO> bookList1 = boardService. search(null);
	 }
	 }