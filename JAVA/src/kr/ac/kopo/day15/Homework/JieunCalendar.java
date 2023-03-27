package kr.ac.kopo.day15.Homework;

import java.util.Scanner;

// 교수님..분명..캘린더 수업 정말 재미있었는데...이해했다고 생각했는데..
// 왜 하나도 응용을 하지 못할까요..복습 더 열심히 해오겠습니다...
// 만년캘린더로나마..만들었습니다........


public class JieunCalendar {

	public void Start() {

		Scanner sc = new Scanner(System.in);
		System.out.println("원하는 항목을 선택하세요(1.특정년도  2.특정월  3. 종료) ");
		int choice = sc.nextInt();

		num n = null;
		switch (choice) {
		case 1:
			n = new NumYear();
			break;

		case 2:
			n = new OneMonth();
			break;

		case 3:
			System.out.println("종료됩니다.");
			break;

		}
		if (n != null) {
			n.balance();

		}
	}

}

/* 다음의 결과를 보이는 달력프로그램을 작성하시오

원하는 항목을 선택하세요(1.특정년도  2.특정월  3. 종료) => 1
년도를 선택하세요 : 2023

2023년 1월
일  월  화  수  목  금  토
1   2  3   4  5   6  7
8   9  
2023년 2월
일  월  화  수  목  금  토
       1  2   3   4
5   6  7   8
2023년 3월
일  월  화  수  목  금  토
       1  2   3   4
5   6  7   8
...
2023년 12월

원하는 항목을 선택하세요(1.특정년도  2.특정월  3. 종료) => 2
년도를 입력하세요 : 2023
월을 입력하세요 : 11

2023년 11월
일  월  화  수  목  금  토
       1  2   3  4
5   6  7   8  9  10 11

원하는 항목을 선택하세요(1.특정년도  2.특정월  3. 종료) => 3
*/
//원하는 항목을 선택하세요(1.특정년도  2.특정월  3. 종료) => 1
