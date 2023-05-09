package kr.ac.kopo.Bookui;

import java.util.List;
import java.util.Scanner;

import kr.ac.kopo.BookService.LibraryBookService;
import kr.ac.kopo.BookService.LibraryBookServiceFactory;
import kr.ac.kopo.BookVO.BookVO;

public class RentalUI  extends BaseUI implements IboardUI{

	private LibraryBookService boardService;
	
	
	public RentalUI() {
		
		boardService = LibraryBookServiceFactory.getInstance();
	}
	
	
	public void execute() throws Exception {
		List<BookVO> boardList = boardService.selectAll();

	
		while(true){
			System.out.println("========================================================");
			System.out.println("                   <<메뉴를 선택하세요 >>                   ");
			System.out.println("1. [도서 검색] ");
			System.out.println("2. [도서 대출하기] ");
			System.out.println("3. [도서 대여 가능한 전체 목록 출력] ");
			System.out.println("0. ---시스템 종료---");
			System.out.println("========================================================");
			System.out.print("원하는 항목을 선택하세요 : ");
			Scanner sc = new Scanner(System.in);
			int type2 = sc.nextInt();
			sc.nextLine();
			IboardUI ui = null;
			
			switch (type2) {
			case 1:
				ui = new SearchUI();
				break;
			case 2:
				ui = new BooKRentalUI();
				break;
			case 3:
				ui = new BookSeeUI() ; // BookListUI - 관리자가 보는 전체출력용
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
				System.out.println("                  잘못입력하셨습니다.                        ");
				System.out.println("========================================================");
				
			}
		}
	}
}

