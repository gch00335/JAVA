package kr.ac.kopo.day15;

import java.util.Scanner;

public class ExceptionMain07 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("홀수를 입력 : ");
		int num = sc.nextInt();
		try {

			if (num % 2 != 1) {
				throw new OddMismatchException("입력하신 정수 [" + num + "] : 홀수가 아닙니다.");
			} // throw  : 인위적으로 특정시점에 예외를 발생시킬때 사용하는 키워드
			  // 나만의 예외처리인 키워드를 만든다는 것! *(사용자 정의)
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("num = " + num);

	}

}
