package kr.ac.kopo.BookDAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import kr.ac.kopo.LibraryBoardServiceFactory;
import kr.ac.kopo.BookVO.BookVO;
import kr.ac.kopo.Bookui.IboardUI;
import kr.ac.kopo.Memberdao.LibraryBoardDAO;
import kr.ac.kopo.Memberservice.LibraryBoardService;
import kr.ac.kopo.Membervo.LibraryBoardVO;
import kr.ac.kopo.util.ConnectionFactory;



public class LibraryBookDAO {
	


	private LibraryBoardVO loggedInUser;
	
	public LibraryBookDAO() {// 도서전체 조회 , 도서추가, 도서 삭제, 도서정보수정, 도서검색
		
		LibraryBoardDAO boardDAO = new  LibraryBoardDAO();
		LibraryBoardService boardService = LibraryBoardServiceFactory.getInstance();
	
	}
	
	public List<BookVO> insertBoard(BookVO book) { // 관리자모드에 도서 추가
		//1.7구문 사용
		
		StringBuilder sql = new StringBuilder();
	    sql.append("insert into ttt_book(no, Bookname, writer,publisher)");
	    sql.append("values(seq_ttt_book_no.nextval, ? ,?, ?)");

	    try (
	            Connection conn = new ConnectionFactory().getConnection();
	            PreparedStatement pstmt = conn.prepareStatement(sql.toString());
	    ) {

	        pstmt.setString(1, book.getBookname());
	        pstmt.setString(2, book.getWriter());
	        pstmt.setString(3, book.getPublisher());

	        pstmt.executeUpdate();

	        // e_book 테이블에도 새 도서 정보 추가
	        StringBuilder insertSql = new StringBuilder();
	        insertSql.append("insert into e_book(no, Bookname, writer,publisher)");
	        insertSql.append("values(seq_ttt_book_no.currval, ? ,?, ?)");

	        try (PreparedStatement ePstmt = conn.prepareStatement(insertSql.toString())) {

	            ePstmt.setString(1, book.getBookname());
	            ePstmt.setString(2, book.getWriter());
	            ePstmt.setString(3, book.getPublisher());

	            ePstmt.executeUpdate();

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
		return null;
	}
	
	
	
	///////////////////////////////////도서삭제//////////////////////////

	public List<BookVO> DelectBook(BookVO book) { // 관리자모드에 도서 추가
		Scanner sc = new Scanner(System.in); 
	    System.out.println("========================================================");
	    System.out.println("삭제할 도서의 코드를 입력하세요: ");
	    System.out.println("========================================================");
	    String keyword = sc.nextLine();

	    StringBuilder selectSql = new StringBuilder();
	    selectSql.append("SELECT * FROM ttt_book WHERE no = ?");
	    
	    StringBuilder deleteSql = new StringBuilder();
	    deleteSql.append("DELETE FROM ttt_book WHERE no = ?");

	    try (
	        Connection conn = new ConnectionFactory().getConnection();
	        PreparedStatement pstmtSelect = conn.prepareStatement(selectSql.toString());
	        PreparedStatement pstmtDelete = conn.prepareStatement(deleteSql.toString());
	    ) {
	        pstmtSelect.setString(1, keyword);
	        ResultSet rs = pstmtSelect.executeQuery();

	        if (rs.next()) {
	            int no = rs.getInt("no");
	            String bookname = rs.getString("bookname");
	            String writer = rs.getString("writer");
	            String publisher = rs.getString("publisher");
	         
	            
	            pstmtDelete.setInt(1, no);
	            int affectedRows = pstmtDelete.executeUpdate();
	            
	            if (affectedRows > 0) {
	                StringBuilder eSelectSql = new StringBuilder();
	                eSelectSql.append("SELECT * FROM e_book WHERE bookname = ? AND writer = ? AND publisher = ?");
	                
	                StringBuilder eDeleteSql = new StringBuilder();
	                eDeleteSql.append("DELETE FROM e_book WHERE no = ?");
	                
	                try (
	                    PreparedStatement ePstmtSelect = conn.prepareStatement(eSelectSql.toString());
	                    PreparedStatement ePstmtDelete = conn.prepareStatement(eDeleteSql.toString());
	                ) {
	                    ePstmtSelect.setString(1, bookname);
	                    ePstmtSelect.setString(2, writer);
	                    ePstmtSelect.setString(3, publisher);
	                    
	                    ResultSet eRs = ePstmtSelect.executeQuery();
	                    
	                    if (eRs.next()) {
	                        int eNo = eRs.getInt("no");
	                        ePstmtDelete.setInt(1, eNo);
	                        ePstmtDelete.executeUpdate();
	                        
	                        System.out.println("========================================================");
	                        System.out.println("                    [삭제가 완료되었습니다.]                  ");
	                        System.out.println("========================================================");
	                    } else {
	                        System.out.println("========================================================");
	                        System.out.println("                      [검색 결과가 없습니다.]                ");
	                        System.out.println("========================================================");
	                    }
	                }
	            } else {
	                System.out.println("========================================================");
	                System.out.println("                      [검색 결과가 없습니다.]                ");
	                System.out.println("========================================================");
	            }
	        } else {
	            System.out.println("========================================================");
	            System.out.println("                      [검색 결과가 없습니다.]                ");
	            System.out.println("========================================================");
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return null;
	}
	
	
	
	
	
	
	
	
	
	
/////////////////////도서 검색 모드/////////////////////////
	public List<BookVO> search() {/////////////////////////////////////////////////////관리자 = 도서 검색 모드 ! 

		Scanner sc = new Scanner(System.in);
		 System.out.println("========================================================");
		System.out.println("검색할 도서명을 입력하세요 : ");
		 System.out.println("========================================================");
		String keyword = sc.nextLine();

		StringBuilder sql = new StringBuilder();
		sql.append("SELECT no, Bookname, writer, publisher ");
		sql.append("FROM ttt_book ");
		sql.append("WHERE Bookname LIKE ?");

		List<BookVO> bookList = new ArrayList<>();
		try (
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				) {
			pstmt.setString(1, "%" + keyword + "%");
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
			 System.out.println( "            [" +keyword+ "] 의 검색 결과가 없습니다.         ");
			 System.out.println("========================================================");
		} else if (bookList.size() == 1) {
			BookVO book = bookList.get(0);
			 System.out.println("========================================================");
			 System.out.println("코  드 : " + "["+book.getNo()+"]");
			 System.out.println("제  목 : " + "["+ book.getBookname()+"]");
			 System.out.println("저  자 : " + "["+ book.getWriter()+"]");
			 System.out.println("출 판 사 : "+ "["+ book.getPublisher()+"]");
			 System.out.println("========================================================");


		} else {
			for (BookVO book : bookList) {
				 System.out.println("========================================================");
				 System.out.println("코  드 : " + "["+book.getNo()+"]");
				 System.out.println("제  목 : " + "["+ book.getBookname()+"]");
				 System.out.println("저  자 : " + "["+ book.getWriter()+"]");
				 System.out.println("출 판 사 : "+ "["+ book.getPublisher()+"]");
				 System.out.println("========================================================");

			}
		}
		return bookList;
	}
	
	
	

	public List<BookVO> search2() {  //////////////////////////////////////////////////////////////////// 일반회원 모드
	Scanner sc = new Scanner(System.in);
	 System.out.println("========================================================");
	System.out.println("검색할 도서명을 입력하세요 : ");
	 System.out.println("========================================================");
	String keyword = sc.nextLine();

	StringBuilder sql = new StringBuilder();
	sql.append("SELECT no, Bookname, writer, publisher ");
	sql.append("FROM e_book ");
	sql.append("WHERE Bookname LIKE ?");

	List<BookVO> bookList = new ArrayList<>();
	try (
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			) {
		pstmt.setString(1, "%" + keyword + "%");
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
		 System.out.println("               [" +keyword+ "] 의 검색 결과가 없습니다.          ");
		 System.out.println("========================================================");
	} else if (bookList.size() == 1) {
		BookVO book = bookList.get(0);
		 System.out.println("========================================================");
		 System.out.println("코  드 : " + "["+book.getNo()+"]");
		 System.out.println("제  목 : " + "["+ book.getBookname()+"]");
		 System.out.println("저  자 : " + "["+ book.getWriter()+"]");
		 System.out.println("출 판 사 : "+ "["+ book.getPublisher()+"]");
		 System.out.println("========================================================");

	} else {
		for (BookVO book : bookList) {
			 System.out.println("========================================================");
			 System.out.println("코  드 : " + "["+book.getNo()+"]");
			 System.out.println("제  목 : " + "["+ book.getBookname()+"]");
			 System.out.println("저  자 : " + "["+ book.getWriter()+"]");
			 System.out.println("출 판 사 : "+ "["+ book.getPublisher()+"]");
			 System.out.println("========================================================");

		}
	}
	return bookList ;
}

	

	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////도서대출///////////////////
	
	public List<BookVO> Rental(LibraryBoardVO loggedInUser){
		 Scanner sc = new Scanner(System.in); 
		 System.out.println("========================================================");
		    System.out.println("대출할 도서의 코드를 입력하세요: ");
		    System.out.println("========================================================");
		    
		    int bookNo = sc.nextInt();

		    Connection conn = null;
		    PreparedStatement pstmt = null;
		    ResultSet rs = null;
		    try {
		        conn = new ConnectionFactory().getConnection();
		        conn.setAutoCommit(false);

		        // 대출할 도서 정보 조회
		        StringBuilder selectSql = new StringBuilder();
		        selectSql.append("SELECT Bookname, writer, publisher ");
		        selectSql.append("FROM e_book ");
		        selectSql.append("WHERE no = ? ");

		        pstmt = conn.prepareStatement(selectSql.toString());
		        pstmt.setInt(1, bookNo);
		        rs = pstmt.executeQuery();

		        if (rs.next()) {
		            String bookName = rs.getString("Bookname");
		            String writer = rs.getString("writer");
		            String publisher = rs.getString("publisher");

		            // 대출 정보 삽입
		            StringBuilder insertSql = new StringBuilder();
		            insertSql.append("INSERT INTO r_book(loginid, no, bookname, writer, publisher) ");
		            insertSql.append("VALUES (?, ?, ?, ?, ?)");
		            
		            LibraryBoardVO board = new LibraryBoardVO();
		    		IboardUI ui = null;
		            
		    		System.out.println("========================================================");
				    System.out.println("보안을 위해 아이디를 입력하세요: ");
				    String id = sc.next();
				    System.out.println("========================================================");
		    		System.out.println("보안을 위해 비밀번호를 입력하세요: ");
				    String password = sc.next();
				    System.out.println("========================================================");

				    LibraryBoardVO loggedInUser1 = LibraryBoardDAO.login(id, password);
				    if (loggedInUser1 == null) {
				    	
				        System.out.println("        [로그인 실패] 아이디 또는 비밀번호가 올바르지 않습니다.     ");
				        System.out.println("========================================================");
				       
				    } else {


				    
		            pstmt = conn.prepareStatement(insertSql.toString());
		           
		            pstmt.setString(1, loggedInUser1.getLoginID()); // 사용자 아이디 전달
		            pstmt.setInt(2, bookNo);
		            pstmt.setString(3, bookName);
		            pstmt.setString(4, writer);
		            pstmt.setString(5, publisher);
		            

		            pstmt.executeUpdate();

		            // 대출한 도서 삭제
		            StringBuilder deleteSql = new StringBuilder();
		            deleteSql.append("DELETE FROM e_book WHERE no = ?");

		            pstmt = conn.prepareStatement(deleteSql.toString());
		            pstmt.setInt(1, bookNo);
		            pstmt.executeUpdate();

		            conn.commit();
		            System.out.println("========================================================");
		            System.out.println("                ["+id+"]" + "님 대출이 완료되었습니다.          ");
		            System.out.println("========================================================");
		          
		            
		     
		            return null;


				    }
		        }else {
		        	System.out.println("========================================================");
		            System.out.println("                [해당 도서가 존재하지 않습니다.]               ");
		            System.out.println("========================================================");
		        }
		    } catch (Exception e) {
		        if (conn != null) {
		            try {
		                conn.rollback();
		            } catch (Exception ex) {
		                ex.printStackTrace();
		            }
		        }
		        e.printStackTrace();
		    } finally {
		        if (rs != null) {
		            try {
		                rs.close();
		            } catch (Exception e) {
		                e.printStackTrace();
		            }
		        }
		        if (pstmt != null) {
		            try {
		                pstmt.close();
		            } catch (Exception e) {
		                e.printStackTrace();
		            }
		        }
		        if (conn != null) {
		            try {
		                conn.setAutoCommit(true);
		                conn.close();
		            } catch (Exception e) {
		                e.printStackTrace();
		            }
		        }
		    }
			return null;
		}

/////////////////////////////////////////////////////////////////////////////////////////////	
	
//////////////////////도서반납////////////////////////////////////////////- 대출목록에서 코드를 조회해와서 도서목록에 추가 후 대출목록 지우기

	public List<BookVO> returnbook() throws Exception{
		Scanner sc = new Scanner(System.in);
    	System.out.println("========================================================");
		System.out.println(" [반납할 도서의 코드]를 입력하세요:                            ");
    	System.out.println("========================================================");
		int bookNo = sc.nextInt();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = new ConnectionFactory().getConnection();
			conn.setAutoCommit(false);

			// 반납 도서 정보 조회
			StringBuilder selectSql = new StringBuilder();
			selectSql.append("SELECT Bookname, writer, publisher ");
			selectSql.append("FROM r_book ");
			selectSql.append("WHERE no = ? ");

			pstmt = conn.prepareStatement(selectSql.toString());
			pstmt.setInt(1, bookNo);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				String bookName = rs.getString("Bookname");
				String writer = rs.getString("writer");
				String publisher = rs.getString("publisher");

				// 대출 정보 삽입
				StringBuilder insertSql = new StringBuilder();
				insertSql.append("INSERT INTO e_book( no, bookname, writer, publisher) ");
				insertSql.append("VALUES ( ?, ?, ?, ?)");

				LibraryBoardVO board = new LibraryBoardVO();
				IboardUI ui = null;

			
					pstmt = conn.prepareStatement(insertSql.toString());

				
					pstmt.setInt(1, bookNo);
					pstmt.setString(2, bookName);
					pstmt.setString(3, writer);
					pstmt.setString(4, publisher);


					pstmt.executeUpdate();
					 
					// 대출한 도서 삭제
		            StringBuilder deleteSql = new StringBuilder();
		            deleteSql.append("DELETE FROM r_book WHERE no = ?");

		            pstmt = conn.prepareStatement(deleteSql.toString());
		            pstmt.setInt(1, bookNo);
		            pstmt.executeUpdate();


		        	System.out.println("========================================================");
					System.out.println("               ["+bookName+"]" + " 반납이 완료되었습니다.     ");
			    	System.out.println("========================================================");
				
			} else {
				System.out.println("========================================================");
				System.out.println("                [반납할 도서가 존재하지 않습니다.]             ");
				System.out.println("========================================================");
			}
		
		    conn.commit();
		
		    } catch (Exception ex) {
		        if (conn != null) {
		            conn.rollback();
		        }
		        ex.printStackTrace();
		       
		    } finally {
		        if (rs != null) {
		            rs.close();
		        }
		        if (pstmt != null) {
		            pstmt.close();
		        }
		        if (conn != null) {
		            conn.setAutoCommit(true);
		            conn.close();
		        }
		    }
		    return null;
		}









	
	
	
	
	
	
////////////////////////도서전체 조회 ///////////////


public List<BookVO> selectAllBoard(){ // 관지라모드 전체 고유 도서전체조회 -- 반납하든 대출하든 정보 그대로!
	StringBuilder sql = new StringBuilder();
	sql.append("select no, Bookname, writer,publisher "); 
	sql.append("  from ttt_book ");
	sql.append("order by no desc");
	List<BookVO> bookList = new ArrayList<>();

	try(
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			){

		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) { 
			int no = rs.getInt("no");
			String Bookname = rs.getString("Bookname");
			String writer = rs.getString("writer");
			String publisher = rs.getString("publisher");

			BookVO board = new BookVO(no, Bookname, writer, publisher);


			bookList.add(board);
		}
	}catch(Exception e ) {
		e.printStackTrace();	
	}
	return bookList;
}





/*public Set<BookVO> selectSeeBoard(){ //일반용  ... 관리자모드를 끌고와서 임시테이블로 보여주고 대출,반납기능  
	                                 // 미완성..후..반납 ,대출하면 잘되는데..전제조회하면 계속 책이 추가됨..하 .. 일단 굴러가야하니까 한번만 조회하고 나중에 오류수정하기

	StringBuilder sql = new StringBuilder();
    sql.append("select no, Bookname, writer, publisher "); 
    sql.append("from ttt_book ");
    
    Set<BookVO> bookList = new HashSet<>();
    
    try (
        Connection conn = new ConnectionFactory().getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql.toString());
        ResultSet rs = pstmt.executeQuery();
    ) {
        while (rs.next()) { 
            int no = rs.getInt("no");
            String bookName = rs.getString("Bookname");
            String writer = rs.getString("writer");
            String publisher = rs.getString("publisher");
            BookVO book = new BookVO(no, bookName, writer, publisher);
            bookList.add(book);
        }
        
        // e_book 테이블에서 r_book 테이블과 중복되는 데이터 삭제
        StringBuilder deleteSql = new StringBuilder();
        deleteSql.append("delete from e_book ");
        deleteSql.append("where (no, Bookname, writer, publisher) in (");
        deleteSql.append("select r.no, r.Bookname, r.writer, r.publisher ");
        deleteSql.append("from r_book r inner join e_book e on r.no = e.no");
        deleteSql.append(")");
        
        try (PreparedStatement pstmt2 = conn.prepareStatement(deleteSql.toString())) {
            pstmt2.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // e_book 테이블에 데이터 삽입
        StringBuilder insertSql = new StringBuilder();
        insertSql.append("insert into e_book(no, Bookname, writer, publisher) "); 
        insertSql.append("values(?, ?, ?, ?)");

        try (PreparedStatement pstmt1 = conn.prepareStatement(insertSql.toString())) {
            for (BookVO book : bookList) {
                pstmt1.setInt(1, book.getNo());
                pstmt1.setString(2, book.getBookname());
                pstmt1.setString(3, book.getWriter());
                pstmt1.setString(4, book.getPublisher());
              
                pstmt1.addBatch();
            }
            pstmt1.executeBatch();
            pstmt1.clearBatch();
        } catch (Exception e) {
            e.printStackTrace();
        }
    } catch(Exception e) {
        e.printStackTrace();    
    }
    
    return bookList;
}
*/


	
	
	//////////////////////////////////////대출,검색할때보여지는 (대출한 책들이 빠져있는) 전체목록/////////////////////////////
public Set<BookVO> selectSeeBoard2(){

	StringBuilder sql = new StringBuilder();
	sql.append("select no, Bookname, writer,publisher "); 
	sql.append("  from e_book ");
	sql.append("order by no desc");
	Set<BookVO> bookList = new HashSet<>();
	try(
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			){

		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) { 
			int no = rs.getInt("no");
			String Bookname = rs.getString("Bookname");
			String writer = rs.getString("writer");
			String publisher = rs.getString("publisher");

			BookVO board = new BookVO(no, Bookname, writer, publisher);
			
			bookList.add(board);

			
		}
	}catch(Exception e ) {
		e.printStackTrace();	
	}
	return bookList;
}











//////////////////////////////////////개인 대출목록/////////////////////////////
public List<BookVO>  BookReturn() { /////////////////////////////////////////////////////일반회원 = 대출목록에서 자기 아이디만 조회해서보여지게 ! 

	Scanner sc = new Scanner(System.in);
	System.out.println("========================================================");
	System.out.println(" [검색할 도서명]을 입력하세요 :                               ");
	System.out.println("========================================================");
	String keyword = sc.nextLine();

	StringBuilder sql = new StringBuilder();
	sql.append("SELECT no, Bookname, writer, publisher ");
	sql.append("FROM ttt_book ");
	sql.append("WHERE Bookname LIKE ?");

	List<BookVO> bookList = new ArrayList<>();
	try (
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			) {
		pstmt.setString(1, "%" + keyword + "%");
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
		System.out.println("                    [검색 결과가 없습니다.]                  ");
		System.out.println("========================================================");
	} else if (bookList.size() == 1) {
		BookVO book = bookList.get(0);
		 System.out.println("========================================================");
		 System.out.println("코  드 : " + "["+book.getNo()+"]");
		 System.out.println("제  목 : " + "["+ book.getBookname()+"]");
		 System.out.println("저  자 : " + "["+ book.getWriter()+"]");
		 System.out.println("출 판 사 : "+ "["+ book.getPublisher()+"]");
		 System.out.println("========================================================");

	} else {
		for (BookVO book : bookList) {
			 System.out.println("========================================================");
			 System.out.println("코  드 : " + "["+book.getNo()+"]");
			 System.out.println("제  목 : " + "["+ book.getBookname()+"]");
			 System.out.println("저  자 : " + "["+ book.getWriter()+"]");
			 System.out.println("출 판 사 : "+ "["+ book.getPublisher()+"]");
			 System.out.println("========================================================");
		}
	}
	return bookList;
}
}