package kr.ac.kopo.BookService;

import java.util.List;
import java.util.Set;

import kr.ac.kopo.BookDAO.LibraryBookDAO;
import kr.ac.kopo.BookVO.BookVO;

public class LibraryBookService {
	//ui가 서비스를 호출하면 서비스가 여러개를 호출해서 ui에게 전달하는 시스템

		private LibraryBookDAO boardDao;
		
		public LibraryBookService() {
			boardDao = new LibraryBookDAO();
			
		}
		public List<BookVO> insertBoard(BookVO board) {
			List<BookVO> boardList = boardDao.insertBoard(board); 
	        return boardList; 

		}
		
		public List<BookVO> selectAll(){ /// 시작하기전에 한번꼭 해주기 즉, 더해주고 나서 해주기 
			//왜냐면 이거로 전체조회하면 계속 쌓여지기 때문에...
			List<BookVO> boardList = boardDao.selectAllBoard(); 
	        return boardList; 
		}
		

		
		public static LibraryBookService getInstance() {
			return null;
		}
		public Set<BookVO> selectSee(){
			Set<BookVO> boardList = boardDao.selectSeeBoard2(); 
	        return boardList; 
		
		}
		public List<BookVO> search(String booksearch) {
			List<BookVO> boardList = boardDao.search(); 
			return null;
		}
		public List<BookVO> Rental() {
			List<BookVO> boardList = boardDao.Rental(null);
			return null;
		}
		public List<BookVO> returnbook() throws Exception {
			List<BookVO> boardList = boardDao.returnbook();
			return null;
		}
		public List<BookVO> search2(String booksearch2) {
			List<BookVO> boardList = boardDao.search2(); 
	        return boardList; 
		}
		public Set<BookVO> DelectBook() {
			List<BookVO> boardList = boardDao.DelectBook(null); 
			return null;
		}
	
	
		
}
		
	


	

