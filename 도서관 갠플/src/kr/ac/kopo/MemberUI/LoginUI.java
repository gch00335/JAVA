package kr.ac.kopo.MemberUI;

import java.util.Scanner;

import kr.ac.kopo.LibraryBoardServiceFactory;
import kr.ac.kopo.LibraryLogin;
import kr.ac.kopo.Bookui.BaseUI;
import kr.ac.kopo.Bookui.IboardUI;
import kr.ac.kopo.Bookui.RentalUI;
import kr.ac.kopo.Memberdao.LibraryBoardDAO;
import kr.ac.kopo.Memberservice.LibraryBoardService;
import kr.ac.kopo.Membervo.LibraryBoardVO;


public class LoginUI extends BaseUI implements IboardUI {
	  

	public static String memberId; 
	private LibraryBoardDAO boardDAO;
	private LibraryBoardVO loggedInUser; // 로그인한 사용자 정보를 저장할 필드
	private LibraryBoardService boardService;

	public  LoginUI() {
		boardDAO = new  LibraryBoardDAO();
		boardService = LibraryBoardServiceFactory.getInstance();
	}
	
	public void execute() throws Exception {
	    LibraryBoardVO board = new LibraryBoardVO();
		IboardUI ui = null;

		  Scanner sc = new Scanner(System.in);
		  System.out.println("============================================");
		    System.out.println("아이디를 입력하세요: ");
		    String id = sc.next();
		    System.out.println("============================================");
		    System.out.println("비밀번호를 입력하세요: ");
		    String password = sc.next();
		    System.out.println("============================================");

		    LibraryBoardVO memberId = boardDAO.login(id, password);

		    if (memberId == null) {
		        System.out.println("로그인 실패: 아이디 또는 비밀번호가 올바르지 않습니다.");
		        return;
		    } else {

		    	// loggedInUser = new LibraryBoardVO();  // loggedInUser 객체 생성
		       //  LibraryBoardVO[] users = new LibraryBoardVO[1];
		        // users[0] = memberId;
		         
		       //  loggedInUser.setUsers(users);  // setUsers() 메서드 호출하여 배열 저장
		       //  System.out.println(memberId.getLoginID()); 
		       //System.out.println(Arrays.toString(users)); 
		            
		            
		    	/*int no = loginno.getNo();
		    	String LoginID = loginno.getLoginID();
		    	String LoginPW = loginno.getLoginPW();
		    	String Name  = loginno.getName();
		    	String Birth = loginno.getBirth();
		    	String Mail = loginno.getMail();
		    	String Phone = loginno.getPhone();*/
		    	
		    	 // 사용자 정보를 배열에 저장
		         // 배열 첫 번째 인덱스에 저장
		    
		  

		    	
		    System.out.println("로그인에 성공하셨습니다.");
		    System.out.println("["+id+"]" + "님 환영합니다.");

		
		   /* board.setNo(no);;
		    board.setLoginID(LoginID);
		    board.setLoginPW(LoginPW);
		    board.setName(Name);
		    board.setBirth(Birth);
		    board.setMail(Mail);
		    board.setPhone(Phone);
		    
		    boardService.einsertBoard(board); /// 임시테이블을 만들어서 로그인할때마다 정보추가되고 로그아웃되면 삭제하려곻 ㅏㅁ
		                                        //근데 인식을 못해!!!악 시퀀스가 왜 존재안해..
		    
		    System.out.println(board);
	*/
		    
		   while(true) {
			    System.out.println("*********************************************");
			    System.out.println("             (｡•̀ᴗ-ღ) 찌니 도서관 입장            ");
				System.out.println("*********************************************");
				System.out.println("1. [도서대출] 선택");
				System.out.println("2. [도서반납] 선택");
				System.out.println("3. [마이페이지] 선택"); // mypage
				System.out.println("4. 이전으로 돌아가기");
				System.out.println("0. ---시스템 종료---");
				System.out.println("============================================");
				System.out.print("원하는 항목을 선택하세요 : ");
				Scanner sc2 = new Scanner(System.in);
				int type = sc.nextInt();
				sc.nextLine();
				
				switch (type) {
				case 1:
					ui =  new RentalUI() ; // 도서대출
					break;
				case 2:
					//ui = new ReturnUI(); // 도서반납
					break;
				case 3:
					ui = new MypageUI(); //마이페이지 - 개인정보 출력 , 도서대여목록조회, 개인정보 수정 
					break;
		
				case 4:
					ui = new LibraryLogin();
					break;
					
				case 0:
					System.exit(0);
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

	public LibraryBoardVO getLoggedInUser() {
		// TODO Auto-generated method stub
		return null;
	}

	} 
	



		
