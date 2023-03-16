package kr.ac.kopo.day06.Homework;

import java.util.Scanner;

public class Homework03 {

	public static void main(String[] args) {
		/*  * 5) 2~9사이의 단을 입력받아 구구단을 출력하는 코드를 작성하시오
		 *
		 *    2-9사이의 단을 입력 : 6
		 *     *** 6단 ***
		 *      6*1=6
		 *      6*2=12
		 *      6*3=18
		 *      ...
		 *      6*9=54 */
		// num 내가 입력한 수 / num1 2~9까지 곱셈 / k는 곱해야 하는 수
		Scanner sc = new Scanner(System.in);
		
		System.out.println(" 2-9 사이의 단을 입력 :" );
		
		int num = sc.nextInt();
		System.out.printf("***"+"%d"+"단"+ "***"+"\n",num);
		
		for(int i = 1 ; i <= 9 ; i++) {
					System.out.println(num +"*"+ i +"="+ i*num);
			}
		}
			
	}
// 교수님께서 알려주신 방법
/* 
 * Scanner sc = new Scanner(System.in);
		
	System.out.println(" 2-9 사이의 단을 입력 :" );
 *  int dan = sc.nextInt();
 * 
 * System.out.println("***"+"dan +"단"+ "***");
 * for(int i = 1 ; i <= 9 ; i++) {
					System.out.println(dan+"*"+ i +"="+ i*dan);
			}
		}
 * 
 * 
 * 
 * [방법2]
 * 
 * for(int dan = 2 ; dan <= 9 ; dan++) {
 * System.out.println("***"+"dan +"단"+ "***");
 *  for(int i = 1 ; i <= 9 ; i++) {
					System.out.printf("%d * %d =Rd\n" , dan,i, i*dan);
			}
		}
  		
		
		
*/