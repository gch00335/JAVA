package kr.ac.kopo.day05;

public class Homework04 {

	public static void main(String[] args) {
		// 4번문제
	/* 
	 12345
	 23456
	 34567
	 45678
	 56789
	 */ 
		//방법2
		for(int i= 1; i<=5 ; i++) {
			for(int j= i; j<=i+4 ; j++) {
				System.out.print(j);
			}
		System.out.println();
		
		
		
		
		
/*방법1
		for(int i= 1; i<=5 ; i++) {
			for(int j =1 ; j<=5 ; j++) {
				System.out.print(i+j-1);
			}
			System.out.println(); */
		}
	}

}
