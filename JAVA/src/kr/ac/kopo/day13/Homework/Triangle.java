package kr.ac.kopo.day13.Homework;

import kr.ac.kopo.day10.Homework.Teacher_ScannerUtil;

public class Triangle extends Shape {

	private String model;
	private int m; // 밑변
	private int c; // 높이

	Teacher_ScannerUtil scan = new Teacher_ScannerUtil();

	public Triangle() {

		model = "삼각형";
	}

	public void trianglearea() {
		int m = scan.nextInt("밑변을 입력하세요");
		int c = scan.nextInt("높이를 입력하세요");
		System.out.println("가로" + m + "세로" + c + model + "넓이는" + 0.5 * m * c + "입니다");
	}

	public void area() {
		trianglearea();
	}

}
