package kr.ac.kopo.day14_1Homework;

import kr.ac.kopo.day10.Homework.Teacher_ScannerUtil;

public class First  {

	Teacher_ScannerUtil scan = new Teacher_ScannerUtil();
	
	int f ;
	
	
	 First ( ) {
	
	 }

	 
	 First (int f ) {
		 this.f = f;
		 
	 }
	 
	public int fball() {
	
			for (int i= 1 ; i <= f ; i ++) {
				if(i!=f) {
		System.out.println("1");
	} else {
		System.out.println("0");
	}
			}
			return 0;
	}
}