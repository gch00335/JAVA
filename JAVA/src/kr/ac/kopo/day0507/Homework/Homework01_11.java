package kr.ac.kopo.day0507.Homework;
import java.util.Scanner;

public class Homework01_11 {

	public static void main(String[] args) {
		// 11번  숫자하나를 입력했을 때 이모양이 계속나오도록 재설정해보기
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

		Scanner sc = new Scanner(System.in);
		System.out.println("숫자 하나를 입력하시오");

		int num = sc.nextInt();
 
		// 행으로도 생각해보기 //
		// 짝수 홀수 바꿔보기 
		
		/*먼저 2로 나눈다음 
		큰수에서 거기서 짝수 홀수를 나누고 
		거기수 짝수는 -1
		작은수에서고 짝수-1 홀수 는 그대로 */
		
			for (int i = 1; i <= num; i++) {
				for (int j = 1; j <=  10- i ; j++) {
					System.out.print("*");
				}
				for (int j = 1; j <= i-1; j++) {
					System.out.print(" ");
				}
				System.out.println();

			}
			for (int i = 1; i <= num; i++) {
				for (int j = 1; j <=  10- i ; j++) {
					System.out.print(" ");
				}
				for (int j = 1; j <= i-1; j++) {
					System.out.print("*");
				}
				System.out.println();
		}
	}
}

/*
 * 
				Scanner sc = new Scanner(System.in);
				System.out.println("숫자 하나를 입력하시오");

				int num = sc.nextInt();

				for (int i = 1; i <= num; i++) {
					for (int j = 1; j <= (5 + num) - i; j++) {
						System.out.print(" ");
					}
					for (int j = 1; j <= i; j++) {
						System.out.print("*");
					}
					System.out.println();
				}
			}

		}

 */
