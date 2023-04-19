package kr.ac.kopo;

import java.util.Scanner;

import kr.ac.kopo.Bookui.BaseUI;
import kr.ac.kopo.Bookui.IboardUI;
import kr.ac.kopo.Memberdao.LibraryBoardDAO;
import kr.ac.kopo.Memberservice.LibraryBoardService;
import kr.ac.kopo.Membervo.LibraryBoardVO;

public class LibraryBookManagerUI extends BaseUI implements IboardUI  { // 관리자모드용
	
	public static String memberId; 
	private LibraryBoardDAO boardDAO;
	private LibraryBoardService boardService;

	public  LibraryBookManagerUI() {
		boardDAO = new  LibraryBoardDAO();
		boardService = LibraryBoardServiceFactory.getInstance();
	}
	
	public void execute() throws Exception {
	    LibraryBoardVO board = new LibraryBoardVO();
		IboardUI ui = null;

		  Scanner sc = new Scanner(System.in);
		  System.out.println("============================================");
		    System.out.println("아이디를 입력하세요: ");
		    String id = sc.next();
		    System.out.println("============================================");
		    System.out.println("비밀번호를 입력하세요: ");
		    String password = sc.next();
		    System.out.println("============================================");

		    LibraryBoardVO memberId = boardDAO.Managerlogin(id, password);

		    if (memberId == null) {
		        System.out.println("로그인 실패: 아이디 또는 비밀번호가 올바르지 않습니다.");
		        return;
		    } else {

		    System.out.println("로그인에 성공하셨습니다.");
		    System.out.println("["+id+"]" + "관리자님 환영합니다.");
	
		    }
			ui = new OverseeUI();
			ui.execute();
		

	}
}



