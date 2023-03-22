package kr.ac.kopo.day12.Homework;

import kr.ac.kopo.day10.Homework.Teacher_ScannerUtil;



public class shapeQuiz {
	Teacher_ScannerUtil scan = new Teacher_ScannerUtil();
	
	int no ;//번호 ( 모양 고르기)
	int m;  // 길이
	int m2; // 길이
	int c; //높이
	
	shapeQuiz(){}
	
	shapeQuiz(int no, int m, int c, int m2){
		
		this.no = no ;
		this.m = m;
		this.m2 = m;
		this.c = c;

	}

	void start() {

		

		System.out.println("1. 삼각형  2. 정사각형  3. 직사각형  4. 원 ");
		int cnt = scan.nextInt("면적을 구할 도형을 선택하세요");
		shapeQuiz[] sha = new shapeQuiz[cnt]; 

		triangle t = new triangle();
		square s= new square();
		circle r = new circle();


		switch(sha.length) { // 도형별 질문 나누기
		case 1 :
			int m = scan.nextInt("밑변을 입력하세요");
			int c = scan.nextInt("높이를 입력하세요");
			 t.area(m, c) ;
			break;
		case 2 :
			int m2 = scan.nextInt("한변의 길이를 입력하세요");
			s.area(m2);
			break;
		case 3 :
			int m3 = scan.nextInt("밑변을 입력하세요");
			int c2 = scan.nextInt("높이를 입력하세요");
			s.area2(m3,c2);
			break;
		case 4:
			int m4 = scan.nextInt("한변의 길이를 입력하세요");
			r.area(m4);
			break;
		
		
	
				}
		}
	}

		

	



	
	




