package kr.ac.kopo.day04;

import java.util.Scanner;
/*
 보유하고 있는 책권수 입력 : 3
 3books
 보유하고 있는 책권수 입력 :1
 1 book
 보유하고 있는 책권수 입력 : 0
 보유하고 있는 책 없음
 
 */
// 이렇게 여러개의 조건이 있을 경우 제일 작은 수 혹은 제일 큰 수에서 시작해야함!
public class IFmain02 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("보유하고 있는 책권 수 입력 : ");
		int book = sc.nextInt();
		//이러한 모양을 [중청됩 if else 문] 이라고 함
		if(book == 0) {
			System.out.println("보유하고 있는 책 없음");
		} else {
			if(book ==1) {
				System.out.println( book + "book");
			} else {
				System.out.println(book + "books");
			}
			
			// 'tab' 중요 / 마지막 else 꼭 신경쓰기 
		}
	}

}
