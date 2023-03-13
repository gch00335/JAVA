package kr.ac.kopo.day05;

public class Homework10 {

	public static void main(String[] args) {
		// 10번문제
	/* 
	 *
	 **
	 ***
	 ****
	 *****
	 ****
	 ***
	 **
	 **
	 */
		
		for(int i=1 ; i<=9 ; i++) {
			if(i<=5) {
				for(int j =1 ; j<= i ; j++) {
					System.out.print("*");
				}
				
			} else {
				for(int j=1 ; j<=10-i ; j++) {
			 System.out.print("*");
				}
			}
			System.out.println();
			}
		}	
}
	
