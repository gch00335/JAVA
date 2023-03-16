package kr.ac.kopo.day05.Homework;

import java.util.Scanner;

public class HomeworkMain03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("보유하고 있는 책권 수 입력 : ");
		int book = sc.nextInt();
		
		switch(book) {
		case 0 :
			System.out.println("보유하고 있는 책 없습니다");
			break;
		case 1 :
			System.out.println(book + "book");
			break;
			default :
				switch(book & 0x80000000) {
				case 0 :
					System.out.println(book + "book");
				break;	
			default :
					System.out.println("잘못입력했습니다");
				}
		}
		
		
		/*방법1 : if문
		if(book < 0 ) {
			System.out.println("잘못 입력했습니다");
		} else if ( book ==0 ) {
			System.out.println("보유하고 있는 책 없습니다");
		} else if(book ==1) {
			System.out.println(book + " book");
		} else {
			System.out.println(book + "books");
		} */
	}

}
