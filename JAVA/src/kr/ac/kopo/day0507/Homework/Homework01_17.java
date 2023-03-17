package kr.ac.kopo.day0507.Homework;

import java.util.Scanner;

public class Homework01_17 {
//  숫자 입력했을 때 이모양이 계속나오도록 재설정해보기
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

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("숫자 하나를 입력하시오");

		int num = sc.nextInt();

		int k = 0;
		for (int i = 1; i <= num; i++) {

			for (int j = 1; j <= k + 1; j++) {
				System.out.print("*");
			}
			for (int j = 1; j <= (num) - k - k; j++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= k + 1; j++) {
				System.out.print("*");
			}

			if (i < num - i) {
				k++;
			} else {
				k--;
			}

			System.out.println();
		}
	}

}


