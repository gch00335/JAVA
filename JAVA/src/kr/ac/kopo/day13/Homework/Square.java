package kr.ac.kopo.day13.Homework;

import kr.ac.kopo.day10.Homework.Teacher_ScannerUtil;

public class Square extends Shape {
	private String model ;
	private int m ; // 한변의 길이

	Teacher_ScannerUtil scan = new Teacher_ScannerUtil();


	public Square() {
		model = "정사각형";
	
	}
	public void Squarearea() {
		int m = scan.nextInt("한변의 길이를 입력하세요");
		System.out.println("한변의 길이가"+ m + model+ "넓이는"+ m*m + "입니다");
	}
	
	public void area() {
		 Squarearea();
	}


}

