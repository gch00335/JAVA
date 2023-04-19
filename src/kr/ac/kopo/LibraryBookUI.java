package kr.ac.kopo;

import java.util.Scanner;

import kr.ac.kopo.Bookui.BaseUI;
import kr.ac.kopo.Bookui.IboardUI;
import kr.ac.kopo.Bookui.RentalUI;

public class LibraryBookUI extends BaseUI implements IboardUI { // 일반회원용
	
	
	
	private int menu() {
		System.out.println("*************** (｡•̀ᴗ-ღ) 찌니 도서관 입장 ***************");
		System.out.println("1. [도서대출] 선택");
		System.out.println("2. [도서반납] 선택");
		System.out.println("3. [마이페이지] 선택");
		System.out.println("4. 이전으로 돌아가기");
		System.out.println("0. ---시스템 종료---");
		System.out.println("============================================");
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
				ui =  new RentalUI() ; // 도서대출
				break;
			case 2:
				//ui = new ReturnUI(); // 도서반납
				break;
			case 3:
				//ui = new RentaListUI(); //마이페이지 - 개인정보 출력 , 도서대여목록조회, 개인정보 수정 
				break;
	
			case 4:
				ui = new LibraryLogin();
				break;
				
			case 0:
				System.exit(0);
				break;
			}
			
			if(ui != null) {
				ui.execute();
			} else {
				System.out.println("잘못입력하셨습니다.");
			}
		}
	}
}


