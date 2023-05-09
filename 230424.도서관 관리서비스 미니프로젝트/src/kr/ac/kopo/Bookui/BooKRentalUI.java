package kr.ac.kopo.Bookui;

import java.util.Scanner;

import kr.ac.kopo.BookService.LibraryBookService;
import kr.ac.kopo.BookService.LibraryBookServiceFactory;

public class BooKRentalUI extends BaseUI implements IboardUI {

	 private LibraryBookService boardService;

		public BooKRentalUI() {
		    boardService = LibraryBookServiceFactory.getInstance();
		}

	

		@Override
		public void execute() throws Exception {
			while(true){
				 System.out.println("========================================================");
				 System.out.println("1. [대출하시려면 1번을 누른 후 도서코드를 입력해주세요]");
				 System.out.println("2. [이전으로 돌아가기] 선택");
				 System.out.println("0. ---시스템 종료---");
				 System.out.println("========================================================");
					Scanner sc = new Scanner(System.in);
					int type = sc.nextInt();
					sc.nextLine();
					
			
				IboardUI ui = null;
				
				switch (type) {
				case 1:
					// 대출하면 목록에서 빠지고, 
					ui = new RentalGoUI();
					  
					 break;
					
				case 2:
					ui = new RentalUI ();
					 break;
				case 0:
					System.out.println("                 로그아웃됩니다. 안녕히가세요                 ");
					System.out.println("========================================================");
					System.exit(0);

				
					break;

				}
				if(ui != null) {
					ui.execute();
				} else {
					System.out.println("========================================================");
					System.out.println("잘못입력하셨습니다.");
					System.out.println("========================================================");
				}
			}
		}
}
