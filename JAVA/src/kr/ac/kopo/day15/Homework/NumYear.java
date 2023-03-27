package kr.ac.kopo.day15.Homework;

import java.util.Calendar;

import kr.ac.kopo.day10.Homework.Teacher_ScannerUtil;

public class NumYear extends num {
	
	Teacher_ScannerUtil scan = new Teacher_ScannerUtil();
	Calendar c = Calendar.getInstance();
	
	
	private int date = c.get(Calendar.MONTH)-2;
	

	
	public NumYear() {
	
	}

	public void numY() {
		 NumMonth M = new  NumMonth ();
		 
		date = c.get(Calendar.MONTH) - 2;
		
		int m = scan.nextInt("년도를 입력하세요");
	
		for (int i = 1; i <= 12; i++) {
			System.out.println();
			System.out.println(m + "년 " + i + "월");
			System.out.println("일  월  화  수  목  금  토");
			M.numM();
		
		}

		
	}

	public void balance() {
		numY();
	}

}
