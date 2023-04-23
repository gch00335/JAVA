package kr.ac.kopo;

import java.util.Scanner;

import kr.ac.kopo.Bookui.BaseUI;
import kr.ac.kopo.Bookui.BookAddUI;
import kr.ac.kopo.Bookui.BookListUI;
import kr.ac.kopo.Bookui.DelectBookUI;
import kr.ac.kopo.Bookui.IboardUI;
import kr.ac.kopo.Bookui.SearchListUI;
import kr.ac.kopo.Bookui.selectMemberRentalUI;
import kr.ac.kopo.MemberUI.ManagerJoinUI;


public class OverseeUI extends BaseUI implements IboardUI  { 
	public  OverseeUI() {
		
	}
	public void execute() throws Exception {
		IboardUI ui = null;
	
		
		
		while(true){
			System.out.println("********************************************************");
			System.out.println("                                                         ");
			System.out.println("                       [관리자모드]                       ");
			System.out.println("                                                         ");
			System.out.println("********************************************************");
			System.out.println("1. [도서전체 조회] "); //BookListUI
			System.out.println("2. [도서 추가] "); // BookAddUI
			System.out.println("3. [도서 삭제] "); // BookDelectUI
			System.out.println("4. [도서 검색] "); //Booksearch UI
			System.out.println("5. [회원 대출 목록] ");
			System.out.println("6. [회원 목록] "); 
			System.out.println("7. [관리자 계정 추가] " );
			System.out.println("                                                         ");
			System.out.println("                                                         ");
			System.out.println("8. 이전으로 돌아가기");
			System.out.println("0. ---시스템 종료---");
			
			System.out.println("========================================================");
			System.out.print("원하는 항목을 선택하세요 : ");
			Scanner sc1 = new Scanner(System.in);
		
			int type = sc1.nextInt();
			
			switch (type) {
			case 1:
				ui =  new BookListUI() ; // 도서전체조회
				break;
			case 2:
				ui = new BookAddUI(); // 도서추가
				break;
			case 3:
				ui = new DelectBookUI(); //도서삭제
				break;
	
			case 4:
				ui = new SearchListUI(); //도서검색
				break;
				
			case 5:
				ui = new selectMemberRentalUI(); //도서검색
				break;
			
			
	
			case 6:
				ui = new SearchMemberUI(); //회원목록조회
				break;
				
			case 7:
				ui = new ManagerJoinUI();
				break;
			
			case 8:
				ui = new LibraryLogin();
				break;
			case 0:
				System.out.println("                   관리자님 로그아웃됩니다                   ");
				System.out.println("                     안녕히 가세요                         ");
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

