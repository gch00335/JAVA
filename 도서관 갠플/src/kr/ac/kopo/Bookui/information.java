package kr.ac.kopo.Bookui;

import kr.ac.kopo.Memberdao.LibraryBoardDAO;
import kr.ac.kopo.Memberservice.LibraryBoardService;
import kr.ac.kopo.Memberservice.LibraryBoardServiceFactory;
import kr.ac.kopo.Membervo.LibraryBoardVO;

public class information extends BaseUI implements IboardUI  {

	   private LibraryBoardService boardService;
	    private LibraryBoardVO loggedInUser;

	public information() throws Exception {
		boardService = LibraryBoardServiceFactory.getInstance();
        loggedInUser =  LibraryBoardDAO.getLoggedInUser();  // loggedInUser 객체를 얻어옴
	}

	public void execute() throws Exception {
		
		
		LibraryBoardVO[] users = loggedInUser.getUsers();  // getUsers() 메서드로 배열 사용

		
		    System.out.println("========================================================");
		    System.out.println("                    [회원 정보 조회]                       ");
		    System.out.println("========================================================");
		
	        // 배열에 접근하여 값을 읽기
	        for (LibraryBoardVO user : users) {
	            System.out.println("[아 이 디] : " + user.getLoginID());
	            System.out.println("[비 밀 번 호] : " + user.getLoginPW());
		        System.out.println("[이 름]: " + user.getName());
		        System.out.println("[생 일]: " + user.getBirth());
		        System.out.println("[메 일]: " + user.getMail());
		        System.out.println("[번 호]: " + user.getPhone());
		        System.out.println("========================================================");
	        }
	    }
	
		
	}




/*
// 도서 목록 가져오기
String[] books = boardService.getBooks();

// 도서 목록 출력
System.out.println("도서 목록:");
for (String book : books) {
    System.out.println(book);
}

System.out.println("===========================================");
}
		
		
		
	/*
		LibraryBoardVO List = boardService.selectByNo();

		System.out.println("==== 개인 정보 조회====");
	
			for(LibraryBoardVO board : List) { // 1.5버전의 구문
				System.out.println(board.getNo()+"\t" + board.getLoginID() +"\t"
						+board.getLoginPW()+"\t"+ board.getName()+ 
						board.getBirth() +"\t"+ board.getMail() +"\t"+board.getPhone() +"\t");
				
			}

			System.out.println("============================");

		}
	
}

*/