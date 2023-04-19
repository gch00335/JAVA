package kr.ac.kopo;

import java.util.Scanner;

import kr.ac.kopo.Bookui.BaseUI;
import kr.ac.kopo.Bookui.IboardUI;
import kr.ac.kopo.MemberUI.JoinUI;
import kr.ac.kopo.MemberUI.LoginUI;
 

public class LibraryLogin extends BaseUI implements IboardUI {
	
	private int menu() {
		System.out.println("*************** (ღ˘⌣˘ღ) 찌니도서관  ***************");
		System.out.println("1. [로그인] 선택");
		//System.out.println("3. [회원관리메뉴] 선택"); -> 관리자꺼 new ManagerUI(); // 회원관리
		//System.out.println("4. [도서관리메뉴] 선택"); -> 관리자꺼 new BookManageUI(); // 도서관리메뉴
		System.out.println("2. [관리자모드 접속] 선택");
		System.out.println("3. [회원가입] 선택");
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
				ui =  new LoginUI();
				//LoginUI();  LibraryBookUI() ; //로그인
				break;
			case 2:
				ui = new LibraryBookManagerUI(); // 관리자모드입장
				break;

			case 3:
			     ui = new JoinUI(); 
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




