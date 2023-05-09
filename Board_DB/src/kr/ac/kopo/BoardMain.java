package kr.ac.kopo;

import kr.ac.kopo.ui.BoardUI;

public class BoardMain {
	
	public static void main(String[] args) {
		
		try {
			new BoardUI().execute();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
