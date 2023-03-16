package kr.ac.kopo.day06;

public class ExamMain07 {

	public static void main(String[] args) {
		/*
		 17번
		 *_______* 
		 **_____**
		 ***___***
		 ****_**** 
		 ********* 
		 ****_**** 
		 ***___***
		 **_____**
		 *_______*
		
		 */
	
		int k= 0 ;
		for (int i = 1; i <= 9; i++) {

			for (int j = 1; j <= k; j++) {
				System.out.print("*");
			}
			for (int j = 1; j <= 9 - k - k; j++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= k; j++) {
				System.out.print("*");
			}
			
			if(i < 5) {
				k++;
			} else {
				k--;
			}
			
			System.out.println();
		}
	}
		
		
	}


