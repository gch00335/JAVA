package kr.ac.kopo;

import java.util.Scanner;

import kr.ac.kopo.Bookui.BaseUI;
import kr.ac.kopo.Bookui.IboardUI;
import kr.ac.kopo.MemberUI.JoinUI;
import kr.ac.kopo.MemberUI.LoginUI;
 

public class LibraryLogin extends BaseUI implements IboardUI {
	
	private int menu() {
		

		System.out.println("********************************************************");
		System.out.println("                       [찌니도서관]                       ");
		System.out.println("                                                         ");
		System.out.println("                             방문을 환영합니다.   ");
		System.out.println("                             도서관 운영시간 <09:00 ~ 23:00> ");
		System.out.println("********************************************************");
		System.out.println("========================================================");
		System.out.println("   /\\_/\\    1. [로그인] : 도서 대출, 도서반납, 도서검색,마이페이지    ");
		System.out.println(" (  o.o  )  2. [회원가입] : 도서관 가입   ");
		System.out.println("   > ♥  <   ");
		System.out.println("                                                         ");
		System.out.println("                                                         ");
		System.out.println("                                                         ");
		System.out.println("            0. ---시스템 종료---");
		
		//System.out.println("3. [회원관리메뉴] 선택"); -> 관리자꺼 new ManagerUI(); // 회원관리
		//System.out.println("4. [도서관리메뉴] 선택"); -> 관리자꺼 new BookManageUI(); // 도서관리메뉴
		
		
		//임시 관리자 가입 모드 (까먹고 관리자테이블 날려버렸을때 로그인할 아이디가 없으니 주석처리 지우고 실행할것//
		//System.out.println("4. [관리자테이블 날려먹었을 때  접속] ");
		

		System.out.println("--------------------------------------------------------");
		System.out.println("                                        관리자모드 접속(3)");
		System.out.println("문의전화  02-1004-1004                                     ");
		System.out.println("팩스     02-7942-1004                                     ");
		System.out.println("========================================================");
		System.out.println("                                                       ");
		System.out.print("원하는 항목을 선택하세요 : ");
		Scanner sc = new Scanner(System.in);
		int type = sc.nextInt();
		sc.nextLine();
		
		return type;
	}
	
	public void execute() throws Exception {
		
		while(true){
			int type = menu();
			IboardUI ui = null;
			switch (type) {
			case 1:
				ui =  new LoginUI();
				 //로그인
				break;
			case 2:
			     ui = new JoinUI(); 
				break;
			case 3:
				ui = new LibraryBookManagerUI(); // 관리자모드입장
				break;
			//case 4:	 //임시 관리자 가입 모드 (까먹고 관리자테이블 날려버렸을때 주석처리 지우고 실행할것//
				//ui = new ManagerJoinUI();
				//break;
			case 0:
				System.out.println("              [시스템이 종료됩니다] 안녕히 가세요               ");
				System.out.println("========================================================");
				System.exit(0);
				
				break;
			}
			if(ui != null) {
				ui.execute();
			} else {
				System.out.println("                    잘못입력하셨습니다.                      ");

				System.out.println("========================================================");
			}
		}
	}
}




