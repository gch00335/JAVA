package kr.ac.kopo.day04;

import java.util.Scanner;

//방금처럼 [window] - [preference] -[save 검색] -[edit] -[save action 선택 ]
// - 제일 맨위 칸 p 어쩌고 클릭 하고 [ organize ] 선택 후 [applt close] 누르면 자동생성

// 혹은 [ctrl] + [shift] + [영어 o ] 누르면 자동생성 
public class ScannerMain02 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.print("첫번째 정수 : ");
		int num01 = sc.nextInt();
		
		System.out.print("두번째 정수 : ");
		int num02 = sc.nextInt();
		
		System.out.printf("%d는 %d의 배수여부 : %s",
				num01, num02, 
				num01 % num02 == 0 ? "배수다" : " 배수가 아니다");
		


	}

}
