package kr.ac.kopo.MemberUI;

import java.util.Scanner;

import kr.ac.kopo.Bookui.BaseUI;
import kr.ac.kopo.Bookui.IboardUI;
import kr.ac.kopo.Memberdao.LibraryBoardDAO;
import kr.ac.kopo.Memberservice.LibraryBoardService;
import kr.ac.kopo.Memberservice.LibraryBoardServiceFactory;
import kr.ac.kopo.Membervo.LibraryBoardVO;

public class UpdateUI extends BaseUI implements IboardUI {

	 private LibraryBoardService boardService;
	   private LibraryBoardVO loggedInUser;

	public UpdateUI() {
		boardService = LibraryBoardServiceFactory.getInstance();
		loggedInUser =  LibraryBoardDAO.getLoggedInUser();
	}
	
	@Override
	public void execute() throws Exception {
		 
		int index = 0;
		
		///배열에서 index 위치에 있는 LibraryBoardVO객체를 가져옴
		LibraryBoardVO[] users = loggedInUser.getUsers();
		LibraryBoardVO user = users[index];
		

		System.out.println("**********************************************************");
		System.out.println("                      [개인정보 수정]                        ");
		System.out.println("**********************************************************");
		System.out.println("1. [비밀번호 수정] 선택");
		System.out.println("2. [이름 수정] 선택");
		System.out.println("3. [이메일 수정] 선택");
		System.out.println("4. [전화번호 수정] 선택");
		System.out.println("5. 이전으로 돌아가기");
		System.out.println("0. ---시스템 종료---");
		System.out.println("========================================================");
		System.out.println("원하는 항목을 선택하세요 : ");
		System.out.println("========================================================");
		Scanner sc = new Scanner(System.in);
		int type = sc.nextInt();
		sc.nextLine();
		
		
		while(true){
			IboardUI ui = null;
			LibraryBoardDAO dao = new LibraryBoardDAO();
			switch (type) { 
			case 1:
				String loginPW = scanStr(" [수정할 비밀번호]를 입력하세요: ");
				user.setLoginPW(String.valueOf(loginPW));
				
				dao.UpdateLoginPW(user);
				System.out.println("========================================================");
				System.out.println("                      수정되었습니다!                       ");
				System.out.println("========================================================");
				break;
			case 2:
				String Name = scanStr(" [수정할 이름]을 입력하세요: ");
				user.setName(Name);
				
				dao.UpdateUserName(user);
				System.out.println("========================================================");
				System.out.println("                      수정되었습니다!                       ");
				System.out.println("========================================================");
				break;
	
			case 3:
				String Mail = scanStr(" 수정할 이메일을 입력하세요: ");
				user.setMail(Mail);
				
				dao.UpdateUserMail(user);
				System.out.println("========================================================");
				System.out.println("                      수정되었습니다!                       ");
				System.out.println("========================================================");
				break;
			case 4:
				String Phone = scanStr(" 수정할 전화번호를 입력하세요: ");
				user.setPhone(String.valueOf(Phone));
				
				dao.UpdateUserPhone(user); 
				System.out.println("========================================================");
				System.out.println("                      수정되었습니다!                       ");
				System.out.println("========================================================");
				break;
			case 5:
				ui = new MypageUI();
				break;
			case 0:
				System.exit(0);
				System.out.println("                 로그아웃됩니다. 안녕히가세요                 ");
				System.out.println("========================================================");
				break;
			}
			
		
			break;
		}
	}
}





	

