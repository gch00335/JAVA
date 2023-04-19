package kr.ac.kopo.Bookui;

import java.util.Arrays;

import kr.ac.kopo.MemberUI.LoginUI;
import kr.ac.kopo.Memberservice.LibraryBoardService;
import kr.ac.kopo.Memberservice.LibraryBoardServiceFactory;
import kr.ac.kopo.Membervo.LibraryBoardVO;

public class information extends BaseUI implements IboardUI  {

	   private LibraryBoardService boardService;
	    private LibraryBoardVO loggedInUser;

	public information() throws Exception {
		boardService = LibraryBoardServiceFactory.getInstance();
        LoginUI loginUI = new LoginUI();
        loggedInUser = loginUI.getLoggedInUser();  // loggedInUser 객체를 얻어옴
	}

	public void execute() throws Exception {
		
		
		LibraryBoardVO[] users = loggedInUser.getUsers();  // getUsers() 메서드로 배열 사용

	        // 배열에 접근하여 값을 읽기
	        for (LibraryBoardVO user : users) {
	            System.out.println(user.getLoginID());
	        }

	        // 배열에 접근하여 값을 쓰기
	        System.out.println(Arrays.toString(users)); 
	     
		   
		    
		    System.out.println("===========================================");
		    System.out.println("회원 정보");
		    System.out.println("===========================================");
		
		    
	       /* System.out.println("비밀번호: " + member.getLoginPW());
	        System.out.println("이름: " + member.getName());
	        System.out.println("이메일: " + member.getMail());
	        System.out.println("생일: " + member.getBirth());
	        System.out.println("전화번호: " + member.getPhone());
	        System.out.println("===========================================");
	    */
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