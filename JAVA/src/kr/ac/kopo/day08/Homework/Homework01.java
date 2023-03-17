package kr.ac.kopo.day08.Homework;

import java.util.Scanner;

public class Homework01 {

	private static int j;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int ar[] = new int[10];
		int[][] primeArr = new int[10][20];

		System.out.println("정수 10개를 입력하세요 0 입력시 종료됩니다"); //

		for (int i = 0; i < primeArr.length; i++) {
			ar[i] = sc.nextInt();

			if (ar[i] == 0) {                       // 정수 10개 받기
				break;
			} 
			else {
				for (int j = 1, k = 0; j <= ar[i]; j++) {
					if (ar[i] % j == 0) {
						primeArr[i][k] = j;
						k++;
					}
				}
			}
		}
		System.out.println();
	
		for (int i = 0; i <primeArr.length; i++) {
			if (ar[i] > 0) {
				System.out.print(ar[i] + "의 약수 : ");
				for (int j = 0 ; j < primeArr[0].length; j++) {
				if (primeArr[i][j] > 0) {
					System.out.print(primeArr[i][j] + "  ");
				}
			}
			System.out.println();
		}

	}
}
}

// int [][] primeArr = new int[10][20];
// 0이 나올떄까지 정수를 입력받아 입력받은 정수의 약수들을 
// 출력하는 코드를 작성하시오
// 단, 10개의 정수가 나오면 프로그램을 종료합니다.
// 정수는 10개까지 , 20은 약수의 수를 기억하는 것
/*
 * 정수를 입력하세요 0입력시 종료
 * 45
 * 8
 * 23
 * 56
 * 16
 * 0
 * 
 * 정수45의 약수 : 1 3 5 9 15 45
 * 8의 약수 : 1 2 4 8
 * 56의 약수 : 1 2 4 7 8 14 28 56
 * 16의 약수 : 1 2 4 8 16
 * ------------
 * 정수를 입력하세요 0입력시 종료
 * 45
 * 8
 * 23
 * 56
 * 16
 * 25
 * 10
 * 11
 * 9
 * 24
 * 
 * 
 * 정수45의 약수 : 1 3 5 9 15 45
 * 8의 약수 : 1 2 4 8
 * 56의 약수 : 1 2 4 7 8 14 28 56
 * 16의 약수 : 1 2 4 8 16
 * ...
 * 24의 약수 : 1 2 3 4 6 8 12 24
 */
//int [][] primeArr = new int[10][20];