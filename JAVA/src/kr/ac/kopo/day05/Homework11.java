package kr.ac.kopo.day05;

public class Homework11 {

	public static void main(String[] args) {
		// 11번 
		/* 
		 *****
		 ****
		 ***
		 **
		 *
		 **
		 ***
		 ****
		 *****
		 
		 */

		for(int i =1 ; i <=9 ; i++) {
			if(i<=5) {
				for(int j=1 ; j<= 6-i; j++) {
					System.out.print("*");
				} 
			} else {
				for(int j =1 ; j<= i-4;j++) {
					System.out.print("*");
				}
			}
			System.out.println();
		}
	}
}
