package kr.ac.kopo.day13.Homework;

import kr.ac.kopo.day10.Homework.Teacher_ScannerUtil;

public class Circle extends Shape {
	
	private String model ;
	private int m ; //반지름
	Teacher_ScannerUtil scan = new Teacher_ScannerUtil();
	
	public Circle() {
	model = "원";
	}
	public void cireclarea() {
		int m = scan.nextInt("반지름의 길이를 입력하세요");
		System.out.println("반지름이"+ m + "인" + model+ "넓이는"+ m*m +"입니다");
	}
	public void area() {
		cireclarea();
	}

}
