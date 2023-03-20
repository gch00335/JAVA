package kr.ac.kopo.day10.Homework;

import java.util.Scanner;

public class Homework01 {

	public static void main(String[] args) {
		// 항상 젤 먼저 해야하는게 객체 실체화형성!
		StringUtil String = new StringUtil(); //
		
//1. 하나의 문자를 입력받아 해당 문자가 대문자이면  true 를 반환하는 isUpperChar( char c ) 메소드를 작성하시오
		System.out.println("***문자를 입력받아 해당 문자가 대문자면 true***");
		Scanner sc = new Scanner(System.in);
		System.out.println("문자를 입력하세요");
		String s = sc.next();
		char c = s.charAt(0); 

		if (String.isUpperChar(c)) {
			System.out.println("true");
		} else {
			System.out.println("flase");
		}
//2. 하나의 문자를 입력받아 해당 문자가 소문자이면 true를 반환하는 isLowerChar(char c) 메소드를 작성하시오
		System.out.println("***문자를 입력받아 해당 문자가 소문자면 true***");
		System.out.println("문자를 입력하세요");
		String a = sc.next();
		char b = s.charAt(0);

		if (String.isLowerChar(c)) {
			System.out.println("true");
		} else {
			System.out.println("flase");
		} 
//3.두개의 숫자를 입력받아 큰수를 반환하는 max( int i, int j) 메소드를 작성하시오
		System.out.println("***두개의 숫자 중 큰 수로 반환***");
		System.out.println("첫번째 수 입력 하세요 :");
		int i = sc.nextInt();
		
		System.out.println("두번째 수 입력 하세요 :");
		int j = sc.nextInt();
		
		System.out.println("max("+ String.max(i, j)+ ")" );
	
//4. 두개의 숫자를 입력받아 작은 수를 반환하는 min( int i, int j) 메소드를 작성하시오
	System.out.println("***두개의 숫자 중 작은 수로 반환***");
	System.out.println("첫번째 수 입력 하세요 :");
	int k = sc.nextInt();
	
	System.out.println("두번째 수 입력 하세요 :");
	int l = sc.nextInt();
	
	System.out.println("min("+ String.min(k, l)+ ")" );
	
//5. 문자열을 입력받아 거꾸로 변경하는 reverseString( String str ) 메소드를 작성하시오
	
	System.out.println("***입력받은 문자열 반대로 변경***");
	System.out.println("문자열을 입력하세요");
	String m = sc.next();
	System.out.println(String.everseString(m));

//6. 문자열을 입력받아 대문자로 변경하는 toUpperString( String str ) 메소드를 작성하시오
	System.out.println("***소문자를 대문자로 변경***");
	System.out.println("문자열을 입력하세요");
	String n = sc.next();
	System.out.println(String.toUpperString(n));

//7. 문자열을 입력받아 소문자로 변경하는 toLowerString( String str ) 메소드를 작성하시오	
	System.out.println("***대문자를 소문자로 변경***");
	System.out.println("문자열을 입력하세요");
	String o = sc.next();
	System.out.println(String.toUpperString(o));
	
//8. 두개의 문자열을 입력받아 문자열 크기를 비교하는 compareTo(String str, String str2) 메소드를 작성하시오.	
	System.out.println("***두개의 문자열 크기 비교***");
	System.out.println("두개의 문자열을 입력하세요");
	String p = sc.next();
	String q = sc.next();
	System.out.println(String.compareTo(p,q));
	}
}
