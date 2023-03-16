package kr.ac.kopo.day07.Homework;
import java.util.Scanner;
public class Homework01 {

	public static void main(String[] args) {
		/*
		 * 1. 10개의 정수를 입력받아 다음과 같이 출력하시오
   num1 : 45
   num2 : 10
   num3 : 22
   num4 : 62
   num5 : 2
   num6 : 23
   num7 : 76
   num8 : 65
   num9 : 3
   num10 : 22
   
  < 짝수 >
  10  22  62  2  76  22
  < 홀수 >
  45  23  65  3
  
		 */
		Scanner sc = new Scanner(System.in);
		
		
		
		System.out.println("10개의 정수를 입력받아 다음과 같이 출력하시오");	
		int[] ar = new int[10];

		for (int i = 1; i < ar.length; i++) {
			System.out.print("num" + i + ":");
			ar[i] = sc.nextInt();
		}
		System.out.println("<짝수>");

		for (int i = 0; i < ar.length; i++) {
			if (ar[i] % 2 == 0) {
				System.out.print(ar[i] + "\t");
			}
		}
		System.out.println();
		System.out.println("<홀수>");
		for (int i = 0; i < ar.length; i++) {
			if (ar[i] % 2 == 1) {
				System.out.print(ar[i] + "\t");
			}
		} 
		}
	}

// 교수님께서 알려주신 방법
/* [ 방법1 ]
*    System.out.println("10개의 정수를 입력받아 다음과 같이 출력하시오");	
		int[] nums  = new int[10];  // num[0] ~ [9] 까지
		
		for (int i = 0; i < num.length; i++) {
			System.out.print("num" + ( i +1 )+ ":");
			nums[i] = sc.nextInt();
		}
		 System.out.println("<짝수>");

		for (int i = 0; i < nums.length; i++) {
			if (ar[i] % 2 == 0) {
				System.out.print(nums[i] + "\t");
			}
		}	
            System.out.println();
            System.out.println("<홀수>");
            for (int num : nums) {   // 1.5버전의 for문을 이용 한것임! //
	         if (num % 2 == 1) {
		        System.out.print(num + "  ");
	}
} 
}
}

[ 방법2 ]


  System.out.println("10개의 정수를 입력받아 다음과 같이 출력하시오");	
		int[] nums  = new int[10];  //
		
		for (int i = 0; i < num.length; i++) {
			System.out.print("num" + ( i +1 )+ ":");
			nums[i] = sc.nextInt();
		}
		 for(int mod = 0; mod <2 ; mod ++){
            System.out.printf("<< %s >>\n", mod==0 ? "짝수" : "홀수");
              for (int num : nums) { 
	               if (num % 2 == mod) {
	                System.out.print(num + "  ");
                }
              }
           System.out.println();
          }

[ 방법3 ]
 System.out.println("10개의 정수를 입력받아 다음과 같이 출력하시오");	
		int[] nums  = new int[10];  //
		
		for (int i = 0; i < num.length; i++) {
			System.out.print("num" + ( i +1 )+ ":");
			nums[i] = sc.nextInt();
		}
		 
		 char [] titles = { '짝', '홀' };
		 
		 for(int mod = 0; mod <2 ; mod ++){
            System.out.printf("<< %c 수 >>\n", titles[mod]);
              for (int num : nums) { 
	               if (num % 2 == mod) {
	                System.out.print(num + "  ");
                }
              }
           System.out.println();
          }

[ 방법4 ]
System.out.println("10개의 정수를 입력받아 다음과 같이 출력하시오");	
		int[] nums  = new int[10];  
		
		for (int i = 0; i < num.length; i++) {
			System.out.print("num" + ( i +1 )+ ":");
			nums[i] = sc.nextInt();
		}
		 String[] msg = { "짝수' , "홀수" }; // 글자니까 'string'으로 배열 만들어줌  // 참조자료형 형태
		 char [] titles = { '짝', '홀 };
		 
		 for(int mod = 0; mod <2 ; mod ++){
           System.out.printf("<< %s >>\n", msg[mod]);  // 만들어둔 배열을 이용해 가져오기
             for (int num : nums) { 
	               if (num % 2 == mod) {
	                System.out.print(num + "  ");
               }
             }
          System.out.println();
         }

*/
