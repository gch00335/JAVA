package kr.ac.kopo.day04;

import java.util.Scanner;
//스캐너는 java.ram에 없음 ! 유틸(util)패키지에 있음!
		//그렇기에 import를 꼭 처음에 적어줘야함!
public class ScannerMain {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("문자열을 입력 : ");
		//char ch = sc.nextLine().charAt(0);
		//System.out.println("ch : " + ch);
		
		
		//String str = sc.next();
		String str = sc.nextLine(); // 문자입력이기에 String str 입력해야함!
		
		System.out.println("str :" + str);
		
		//sysout 치고 [ctal] +[스페이스] 누르면 자동으로 완성됨
		
		//한 단어로만 인식이 되므로 " 내 이름"을 쳐도 "내"만 인식 
		// [next]를 썼기 때문에 , [nextLine]을 쓰면 문장으로 인식됨
		
		System.out.print("정수를 입력 : ");
		int num = sc.nextInt();   
		// 여기서 int는 기본자료형! <-> 실수라면 float, double 이 나오는 것임!
		System.out.println("num : " + num);
		
		System.out.print("실수를 입력 : ");
		double num2 = sc.nextDouble();
		
		System.out.println("num2 : " + num2);
		
		
	}

}
