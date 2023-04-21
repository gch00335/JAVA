package kr.ac.kopo.MemberUI;

import kr.ac.kopo.LibraryBoardServiceFactory;
import kr.ac.kopo.Bookui.BaseUI;
import kr.ac.kopo.Bookui.IboardUI;
import kr.ac.kopo.Memberservice.LibraryBoardService;
import kr.ac.kopo.Membervo.LibraryBoardVO;


public class JoinUI extends BaseUI implements IboardUI {

	private LibraryBoardService boardService;

	public JoinUI() {
		boardService = LibraryBoardServiceFactory.getInstance();

	}

	@Override
	public void execute() throws Exception {
		LibraryBoardVO board = new LibraryBoardVO();

		System.out.println("========================================================");
		System.out.println("                       <<회원가입>>                       ");
		System.out.println("========================================================");

		while(true) {
			String loginID = scanStr(" 1) [사용할 ID]를 입력하세요 : "); // 로그인 아이디 입력
			
			if(loginID.length() == 0) {
				continue;
			}
			//if( boardService.selectByNo(loginID)) { //중복체크는..일단 다음에..
			//System.out.println("이미 사용중인 아이디 입니다.");
			//	continue;
			//}
			board.setLoginID(loginID);
			break;
		}
		while(true) {
			String loginPW = scanStr(" 2) [사용할 패스워드]를 입력하세요 : "); // 로그인 비번 입력

			if(loginPW.length() == 0) {
				continue;
			}

			while(true) {
				String loginPWconfirm = scanStr(" 2) [패스워드 확인] : "); // 로그인 비번 재확인

				if(loginPWconfirm.length() == 0) {
					continue;
				}
				if(loginPW.equals(loginPWconfirm) == false) {
					System.out.println("========================================================");
					System.out.println("                   비밀번호가 일치하지 않습니다.               ");
					System.out.println("========================================================");
					continue;
				} else{
					 board.setLoginPW(loginPW); 
					break;
				}
			} 
			System.out.println("========================================================");
			System.out.println("                      <<개인정보 입력>>                    ");
			System.out.println("========================================================");
			while(true) {
				String name = scanStr(" 1) [이름]을 입력하세요: "); // 이름 입력

				if(name.length() == 0) {
					continue;
				}
				 board.setName(name);
				break;
			}
			while(true) {
				String birth  = scanStr(" 2) [생년월일을 6자리]를 입력하세요(ex: 990101): "); // 생년월일 입력

				if(birth.length() == 0) {
					continue;
				}
				 board.setBirth(birth);
				break;
			}
			while(true) {
				String mail = scanStr(" 3) [메일]을 입력하세요: "); // 메일 입력

				if(mail.length() == 0) {
					continue;
				}
				 board.setMail(mail);
				break;
			}
			while(true) {
				String phone = scanStr(" 4) [전화번호]를 입력하세요(ex : 000-0000-0000) : "); // 이름 입력

				if(phone.length() == 0) {
					continue;
				}
				 board.setPhone(phone);
				break;
			}
			break;
		}
		
		 
		 boardService.insertBoard(board);
		 

		 System.out.println("********************************************************");
		 System.out.println("                  < 등록을 완료하였습니다  >                 ");
		 System.out.println("********************************************************");
	}
}

