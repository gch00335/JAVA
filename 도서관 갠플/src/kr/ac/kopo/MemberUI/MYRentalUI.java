package kr.ac.kopo.MemberUI;

import kr.ac.kopo.Bookui.IboardUI;
import kr.ac.kopo.Memberdao.LibraryBoardDAO;
import kr.ac.kopo.Memberservice.LibraryBoardService;
import kr.ac.kopo.Memberservice.LibraryBoardServiceFactory;
import kr.ac.kopo.Membervo.LibraryBoardVO;

public class MYRentalUI implements IboardUI {
	private LibraryBoardService boardService;
    private LibraryBoardVO loggedInUser;
	
	    
	 public MYRentalUI() {
		 boardService = LibraryBoardServiceFactory.getInstance();
	     LibraryBoardVO loggedInUser = LibraryBoardDAO.getLoggedInUser();  // loggedInUser 객체를 얻
			}

		 @Override
		public void execute() throws Exception {
				 
			 LibraryBoardVO[] users = loggedInUser.getUsers();
				 System.out.println(users);
				 
				// 도서 목록 가져오기
				 String[] books = boardService.getBooks();

			 }
	
}
