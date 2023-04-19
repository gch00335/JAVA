package kr.ac.kopo.MemberUI;

import kr.ac.kopo.LibraryBoardServiceFactory;
import kr.ac.kopo.Bookui.BaseUI;
import kr.ac.kopo.Bookui.IboardUI;
import kr.ac.kopo.Memberservice.LibraryBoardService;
import kr.ac.kopo.Membervo.LibraryBoardVO;

public class ManagerJoinUI extends BaseUI implements IboardUI {
	private LibraryBoardService boardService;

	public ManagerJoinUI() {
		boardService = LibraryBoardServiceFactory.getInstance();

	}

	@Override
	public void execute() throws Exception {
		LibraryBoardVO manager = new LibraryBoardVO();
		
		System.out.println("=======<<회원가입>>=======");

		while(true) {
			String loginID = scanStr(" 1) 사용할 ID를 입력하세요 : "); // 로그인 아이디 입력
			
			if(loginID.length() == 0) {
				continue;
			}
			
			manager.setLoginID(loginID);
			break;
		}
		while(true) {
			String loginPW = scanStr(" 2) 사용할 패스워드를 입력하세요 : "); // 로그인 비번 입력

			if(loginPW.length() == 0) {
				continue;
			}

			while(true) {
				String loginPWconfirm = scanStr(" 2) 패스워드 확인 : "); // 로그인 비번 재확인

				if(loginPWconfirm.length() == 0) {
					continue;
				}
				if(loginPW.equals(loginPWconfirm) == false) {
					System.out.println("비밀번호가 일치하지 않습니다.");
					continue;
				} else{
					manager.setLoginPW(loginPW); 
					break;
				}
			} 

	
		 
		break;
	}
          boardService.insertManager(manager);
		 
		 System.out.println("*********************************************");
		 System.out.println("********* 등록을 완료하였습니다 (*˙︶˙*)ﾉ *********");
		 System.out.println("*********************************************");	
}
	
}
