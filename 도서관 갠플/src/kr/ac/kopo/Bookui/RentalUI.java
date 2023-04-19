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
	
	private int menu() {
		
			List<BookVO> boardList = boardService.selectAll();

			System.out.println("============================");
			System.out.println("<<메뉴를 선택하세요ʕ ᵔᴥᵔ ʔ >>");
			System.out.println("1. [도서검색] 선택");
			System.out.println("2. [도서대출] 선택");
			System.out.println("3. [도서 대여 가능한 전체 목록 출력] 선택");
			System.out.println("0. 이전으로 돌아가기");
			System.out.println("============================");
			Scanner sc = new Scanner(System.in);
			int type2 = sc.nextInt();
			sc.nextLine();

			return type2;
	}
	public void execute() throws Exception {
		while(true){
			int type2 = menu();
			IboardUI ui = null;
			switch (type2) {
			case 1:
				System.out.println("검색할 도서명을 입력하세요");
				
				break;
			case 2:
				System.out.println("대출한 도서명을 입력하세요");
				
				break;
			case 3:
				ui = new BookSeeUI() ;
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

