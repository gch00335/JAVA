package kr.ac.kopo.day06;

public class ExamMain03 {

	public static void main(String[] args) {
		// 12번 (다른풀이)
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

		int space = 0, star =5 ;
		for (int i = 1; i <= 9; i++){
		
		for(int j=1; j<=space ; j++) {
			System.out.print(" ");
			}
		for(int j=1; j<= star; j++) {
			System.out.print("*");
		}
			System.out.println();
			if(i<5) {
				space++;
				star--;
			} else {
				space--;
				star++;
			}
		}
	}
}

// 방법 4
/*
 int space = 0, star =5 ;
		for (int i = 1; i <= 9; i++){
		
		for(int j=1; j<=space ; j++) {
			System.out.print(" ");
			}
		for(int j=1; j<= star; j++) {
			System.out.print("*");
		}
			System.out.println();
			if(i<5) {
				star--;
			} else {
				
				star++;
			}
		}
	}
}
*/ // 별의수에 따라 스페이스가 달라지므로 굳이 스페이스를 정의할 필요가 없음!
