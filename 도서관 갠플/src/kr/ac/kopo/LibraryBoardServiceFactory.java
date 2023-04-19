package kr.ac.kopo;

import kr.ac.kopo.Memberservice.LibraryBoardService;

public class LibraryBoardServiceFactory {
	

private static LibraryBoardService service = null; 
	
	public static LibraryBoardService getInstance() {
		
		if(service == null ) {
			service = new LibraryBoardService();
			
		}
		
		return service;
	

	}
}


