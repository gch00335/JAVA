package kr.ac.kopo.day10.Homework;
import java.util.Scanner;
public class CalculatorMain {

	public static void main(String[] args) {
		// 11. 사칙연산을 수행하는 Calculator 클래스 작성
/*
 * 정수 : 12
 정수 : 5
 12 + 5 = 17
 12 - 5 = 7
 12 * 5 = 60
 12 / 5 = 2.4
 12 소수체크 : false
 5 소수체크 : true

 */

		Scanner sc = new Scanner(System.in);
		
		System.out.println("정수 :" );
		int num1 = sc.nextInt();
		
		System.out.println("정수 :" );
		int num2 = sc.nextInt();
		
		 Calculator cal = new  Calculator(num1,num2);
		 
		 cal.sum();
		 cal.imsub();
		 cal.product( );
		 cal.mod( );
		 cal.sosu();
	

		 }
		 
	}




