package kr.ac.kopo.Bookui;

import java.util.HashSet;
import java.util.Set;

import kr.ac.kopo.BookService.LibraryBookService;
import kr.ac.kopo.BookService.LibraryBookServiceFactory;
import kr.ac.kopo.BookVO.RentalBookVO;
import kr.ac.kopo.Membervo.LibraryBoardVO;

public class selectMemberRentalUI extends BaseUI implements IboardUI {
	
	public static String memberId; 
	private RentalBookVO boardDAO;
	private LibraryBoardVO loggedInUser; // 로그인한 사용자 정보를 저장할 필드
	private LibraryBookService boardService;

	public selectMemberRentalUI() {
		boardDAO = new  RentalBookVO();
		boardService = LibraryBookServiceFactory.getInstance();
	}
	
	public void execute() throws Exception {
		 Set<RentalBookVO> bookList = boardService.selectMemberRental();

		    if (bookList == null) {
		        bookList = new HashSet<RentalBookVO>(); // 빈 Set으로 초기화
		    }

		    if (bookList.isEmpty()) { // 대출중인 도서가 없는 경우
		        System.out.println("========================================================");
		        System.out.println("                   대출중인 도서가 없습니다");
		        System.out.println("========================================================");
		    } else { // 대출중인 도서가 있는 경우
		        System.out.println("========================================================");
		        System.out.println("                    대출중인 목록 조회                    ");
		        System.out.println("========================================================");
		        for (RentalBookVO member : bookList) {
		            System.out.println("대출자 : " + "[" + member.getLoginID() + "]");
		            System.out.println("코드 : " + "[" + member.getNo() + "]");
		            System.out.println("제목 : " + "[" + member.getBookname() + "]");
		            System.out.println("저자 : " + "[" + member.getWriter() + "]");
		            System.out.println("출판사 : " + "[" + member.getPublisher() + "]");
		            System.out.println("========================================================");
		        }
		    }
	}
}





