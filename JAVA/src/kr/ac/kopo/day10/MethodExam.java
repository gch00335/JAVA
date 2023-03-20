package kr.ac.kopo.day10;

import java.util.Scanner;

/**
 *  연습용 간단한 메소드들을 모아놓는 클래스
 * @author User
 * 
 */

public class MethodExam {
	/** -> 이렇게 별 두개를 붙인 것을 문서화 주석이라고 함!
	 * 호출자메소드에서 받아온 두개의 정수 사이의 총합을 반환하는 메소드
	 * @param num1 첫번째 정수 총합의 시작값
	 * @param num2 두번째 정수 총합의 종료값
	 * @return num1 ~ num2 사이의 총합
	 */
	
	int getTotal(int num1 , int num2) {
		
		int total = 0 ;
		for(int i = num1 ; i <= num2 ; i ++) {
			total += 1;
			
		}
		return total;
		
	}
	
	
	/** 키도브로 단을 입력받아 반환
	 * @return  입력받은단
	 */
	
	int getDan() {
		Scanner sc = new Scanner(System.in);
		int dan = sc.nextInt();
		return dan;
		
	}
	
	
	/**
	 * 단을 이용하여 구구단을 출력
	 * @param dan 출력할 단
	 */
	public void printGugudan(int dan) {
		System.out.println("***" + dan + "단 ***");
		for(int i =1 ; i <=9; i++) {
			System.out.println(dan + " *" + i + "=" + (dan * i));
		}
	}
		
		/**
		 2~9 전체 구구단 출력
		 */
		public void printGugudan() {
			
			printGugudan(2,9);
			
//			for(int dan = 2 ; dan <=9; dan++) {
			//			/*this.*/printGugudan(dan); 
				// 원래 어떤 클래스안에 있는 메소드를 호출하려면 이렇게 this 를 써야하는데 생략되어있는 거임
				
			
			/*for(int dan = 2 ; dan <=9; dan++) {
				System.out.println("***" + dan + "단 ***");
				for(int j = 1 ; j <=9 ; j++) {
				System.out.println(dan + " *" + j + "=" + (j* dan));*/
	}

		
/**
 * 시작단 ~ 종료단 구구단 출력
 * @param startDan 시작단
 * @param endDan 종료단
 */

		public void printGugudan(int startDan, int endDan) {

			for(int dan = startDan ; dan <= endDan ; dan++) {
				printGugudan(dan);
			}
		}
}
