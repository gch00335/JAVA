package kr.ac.kopo.ui;

import java.util.Scanner;

public class BoardUI extends BaseUI {
//BoardUI외에도 다른  키보드 입력도  IboardUI도 받아야하는데  각각 상속받게 하는 것보다
// 이렇게 적는것 말고 제일 최고봉이 받게 한다음 밑에 애들이 자동으로 받게 하면 되지 않을까!
	
	private int menu() {
		System.out.println("*** 게시판 관리 프로그램 ***");
		System.out.println("1. 전체게시글 조회");
		System.out.println("2. 글번호 조회");
		System.out.println("3. 글등록");
		System.out.println("4. 글수정");
		System.out.println("5. 글삭제");
		System.out.println("0. 종료");
		System.out.print("원하는 항목을 선택하세요 : ");
		Scanner sc = new Scanner(System.in);
		int type = sc.nextInt();
		sc.nextLine();
		
		return type;
	}
	
	@Override
	public void execute() throws Exception {
		
		while(true){
			int type = menu();
			IBoardUI ui = null;
			switch (type) {
			case 1:
				ui = new SearchAllUI();
				// 글 등록 , 수정, 삭제 등이 잘 되었는지 확인을 해야하기때문에 전체게시글 조회 ui 필요
				break;
			case 2:
				ui = new SearchOneUI();
				break;
			case 3:
				ui = new AddUI();
				System.out.println("글등록 선택");
				break;
			case 4:
				System.out.println("글수정 선택");
				break;
			case 5:
				System.out.println("글삭제 선택");
				break;
			case 0:
				ui = new ExitUI();
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
