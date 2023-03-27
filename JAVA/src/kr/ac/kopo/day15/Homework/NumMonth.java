package kr.ac.kopo.day15.Homework;

import java.util.Calendar;

import kr.ac.kopo.day10.Homework.Teacher_ScannerUtil;

public class NumMonth extends NumYear {
	Teacher_ScannerUtil scan = new Teacher_ScannerUtil();
	Calendar c = Calendar.getInstance();


	private int date = c.get(Calendar.MONTH) - 2;

	public NumMonth() {

	}

	public void numM() {
		
		date = c.get(Calendar.MONTH) - 2;
		
		int pattern = date++;

		System.out.println();
		for (int k = 0; k < 7; k++) {
			pattern++;
			System.out.print("  " + pattern);
		}
		System.out.println();
		for (int j = 7; j < 14; j++) {
			pattern++;
			System.out.print(" " + pattern);

		}
		System.out.println();
		for (int j = 14; j < 21; j++) {
			pattern++;
			System.out.print(" " + pattern);
		}
		System.out.println();
		for (int j = 21; j < 28; j++) {
			pattern++;
			System.out.print(" " + pattern);
		}
		System.out.println();
		for (int j = 28; j < 31; j++) {
			pattern++;
			System.out.print(" " + pattern);
		}
		System.out.println();
	}
}
