package kr.ac.kopo;

import java.util.Scanner;

import kr.ac.kopo.Bookui.BaseUI;
import kr.ac.kopo.Bookui.BookAddUI;
import kr.ac.kopo.Bookui.BookListUI;
import kr.ac.kopo.Bookui.IboardUI;

public class LibraryBookManagerUI extends BaseUI implements IboardUI  { // 관리자모드용
	
	private int menu() {
		System.out.println("*************** [(｡•ᴗ•｡)♡ 찌니관리자모드] 입장 ***************");
		System.out.println("1. [도서전체조회] 선택"); //BookListUI
		System.out.println("2. [도서추가] 선택"); // BookAddUI
		System.out.println("3. [도서삭제] 선택"); // BookDelectUI
		System.out.println("4. [도서정보수정] 선택"); //BookRevise UI
		System.out.println("5. [도서검색] 선택"); //Booksearch UI
		System.out.println("0. ---시스템 종료---");
		System.out.println("00. 이전으로 돌아가기");
		
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
				ui =  new BookListUI() ; // 도서전체조회
				break;
			case 2:
				ui = new BookAddUI(); // 도서추가
				break;
			case 3:
				//ui = new RentaListUI(); //도서삭제
				break;
	
			case 4:
				//ui = new RentaListUI(); //도서정보수정
				break;
				
			case 5:
				//ui = new RentaListUI(); //도서검색
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


