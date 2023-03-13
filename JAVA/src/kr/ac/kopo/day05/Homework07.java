package kr.ac.kopo.day05;

public class Homework07 {

	public static void main(String[] args) {
		// 7번문제
	/*
	 
	 *****
	 ****
	 ***
	 **
	 *
	 */

		for(int i =1 ; i<=5; i++) {
			for(int j=4 ; j>=i-1 ; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
}

