package kr.ac.kopo.day07.Homework;

import java.util.Scanner;

public class Homework03 {

	public static void main(String[] args) {
		/*

		 * 
		 * 3. 성적을 입력받아 학점을 출력하는 코드를 작성
		 * 
          90 ~ 100 : A
          80 ~ 89 : B
          70 ~ 79 : C
          60 ~ 69 : D
           0 ~ 59 : F

		 * 1'S 성적 : 92
		 * 2'S 성적 : 1000
		 * 3'S 성적 : 34
		 * 4'S 성적 : 80
		 * 5'S 성적 : 78
		 * 
		 * 
		 * <PRINT>
		 * 번호  성적   학점
		 * 1     92    A		 
		 * 2     ERROR!!
		 * 3      34   F
		 * 4     80    B
		 * 5     78    C
		 * 
		 * 5명 입력 중 [1]회 에러발생
		 * 총점 : 1284점
		 * 평균 : 56.8점 (평균 5명까지)

		
		 */
				
	// 헷갈려서 안되겠다. 주석달아가면서 정리해보자
		
	Scanner sc = new Scanner(System.in);
	System.out.println(" 성적을 입력하시오 "); // 성적입력해 ! 나오게 출력
	int[] ar = new int[5]; 

	for (int i = 0; i < ar.length; i++) { // 성적 입력하는 구간 출력
		System.out.print((i + 1) + "'S 성적 :");
		ar[i] = sc.nextInt();
	}
	System.out.println();

	System.out.println("<PRINT>");
	System.out.println("번호 " + "성적 " + "학점 " + "\n"); // 번호 성적 학점 구간 출력!

	int error = 0; // 에러 설정
	int sum = 0; // 총점 설정
	double avg = 0; // 평균 설정

	// 번호 성적 학점 출력
	/*
	 * 90 ~ 100 : A -> 9이상 10 이하 
	 * 80 ~ 89 : B -> 8이상 9 미만 
	 * 70 ~ 79 : C -> 7이상 8 미만 
	 * 60 ~ 69 : D -> 6이상 7 미만 
	 * 0 ~ 59 : F -> 0이상 6미만
	 */
	for (int i = 0; i < ar.length; i++) {
		if (ar[i] <= 0 || ar[i] >= 100) { // 일단 크게 0부터 100까지 잡고..!
			System.out.println((i + 1) + "  " + "ERROR!!" + "\t");

			error++;

			// 에러발생
		} else {
			if (ar[i] >= 90) {
				System.out.println((i + 1) + "  " + ar[i] + "  A" + "\t");

			} else if (ar[i] >= 80) {
				System.out.println((i + 1) + "  " + ar[i] + "  B" + "\t");
			} else if (ar[i] >= 70) {
				System.out.println((i + 1) + "  " + ar[i] + "  C" + "\t");
			} else if (ar[i] >= 60) {
				System.out.println((i + 1) + "  " + ar[i] + "  D" + "\t");
			} else if (ar[i] >= 0) {
				System.out.println((i + 1) + "  " + ar[i] + "  E" + "\t");
			} else {
				System.out.println((i + 1) + "  " + ar[i] + "  F" + "\t");
				// <PRINT> * 번호 성적 학점쫘르르륵
			}
		} // 5명입력 중 에러발생
		/* 총점 : 1284점
		 * 평균 : 56.8점 (평균 5명까지) 
		 */
		
	}
	for (int i = 1; i < ar.length; i++) {
		sum = sum + ar[i];
		avg = (double) sum / i;
	}
	System.out.println();
	System.out.println(ar.length + "명 입력 중[" + error + "]회 에러발생");
	System.out.println("총점 :" + sum);
	System.out.println("평균 : " + avg);
}

}     
// 교수님께서 알려주신 방법
/*
 * 
 * Scanner sc = new Scanner(System.in);
 * int[] score = new int[5]; 
 * 
 *  for (int i = 0; i < ar.length; i++) {
	System.out.printf("%d\'S score :" , i +1);
		score[i] = sc.nextInt();
	}
	int errcnt = 0;
	
	System.out.println("NO\tSCORE\t GRADE");
	for (int i = 0; i < ar.length; i++) {
	  if (ar[i] >= 0 || ar[i] <= 100) { 
	  
	   char grade;
	   
	   switch(score[i]/10){
	   case 10 "
	   case 9 :
	    grade = ' A ' break;
	    case 8 :
	    grade = ' B ' break;
	    case 7 :
	    grade = ' C ' break;
	    case 6 :
	    grade = ' D ' break;
	    default :
	    grade = 'f' ;
	    }
	   
			System.out.println((i + 1) + "\t" + score[i] + "\t" + grade);
			} else {
			System.out.println((i + 1) +  "\t" + "ERROR!!" );
            ++errnct;
}
}
    System.out.printf("5회 입력 중[%d]회 에러발생!!", errcnt);
	System.out.println("총점 :" + sum);
	System.out.println("평균 : " + avg);
	
*/

