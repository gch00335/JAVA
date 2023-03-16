package kr.ac.kopo.day06.Homework;

import java.util.Scanner;

public class Homework04 {

	public static void main(String[] args) {

	 /*  
	 *  7) 시작단과 종료단을 입력받아 구구단을 출력하는 코드를 작성하시오
	 *    시작단을 입력 : 3
	 *    종료단을 입력 : 6
	 *    (단 ! 반대로 6 3을 입력해도 작은순서대로 먼저 나와야함)
	 *    
	 *    ***3단***
	 *    3*1=3
	 *    ...
	 *    ***6단***
	 *    6*1=6
	 *    

		}
	 *    
	 * *
	 *  */

		Scanner sc = new Scanner(System.in);

		System.out.println("시작단을 입력 :");
		int num = sc.nextInt();

		System.out.println("종료단을 입력 :");
		int num2 = sc.nextInt();
		
		int max = num>num2 ? num :num2;
		int min = num<num2 ? num : num2;
		

		if(max > num) {
		System.out.printf("***" + "%d" + "단" + "***" + "\n", num);
		} else if (min <= num) {
		System.out.printf("***" + "%d" + "단" + "***" + "\n", num2);
		}
		for (int i = 1 ; i <= 9 ; i++) {
			System.out.println(num + "*" + i + "=" + i * num); 
		}
		if(max > num2) {
			System.out.printf("***" + "%d" + "단" + "***" + "\n", num);
			} else if (min <= num2) {
			System.out.printf("***" + "%d" + "단" + "***" + "\n", num2);
			}
		for (int i = 1 ; i <= 9 ; i++) {
			System.out.println(num2 + "*" + i + "=" + i * num2); 
	}
	}
}

//교수님께서 알려주신 방법
/* 
* Scanner sc = new Scanner(System.in);
* System.out.println("시작단을 입력 :");
* int sDan = sc.nextInt();

System.out.println("종료단을 입력 :");
int eDan = sc.nextInt();

int start = sDan ; end = eDan;
if(start > end){
   start = eDan;
   end = sDan;
}
for (int dan = sDan ; dan <= eDan ; dan++) {
System.out.println("***" +dan + "단 ***"); 
 for(int i- 1; i<=9 ; i++):{
  System.out.printf("%d * %d =Rd\n" , dan,i, i*dan);
}
}
*/
