package kr.ac.kopo.day0507.Homework;

public class ExamMain05 {

	public static void main(String[] args) {
		/* 15번
		 * *********
		   _*******
		   __*****
		   ___***
		   ____*
          
		   
		   */
		   
		for(int i=1 ; i <=5 ; i ++) {
			for(int j =1 ; j <= i-1 ; j++) {
				System.out.print(" ");
			}
			for(int j = 1 ; j <=  11 - 2*i  ; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

	}

}
