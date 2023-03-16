package kr.ac.kopo.day06;

public class ExamMain01 {

	public static void main(String[] args) {
		// 12번
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
        //방법 1
		for (int i = 1; i <= 9; i++) {
			if (i <= 5) {
				for (int j = 1; j <= 5; j++) {
					System.out.printf("%c", j >= i ? '*' : ' ');
				}
			} else {
				for(int j = 1 ; j <= 5 ; j++) {
					if (j < 10 - i) {
						System.out.print(' ');
					} else {
						System.out.print('*');
					}
				}
				
			}
			System.out.println();
		}
	}
}

/*
 * 방법2 for (int i = 1; i <= 9; i++) { if (i <= 5) { for (int j = 1; j <= i - 1;
 * j++) { System.out.print(" "); } for (int j = 1; j <= 6 - i; j++) {
 * System.out.print("*"); } } else { for (int j = 1; j <= 9 - i; j++) {
 * System.out.print(" "); } for (int j = 1; j <= i - 4; j++) {
 * System.out.print("*");} } System.out.println(); } } }
 */

