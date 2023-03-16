package kr.ac.kopo.day06;

public class ExamMain02 {

	public static void main(String[] args) {
		// 10번문제 (다른풀이)
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
		int star = 1;
		for (int i = 1; i <= 9; i++) {
			
			for(int j=1 ; j<=star ; j++) {
				System.out.print('*');
			}
			System.out.println();
			if( i<5 ) {
				star++;
			} else {
				star--;
				}
			}
		}
	}


