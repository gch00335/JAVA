package kr.ac.kopo.day04;
import java.util.Scanner;

/* 
  1 -3 사이의 정수 입력 :
   1입력 => one
   2입력 => two
   3입력 => three
   
   아닐 경우 에러 뜨게 할 것
   
 */
public class SwitchMain01 {

	public static void main(String[] args) {
	
		 Scanner sc = new Scanner(System.in);
		 
		 System.out.print("1 - 3 사이의 정수 : ");
		 int no = sc.nextInt();
		 
		 switch(no) { // swich에서 case는 책갈피같은 것임. 
		 // break문이 없을 경우 모든 문장을 다실행함 / break => [분기문]
		 case 1 :
			 System.out.println("ONE");
			 break;
		 case 2 :
			 System.out.println("TWO");
			 break;
		 case 3 : 
			 System.out.println("THREE");
			 break;
			 
	     default :
	    	 System.out.println("ERROR");
		 }
		 
		 /*
		 if(no == 1) {
			 System.out.println("ONE");
		 } else if(no ==2)  {
			 System.out.println("TWO");
		 } else if (no ==3) {
			 System.out.println("THREE");
		 } else {
			 System.out.println("ERROR");
				 
			 }
		 }
	}
*/
		 
}
}
