package kr.ac.kopo;


public class LibraryMain {

	public static void main(String[] args) {
		
		try {
			new LibraryLogin().execute();
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
