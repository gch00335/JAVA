package kr.ac.kopo.day07;
import java.util.Scanner;
public class ArrayMain03 {

	/*
	 * \키보드로 3개의 실수를 입력받아 출력하는 코드를 작성하시오
	 * 첫번째 실수 : 12.3
	 * 두번째 실수 : 66.23
	 * 세번째 실수 : 10.673
	 * <PRINT>
	 * 12.3 66.23. 10.673
	 */
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		double[]ar = new double[3];
		
		for(int i=0 ; i < ar.length ; i ++) {
			System.out.print( i+1 + "번째 실수 :");
			ar [i] = sc.nextDouble();
		}
		System.out.println("<PRINT>");
		for(int i=0 ; i <ar.length ; i++) {
			System.out.print(ar[i] + "\t");
		}
		System.out.println();
}
}
