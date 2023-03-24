package kr.ac.kopo.day14_1Homework;

import kr.ac.kopo.day10.Homework.Teacher_ScannerUtil;

public class Third {
	Teacher_ScannerUtil scan = new Teacher_ScannerUtil();
	
	int T ;
	
	
	Third ( ) {
	
	 }

	 
	Third (int t ) {
		 this.T = t;
		 
	 }
	 
	public int tball() {
	
			for (int i= 1 ; i <= T ; i ++) {
				if(i!=T) {
		System.out.println("1");
	} else {
		System.out.println("0");
	}
			}
			return 0;
	}
}



