package kr.ac.kopo.day10.Homework;

import java.util.Scanner;

public class Teacher_StringUtil_Homework {

	private static final Scanner scan = null;
	public static void main(String[] args) {

		Teacher_ScannerUtil scan = new Teacher_ScannerUtil();
		char c = scan.nextchar("문자를 입력 : ");       // 스캐너 클래스를 하나더 만들었기에 좀 더 간소하게 만들 수 있다.
		                                             //Scanner sc = new Scanner(System.in);
		                                             //System.out.println("문자를 입력 :");
		                                             //char c = sc.nextLine().charAt(0); 

		Teacher_StringUtil util= new Teacher_StringUtil();
		// 대문자여부 판단
		boolean bool = util.isUpperchar(c);
		if(bool) {
			System.out.println(c + "  : 대문자가 맞습니다 ");

		}else {
			System.out.println(c + " : 대문자가 아닙니다");
		}

		// 소문자 여부 판단
		char s = scan.nextchar("문자를 입력 : ");
		boolean bool1 = util.isLowerChar(s);
		if(bool1) {
			System.out.println(s + "  : 소문자가 맞습니다 ");

		}else {
			System.out.println(s + " : 소문자가 아닙니다");
		}

		//큰수 비교
		int num1 = scan.nextInt("첫번째 정수를 입력 : ");
		int num2 = scan.nextInt("두번째 정수를 입력 : ");
		int maxNum = util.max(num1,num2);
		System.out.println(num1 + "," + num2 + "중 큰 수: "+ maxNum);


		//작은수 비교
		int num3 = scan.nextInt("첫번째 정수를 입력 : ");
		int num4 = scan.nextInt("두번째 정수를 입력 : ");
		int minNum = util.min(num3,num4);
		System.out.println(num3 + "," + num4 + "중 작은 수 : "+ minNum);

		// 문자 뒤집기

		String str = scan.nextString("문자열을 입력 : ");
		String revstr = util.reverseString(str);

		System.out.println("Str : " + str);
		System.out.println("revStr : " + revstr);

		// 소문자를 대문자로 바꾸기
		String str1 = scan.nextString("문자열을 입력 : ");
		String upperStr = util.toUpperString(str1);

		// 대문자를 소문자로 바꾸기 -> 쉬는시간에 하기
		
		
		// 

		String str2 = scan.nextString("첫번째 문자열을 입력 : ");
		String str3 = scan.nextString("두번째 문자열을 입력 : ");
		int cmp = util.compareTo(str2,str3);
		if(cmp==0) {
			System.out.println(str2 + "=="+ str3);
		} else if(cmp >0) {
			System.out.println(str2 + "<"+ str3);
		} else {
			System.out.println(str3 + "<"+ str2);
		}
	}
}
