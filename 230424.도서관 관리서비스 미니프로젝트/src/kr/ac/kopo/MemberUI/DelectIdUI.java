package kr.ac.kopo.MemberUI;

import kr.ac.kopo.Bookui.BaseUI;
import kr.ac.kopo.Bookui.IboardUI;
import kr.ac.kopo.Memberservice.LibraryBoardService;
import kr.ac.kopo.Memberservice.LibraryBoardServiceFactory;
import kr.ac.kopo.Membervo.LibraryBoardVO;

public class DelectIdUI extends BaseUI implements IboardUI { 
	private LibraryBoardService boardService;
	
	public  DelectIdUI() {
	    boardService =  LibraryBoardServiceFactory.getInstance();
	}

	@Override
	public void execute() throws Exception {
		LibraryBoardVO bookList1 = boardService.DelectIdUI(null);
		
	}

	
	

}
