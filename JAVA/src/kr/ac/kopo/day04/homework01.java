package kr.ac.kopo.day04;

import java.util.Scanner;

public class homework01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//문제 1번
/*반지름을 입력받아 원의 넓이과 둘레를 출력하는 코드 작성  (소수점 4째짜리 출력)
   반지름 입력 : 10
   반지름 : 10 => 원넓이 : 314.1592  원둘레  : 62.8318 */
		
		System.out.println("반지름 입력 : ");
		int r = sc.nextInt();
		final double PI = 3.141592;
		
		double area = r*r*PI;
		double length = r*2*PI;
		
		System.out.println("원넓이 : " + area);
				
		System.out.printf("원둘레 : %.4f" , length);
		
		
		
		
		

	}

}