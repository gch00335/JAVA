package kr.ac.kopo.day13.Homework;

import kr.ac.kopo.day10.Homework.Teacher_ScannerUtil;

public class Rectangle extends Shape  {

		private String model ;
		private int m ; // 가로
		private int c ; // 세로

		Teacher_ScannerUtil scan = new Teacher_ScannerUtil();

		public Rectangle() {

			model = "직사각형";
		}

		public void rectanglearea() {
			int m = scan.nextInt("밑변을 입력하세요");
			int c = scan.nextInt("높이를 입력하세요");
			System.out.println("가로"+ m + "세로"+ c + model+ "넓이는"+ m*c + "입니다");
		}
		public void area() {
			rectanglearea();
		}


	}



