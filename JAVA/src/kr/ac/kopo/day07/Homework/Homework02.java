package kr.ac.kopo.day07.Homework;
import java.util.Scanner;

public class Homework02 {

	public static void main(String[] args) {
		/*
		 * 
		 * 
		 * 
		 * 2. 0 ~99사이의 정수를 5개 입력받아 다음과 같이 출력하는 코드를 작성 
	num1 : 57
    num2 : 10
    num3 : 984
    num3 : 92
    num4 : 9
    num5 : -34
    num5 : 932
    num5 : 2312
    num5 : 36
		 * < PRINT > 
		 * 57 10 92 9 36
		 * 
		 * < REVERSE > 
		 * 63 90 29 1 75
		 * 
		 */
		Scanner sc = new Scanner(System.in);
		System.out.println("정수의 5개를 입력하시오");
		int[] ar = new int[5];
		
		int i = 0;
		while(i<ar.length) {
			System.out.print("num"+(i+1)+" : ");
			ar[i] = sc.nextInt();
			if(0<=ar[i] && ar[i]<=99) {
				i++;
			}
		}
		System.out.println();
		

		System.out.println("<PRINT>");
		for (int j = 0; j < ar.length; j++) {
			System.out.print(ar[j] + "\t");
		}
		System.out.println();
		System.out.println("<REVERSE>");

		for (int j = ar.length-1; 0 <= j; --j) {

			int k = ar[j] / 10;
			int n = ar[j] % 10;

			System.out.printf("%d" + "%d" + "\t", n, k);
		}
	}
} 
		// 교수님께서 알려주신 방법
/* [방법1]
 * Scanner sc = new Scanner(System.in);
		System.out.println("정수의 5개를 입력하시오");
		int[] nums = new int[5];
		
		for (int i = 0; i < nums.length; i++) {
		 do{ 
			System.out.printf("num%d,i+1);
			nums[i] = sc.nextInt();
			} while(nums[i] < 0 || nums[i] > 99);
			}
			
		System.out.println("<PRINT>");
		for(int num : nums){
		  System.out.print(num + "\t");
		  }
		  System.out.println();
		  System.out.println("<REVERSE>");
		  for(int i = nums.length-1; 0 <= i; --i) {
		  
		    int n10 = nums[j] / 10;
			int n1 =  nums[j] % 10;
		  
		  System.out.printf(n1*10 + n10 + "\t");
	}
	System.out.println();
	}
	}
	}
		
		
		
		
		
		
		
		
		
		
 * [ 방법 2] 
 *     Scanner sc = new Scanner(System.in);
		System.out.println("정수의 5개를 입력하시오");
		int[] nums = new int[5];
 * 
 *     for (int i = 0; i < nums.length; i++) {
 *     System.out.printf("num%d,i+1);
			nums[i] = sc.nextInt();
			if(nums[i] >=0 && nums[i]] <= 99){ // nums[i] <0 || nums>100 으로 할 경우 상관없는 정수값의 오류가 날 수 있기에
		    i++;                                    교집합의 형태인 nums[i] >=0 && nums[i]] <= 99 으로 써줘야 함
			}                                      그리고 보통적으로 변수는 왼쪽에 쓰는 걸 선호함!
 *  }
 * 
 * System.out.println("<PRINT>");
		for(int num : nums){
		  System.out.print(num + "\t");
		  }
		  System.out.println();
		  System.out.println("<REVERSE>");
		  for(int i = nums.length-1; 0 <= i; --i) {
		  
		    int n10 = nums[j] / 10;
			int n1 =  nums[j] % 10;
		  
		  System.out.printf(n1*10 + n10 + "\t");
	}
	System.out.println();
	}
	}
	}
		
		
 *
 *
 * [ 방법 3 ]
 * 
 *  Scanner sc = new Scanner(System.in);
		System.out.println("정수의 5개를 입력하시오");
		int[] nums = new int[5];
 *
 *         int i= 1
 *         while(true){
 *         System.out.printf("num%d,i+1);
 *           nums[i] = sc.nextInt();
 *            if(nums[i] >=0 && nums[i]] <= 99)
 *           i++;  
 *            if(i ==nums,lengrh){
 *               break;
 *         }
 *     System.out.println();
		  System.out.println("<REVERSE>");
		  for(int i = nums.length-1; 0 <= i; --i) {
		  
		    int n10 = nums[j] / 10;
			int n1 =  nums[j] % 10;
		  
		  System.out.printf(n1*10 + n10 + "\t");
	}
	System.out.println();
	}
	}
	}
		
		
 */
