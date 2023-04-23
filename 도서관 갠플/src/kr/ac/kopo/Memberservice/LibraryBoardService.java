package kr.ac.kopo.Memberservice;

import java.util.List;

import kr.ac.kopo.Memberdao.LibraryBoardDAO;
import kr.ac.kopo.Membervo.LibraryBoardVO;

public class LibraryBoardService {
	//ui가 서비스를 호출하면 서비스가 여러개를 호출해서 ui에게 전달하는 시스템

		private LibraryBoardDAO boardDao;
		
		public LibraryBoardService() {
			boardDao = new LibraryBoardDAO();
			
		}
		public void insertBoard(LibraryBoardVO board) {
			
		
			boardDao.insertBoard(board);
		}
		
		public List<LibraryBoardVO> selectAll(){
			List<LibraryBoardVO> boardList = boardDao.selectAllBoard(); 
	        return boardList; 
		}
		
		public List<LibraryBoardVO> selectByNo(String boardID) {
			LibraryBoardVO board = boardDao.selectBoardByNo(boardID);
			return (List<LibraryBoardVO>) board;
		}
		
		public LibraryBoardVO[] getUsers() {
			// TODO Auto-generated method stub
			return null;
		}
		public void UpdateUser(LibraryBoardVO user) {
			
			
		}
		public void insertManager(LibraryBoardVO manager) {
			boardDao.insertManager(manager);
			
		}
		public String[] getBooks() {
			// TODO Auto-generated method stub
			return null;
		}
		public LibraryBoardVO DelectIdUI(Object object) {
			  LibraryBoardVO board = boardDao.DelectIdUI();
			return null;
		}
	
		public boolean isDuplicateID(String loginID) {
		    List<LibraryBoardVO> memberList = selectAll(); // 회원목록 가져오기
		    for (LibraryBoardVO member : memberList) {
		        if (member.getLoginID().equals(loginID)) {
		            return true; // 중복 아이디 발견
		        }
		    }
		    return false; // 중복 아이디 없음
		}
		
		
	
		}
	
	
	



	

