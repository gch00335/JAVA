package kr.ac.kopo.day05;

public class Homework05 {

	public static void main(String[] args) {
		// 5번문제
	/* 
	 56789
	 45678
	 34567
	 23456
	 12345
	 
	 */

		for(int i=5; i>=1 ; i--) {
			for(int j = i ; j<= 4+i ; j++) {
				System.out.print(j);
			}
		 System.out.println();
	}
	}
}
