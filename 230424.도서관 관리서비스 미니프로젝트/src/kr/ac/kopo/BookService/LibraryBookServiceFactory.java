package kr.ac.kopo.BookService;

public class LibraryBookServiceFactory {
	

private static LibraryBookService service = null; 
	
	public static LibraryBookService getInstance() {
		
		if(service == null ) {
			service = new LibraryBookService();
			
		}
		
		return service;
	

	}
}


