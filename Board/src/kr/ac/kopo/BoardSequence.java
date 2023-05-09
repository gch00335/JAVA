package kr.ac.kopo;
/*
 * 게시물 번호를 순차적으로 얻어오는 기능 클래스
 * @author User
 * 
 */
public class BoardSequence {

	private static int boardNo;
	
	public static int getBoardNO() {
		return ++BoardSequence.boardNo;
	}
}
