package kr.ac.kopo;

import java.util.List;

import kr.ac.kopo.Bookui.BaseUI;
import kr.ac.kopo.Bookui.IboardUI;
import kr.ac.kopo.Memberdao.LibraryBoardDAO;
import kr.ac.kopo.Memberservice.LibraryBoardService;
import kr.ac.kopo.Membervo.LibraryBoardVO;

public class SearchMemberUI extends BaseUI implements IboardUI {
	private LibraryBoardDAO boardDAO;
	
	private LibraryBoardService boardService;

	public SearchMemberUI() {
		boardDAO = new  LibraryBoardDAO();
		boardService = LibraryBoardServiceFactory.getInstance();
	
}


	@Override
	public void execute() throws Exception {
	    List<LibraryBoardVO> board = boardDAO.selectAllBoard();
	    if(board == null || board.size() == 0) {
		     	System.out.println("                 [회원이 존재하지 않습니다]                  ");

		}else {
			for(LibraryBoardVO member : board) { // 1.5버전의 구문
				System.out.println("========================================================");
			
				System.out.println("[번 호]      : " + member.getNo());
				System.out.println("[아 이 디]   :" +member.getLoginID());
				System.out.println("[비 밀 번 호] : " + member.getLoginPW());
				System.out.println("[이 름]      : "+ member.getName());
				System.out.println("[생 일]      : "+member.getBirth());
				System.out.println("[핸 드 폰]   : "+member.getPhone());
				System.out.println("[메 일]      : " + member.getMail());
			
				System.out.println("========================================================");
			
		
	}
		}
	}
}


