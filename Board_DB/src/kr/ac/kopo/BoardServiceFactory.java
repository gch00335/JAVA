package kr.ac.kopo;

import kr.ac.kopo.service.BoardService;

public class BoardServiceFactory {
//아까 처음에 했던 방법과 이방법 중 편한걸로 고르면 됨(하지만 되도록 new안쓰는걸 추천)
	private static BoardService service = null; 
	
	public static BoardService getInstance() {
		
		if(service ==null ) {
			service = new BoardService();
			
		}
		
		return service;
	

}
}
