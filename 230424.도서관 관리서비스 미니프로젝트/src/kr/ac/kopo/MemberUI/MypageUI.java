package kr.ac.kopo.MemberUI;

import java.util.Scanner;

import kr.ac.kopo.Bookui.IboardUI;
import kr.ac.kopo.Bookui.information;

public class MypageUI extends LoginUI {
	
	private int menu() {
		System.out.println("*******************************************************");
		System.out.println("                                                         ");
		System.out.println("                      [MY PAGE] 입장                    ");
		System.out.println("                                                       ");
		System.out.println("*******************************************************");
		System.out.println("1. [개인정보 출력] ");
		System.out.println("2. [개인정보 수정] ");
		System.out.println("3. [회원 탈퇴] ");
		System.out.println("                                                         ");
		System.out.println("                                                         ");
		System.out.println("0. ---시스템 종료---");
		System.out.println("========================================================");
		System.out.println("원하는 항목을 선택하세요 : ");
		System.out.println("========================================================");
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
				ui =  new information() ; // 개인정보 출력
				break;
	
			case 2:
				ui = new UpdateUI(); //개인정보 수정 
				break;
			case 3:
				ui = new DelectIdUI(); //개인정보 수정 
				break;
	
				
			case 0:
				System.out.println("                        안녕히가세요                       ");
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



