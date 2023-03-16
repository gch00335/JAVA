package kr.ac.kopo.day06.Homework;

public class Homework01 {

	public static void main(String[] args) {
		// 과제
		
		/*1. 다음의 결과를 보이는 프로그램을 작성하시오 (1~4)
		 * 1) 1 2 3 4 5 6 ... 99 100
		 * 2) 1 3 5 7 ..85..87 ...97 99
		 * 3) 100 98 96 ... 4 2
		 *  
	     */
		
		for (int i = 1; i <= 100; i = i + 1) {
			System.out.printf("%d ", i);
		}

		System.out.println();
		{
/* 교수님이 알려주신 방법
 *  i = i+1 보다 i+=1 로도 표현할 수 없다는 거 기억하기!
 */ 
			
			
			for (int i = 1; i <= 100; i = i + 2) {
				System.out.printf("%d ", i);
			}
			System.out.println();
			{
				for (int i = 100 ; i >=1; i = i-2) {
					System.out.printf("%d ", i);
				}
				System.out.println();
			
		}
	}
}
}
