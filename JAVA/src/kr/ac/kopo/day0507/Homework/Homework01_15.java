package kr.ac.kopo.day0507.Homework;
import java.util.Scanner;

public class Homework01_15 {

	public static void main(String[] args) {
		//   숫자 입력했을 때 이모양이 계속나오도록 재설정해보기
		/* 15번
		 * *********
		   _*******
		   __*****
		   ___***
		   ____*
          
		   
		   */

		Scanner sc = new Scanner(System.in);
		System.out.println("숫자 하나를 입력하시오");

		int num = sc.nextInt();

		for (int i = 1; i <= num; i++) {
			for (int j = 1; j <= i -1  ; j++) {
				System.out.print(" ");
			}
			for (int j = i-2 ; j <= 2*num-(i+num)+1; j++) {
							System.out.print("*");
				}
			System.out.println();
			}
			
		}
	// 교수님.. 왜 계속 입력한 수보다 +2가 될까요...
	// 원하는 모양대로는 나오는데 수가 제가 원하는대로 나오질 않아요..
	// 원인을 못찾겠습니다ㅠㅠ......
	}



