package kr.ac.kopo.MemberUI;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import kr.ac.kopo.LibraryBoardServiceFactory;
import kr.ac.kopo.LibraryLogin;
import kr.ac.kopo.BookVO.BookVO;
import kr.ac.kopo.Bookui.BaseUI;
import kr.ac.kopo.Bookui.IboardUI;
import kr.ac.kopo.Bookui.RentalUI;
import kr.ac.kopo.Memberdao.LibraryBoardDAO;
import kr.ac.kopo.Memberservice.LibraryBoardService;
import kr.ac.kopo.Membervo.LibraryBoardVO;
import kr.ac.kopo.util.ConnectionFactory;


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
		    System.out.println("========================================================");
		    System.out.println("아이디를 입력하세요: ");
		    String id = sc.next();
		    System.out.println("========================================================");
		    System.out.println("비밀번호를 입력하세요: ");
		    String password = sc.next();
		    System.out.println("========================================================");

		    LibraryBoardVO memberId = boardDAO.login(id, password);

		    if (memberId == null) {
		    	System.out.println("========================================================");
		        System.out.println("        [로그인 실패] 아이디 또는 비밀번호가 올바르지 않습니다.     ");
		        System.out.println("========================================================");
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
		    
		  

		    	
			    System.out.println("========================================================");
			    System.out.println("                     로그인에 성공하셨습니다.                    ");
			    System.out.println("                    ["+id+"]" + "님 환영합니다.              ");
			    System.out.println("========================================================");
		
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
			    System.out.println("*******************************************************");
			    System.out.println("                                                         ");
			    System.out.println("                     [찌니 도서관] 입장                     ");
			    System.out.println("                                                         ");
				System.out.println("*******************************************************");
				System.out.println("1. [도서 대출] : 도서검색, 도서 대출하기, 도서 대여 가능 목록 출력  ");
				System.out.println("2. [도서 반납] ");
				System.out.println("3. [도서 대여목록] : 내가 대여한 도서목록 ");
				System.out.println("4. [마이페이지] : 개인정보 출력, 개인정보 수정, 회원 탈퇴 " );
				System.out.println("                                                         ");
				System.out.println("                                                         ");
				System.out.println("5. 이전으로 돌아가기");
				System.out.println("0. ---시스템 종료---");
				System.out.println("========================================================");
				System.out.print("원하는 항목을 선택하세요 : ");
				Scanner sc2 = new Scanner(System.in);
				int type = sc.nextInt();
				sc.nextLine();
				
				switch (type) {
				case 1:
					ui =  new RentalUI() ; // 도서대출
					break;
				case 2:
					ui = new ReturnUI(); // 도서반납
					break;
				case 3:
					
					 StringBuilder sql = new StringBuilder();
						sql.append("SELECT no, Bookname, writer, publisher ");
						sql.append("FROM r_book ");
						sql.append("WHERE loginId LIKE ?");

						List<BookVO> bookList = new ArrayList<>();
						try (
								Connection conn = new ConnectionFactory().getConnection();
								PreparedStatement pstmt = conn.prepareStatement(sql.toString());
								) {
							pstmt.setString(1, "%" + id + "%");
							ResultSet rs = pstmt.executeQuery();

							while (rs.next()) {
								int no = rs.getInt("no");
								String bookname = rs.getString("Bookname");
								String writer = rs.getString("writer");
								String publisher = rs.getString("publisher");

								BookVO book = new BookVO(no, bookname, writer, publisher);
								bookList.add(book);
							}
						} catch (Exception e) {
							e.printStackTrace();
						}

						if (bookList == null || bookList.isEmpty()) {
							 System.out.println("========================================================");
						   	 System.out.println("                   [검색 결과가 없습니다.]                   ");
							 System.out.println("========================================================");
							 
							 break;
						} else if (bookList.size() == 1) {
							BookVO book = bookList.get(0);
							System.out.println("========================================================");
							 System.out.println(              "["+id+"]" + "님 도서대여목록입니다.           ");
							 System.out.println("========================================================");
							 System.out.println("코  드 : " + "["+book.getNo()+"]");
							 System.out.println("제  목 : " + "["+ book.getBookname()+"]");
							 System.out.println("저  자 : " + "["+ book.getWriter()+"]");
							 System.out.println("출 판 사 : "+ "["+ book.getPublisher()+"]");
							 System.out.println("========================================================");
						} else {
							for (BookVO book : bookList) {
								 System.out.println("========================================================");
								 System.out.println(              "["+id+"]" + "님 도서대여목록입니다.           ");
								 System.out.println("========================================================");
								 System.out.println("코  드 : " + "["+book.getNo()+"]");
								 System.out.println("제  목 : " + "["+ book.getBookname()+"]");
								 System.out.println("저  자 : " + "["+ book.getWriter()+"]");
								 System.out.println("출 판 사 : "+ "["+ book.getPublisher()+"]");
								 System.out.println("========================================================");
							}
						}
						
					
					break;
				
				case 4:
					ui = new MypageUI(); //마이페이지 - 개인정보 출력 , 도서대여목록조회, 개인정보 수정 , 회원탈퇴
					break;
		
				case 5:
					ui = new LibraryLogin();
					break;
					
				case 0:
					System.out.println("                ["+id+"]" + "님 로그아웃됩니다              ");
					System.out.println("                     안녕히 가세요                         ");

					System.out.println("========================================================");
					System.exit(0);
					
					break;
				}
				
				if(ui != null) {
					ui.execute();
				} else {
					
				}
			}
		   
		}
		    
	}

	public LibraryBoardVO getLoggedInUser() {
		// TODO Auto-generated method stub
		return null;
	}

	} 
	



		
