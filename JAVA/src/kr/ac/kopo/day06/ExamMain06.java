package kr.ac.kopo.day06;

public class ExamMain06 {

	public static void main(String[] args) {
		/*
		 16번
		 *********
		 _******* 
		 __*****
		 ___*** 
		 ____* 
		 ___*** 
		 __***** 
		 _*******
		 *********
		 */
// 규칙 " " : i-1 / 규칙 " *" :  2(6-i)-1 // 홀수이면 2n-1 짝수면 2n 을 대입할 것

    
	
		int k= 0 ;
		for (int i = 1; i <= 9; i++) {

			for (int j = 1; j <= k; j++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= 9 - k - k; j++) {
				System.out.print("*");
			}
			for (int j = 1; j <= k; j++) {
				System.out.print(" ");
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
		
		
				
	/*
     * 방법4
		int k = 0 ;
		for(int i = 1; i <= 9; i++) {
			
			for(int j=1 ; j<=9 ; j++) {
				if(j <= k || j >= 10 - k) {
					System.out.print(" ");
				} else {
					System.out.print("*");
				}
			}
			System.out.println();
			if(i < 5) {
				k++;
			} else {
				k--;
			}
		}
	}
} */

		/*
	//방법3	
		int k = 5 ;
		for (int i = 1; i <= 9; i++) {
			for(int j=1 ; j<=5-k ; j++) {
				System.out.print(" ");
			}
			for(int j =1 ; j <= 2*k-1; j++) {
				System.out.print("*");
				}
			System.out.println();
		}
	}
}
*/
		
		/*
		// 방법2
		int space = 0 , star = 9 ;
		for (int i = 1; i <= 9; i++) {
			for(int j =1 ; j<= space ; j++) {
				System.out.print(" ");
			}
			for(int j =1 ; j <= star ; j++) {
			System.out.print("*");
			}
			System.out.println();
			if(i<5) {
				space++;
				star-= 2;
			} else {
				space--;
				star+=2;
			}
		}
	} */

		
		
		
		
		
		/* 방법1
		for (int i = 1; i <= 9; i++) {
			if (i <= 5) {
				for (int j = 1; j <= i - 1; j++) {
					System.out.print(" ");
				}
				for (int j = 1; j <= 11 - 2 * i; j++) {
					System.out.print("*");
				}
			} else {
				for (int j = 1; j <= 9 - i; j++) {
					System.out.print(" ");
				}
				for (int j = 1; j <= 2* (i - 4); j++) {
					System.out.print("*");
				}
			}
			System.out.println();
		}
	}
}*/