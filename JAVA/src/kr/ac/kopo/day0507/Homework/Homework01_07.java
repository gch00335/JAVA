package kr.ac.kopo.day0507.Homework;
import java.util.Scanner;

public class Homework01_07 {

	public static void main(String[] args) {
		// 7번문제에서 숫자하나를 입력했을 때 이모양이 계속나오도록 재설정해보기
		/*
		 
		 *****
		 ****
		 ***
		 **
		 *
		 */

				Scanner sc = new Scanner(System.in);
				System.out.println("숫자 하나를 입력하시오");

				int num = sc.nextInt();


				for(int i =1 ; i<=num ; i++) {
					for(int j=4 ; j>=i-1 ; j--) {
						System.out.print("*");
					}
					System.out.println();
				}

		}
}
/*
for(int i =1 ; i<=5; i++) {
for(int j=4 ; j>=i-1 ; j--) {
	System.out.print("*");
}
System.out.println();
}
}

}
*/