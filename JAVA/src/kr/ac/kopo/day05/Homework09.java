package kr.ac.kopo.day05;

public class Homework09 {

	public static void main(String[] args) {
		// 9번문제
	/*
	      *
	     **
	    ***
	   ****
	  *****
	 
	 */

		for(int i=1; i<=5 ; i++) {
			for (int j= 1; j<=6-i ; j++) {
				System.out.print(" ");
			}
				for(int j= 1 ; j<=i ; j++) {
					System.out.print("*");
				}
				System.out.println();
			}
		}
}
