package kr.ac.kopo.day04;
import java.util.Scanner;

public class homework04 {

	public static void main(String[] args) {
// 문제4		
/* 4개의 정수를 입력받아 가장 큰수를 출력하는 코드 작성

  4개의 정수 입력 : 23 8 567 34
  가장 큰수 : 567 */

		 Scanner sc = new Scanner(System.in);
		 System.out.println("4개의 정수 중 가장 큰 값 출력하기");
		 System.out.println("첫번째  :");
		    int a = sc.nextInt();
		    
		    System.out.println("두번째  :");
		    int b = sc.nextInt();
		    
		    System.out.println("세번째  :");
		    int c = sc.nextInt();
		    
		    System.out.println("네번째  :");
		    int d = sc.nextInt();
		 
		    if(a>b) {
		    	if(a>c) {
		    		if(a>d) {
		    			System.out.println(a);
		    		} else {
						if(a>d) {
							System.out.println(d);
						} 
		    		} 
		    	} else {
							System.out.println(c);
						} 
		    }else {
			   System.out.println(b);
			}
	}
}