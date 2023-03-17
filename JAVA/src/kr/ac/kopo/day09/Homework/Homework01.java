package kr.ac.kopo.day09.Homework;

import java.util.Random;
import java.util.Scanner;

public class Homework01 {

	public static void main(String[] args) {

		System.out.println("컴퓨터가 생각하고 있는 1 ~ 100사이의 정수를 맞추시오");

		Random r = new Random(); // 컴퓨터가 랜덤으로 숫자 만드는 코드 입력
		int random = r.nextInt(100)+1;
		System.out.println(random);

		Scanner sc = new Scanner(System.in); // 내가 숫자 입력하는 스캐너 입력
		int k = 5; // 기회

		
		int min =1 , max = 100;

		
		for(int i= 1 ; i <= k ; i++) {
			int num = sc.nextInt();
			
			if(random == num) {  //정답일때 브레이크!
				System.out.println("축하합니다 . 정답입니다.");
				break;
			}else if(num < random) { //정답보다 작을 때!
					System.out.println( min + "~"+ max);
					System.out.println(num + "보다 큰 수입니다"); 	// 00보다 큰 수입니다 나오게 하기
					System.out.println("기회는 총 [" + (5-i) + "] 남았습니다."); // 기회는 총 [] 남았습니다 나오게 하기
					min = num + 1;
					
			}else if(num > random) { //정답보다 클 때 !
				System.out.println( min + "~"+ max);
				System.out.println(num + "보다 작은 수입니다");	// 00보다 작은 수입니다 나오게 하기
				System.out.println("기회는 총 [" + (5-i) + "] 남았습니다.");
				max = num - 1 ;
			
			}
			if(5-i == 0) { // 마지막에 아쉽습니다 기회를 소진하셨습니다 나오게 하기
				System.out.println("아쉽습니다. 기회를 소진하셨습니다." +"\n"+"정답은 [ "+random+"]입니다");
			break;
			}
		}
	}
	}
 

// 1. 컴퓨터가 생각하고 있는 1 ~ 100사이의 정수를 맞추는 프로그램을 작성하시오
/*
 * 1 ~100 : 50
 * 50보다 큰수입니다.
 * 
 * 기회는 총 5번 남았습니다.
 * 
 * 51-100: 70
 * 70보다 작은 수입니다.
 * 
 * 51-69:77
 * 51-69 : 63
 * 63보다 작은수입니다.
 * 기회는 총 3번 남았습니다.
 * 
 * 51-62 : 55
 * 55보다 큰 수입니다.
 * 기회는 총 2번남았습니다.
 * 
 * 56-62:59
 * 59보다 큰수입니다.
 * 기회는 총 1번 남았습니다.
 * 
 * 60-61:60
 *  옵션 ) 기회는 총 0번 남았습니다. 라고 써도 됨..
 * 아쉽습니다. 기회를 소진하셨습니다.
 * 정답은 [61]입니다.
 * 
 * ----만약
 * 60 -61 : 61
 * 축하합니다. 정답입니다.
 */


	


