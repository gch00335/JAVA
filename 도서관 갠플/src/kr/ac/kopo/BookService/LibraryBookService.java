package kr.ac.kopo.BookService;

import java.util.List;

import kr.ac.kopo.BookDAO.LibraryBookDAO;
import kr.ac.kopo.BookVO.BookVO;

public class LibraryBookService {
	//ui가 서비스를 호출하면 서비스가 여러개를 호출해서 ui에게 전달하는 시스템

		private LibraryBookDAO boardDao;
		
		public LibraryBookService() {
			boardDao = new LibraryBookDAO();
			
		}
		public void insertBoard(BookVO board) {
	

		}
		
		public List<BookVO> selectAll(){
			List<BookVO> boardList = boardDao.selectAllBoard(); 
	        return boardList; 
		}
		
		public BookVO selectByNo(int bookNo) {
			
			BookVO board = boardDao.selectBoardByNo(bookNo);
			return board;
		} 
		
		public static LibraryBookService getInstance() {
			return null;
		}
		public List<BookVO> selectSee(){
			List<BookVO> boardList = boardDao.selectSeeBoard(); 
	        return boardList; 
		
		}
		
}
		
	


	

