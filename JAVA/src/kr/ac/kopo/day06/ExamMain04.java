package kr.ac.kopo.day06;

public class ExamMain04 {
/* 14번
  ____*
  ___***
  __*****
  _*******
  *********
 */
	public static void main(String[] args) {
	
		for(int i=1 ; i<=5 ; i ++) {
			for(int j =1 ; j <=5-i ; j ++) {
				System.out.print(" ");
			}
			for(int j =1 ; j<= 2*i - 1 ; j++) {
			 System.out.print("*");
		}
		System.out.println();
	}

}
}
// * 의 규칙은 *-i = i +1 
//  즉 *= I + I -1 
