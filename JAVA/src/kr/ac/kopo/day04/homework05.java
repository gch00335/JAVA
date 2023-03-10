package kr.ac.kopo.day04;
import java.util.Scanner;

public class homework05 {

	public static void main(String[] args) {
//문제5
/* 보유하고 있는 책권수 :1 
  1 book
  
  보유하고 있는 책권수 : 3
  3books
  
  보유하고 있는 책권수 : -3
  잘못입력하였습니다.
 */

		Scanner sc = new Scanner(System.in);
		System.out.println("보유하고 있는 책권의 수 :");
		int book = sc.nextInt();
		
		if(book == 0) {
			System.out.println("보유하고 있는 책 없음");
		} else {
			if(book ==1) {
				System.out.println( book + "book");
			} else
				if(book >1) {
				System.out.println(book + "books");
			} else {
				System.out.println("잘 못 입력했습니다.");
				
			}
		
		
		switch(book){
			case 0 :
				System.out.println("보유하고 있는 책 없다");
				break ;
			case 1 :
				System.out.println("1 book");
				break ;
			
	
			default :
			System.out.println(book > 0? book + "books" : "잘못입력하였습니다.");
					
		}
	}
	
	}
}
