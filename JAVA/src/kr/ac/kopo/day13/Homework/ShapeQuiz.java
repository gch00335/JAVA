package kr.ac.kopo.day13.Homework;
import java.util.Scanner;

import kr.ac.kopo.day10.Homework.Teacher_ScannerUtil;

public class ShapeQuiz {
	private Scanner sc = new Scanner(System.in);
	Teacher_ScannerUtil scan = new Teacher_ScannerUtil();
	
	public void Start() {
		System.out.println("1. 삼각형 2.정사각형 3.직사각형 4.원");
		System.out.println("면적을 구할 도형을 선택하세요");
		int choice = sc.nextInt();
		
		
		Shape s = null;
		switch(choice) {
		case 1 : 
			s = new Triangle();
			break;
		case 2:
			s= new  Square();
			break;
		case 3 :
			s= new Rectangle();
		case 4 :
			s= new Circle();
			
		}
		if(s != null) {
			s.area();
		}
	}


		
	}

