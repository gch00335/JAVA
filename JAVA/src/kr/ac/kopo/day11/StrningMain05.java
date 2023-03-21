package kr.ac.kopo.day11;

import java.util.Arrays;

public class StrningMain05 {
	public static void main(String[] args) {
		
		String str = "hello World";
		// 부분문자열 반환
		System.out.println("str : [ " + str + " ] ");
		String sub = str.substring(3,8);
		System.out.println("sub : [" + sub + " ]");
		
		int idx = str.indexOf("World");
		sub = str.substring(idx);
		System.out.println("sub : [" + sub + "]");
		
		str = "hello World";
		idx = str.indexOf("World");
		sub = str.substring(idx, idx+"World".length());
		System.out.println("sub : [ " + sub + "]");
	
		//결합된 문자열 반환
		String a = "Hello";
		String b = "good-bye";
		//String c = a+b;
		String c = a.concat(b);
		System.out.println("C : " + c);
		
		// 치환된 문자열 반환
		// str.relpace("l","rr"); //이렇게는 오류가 됨
		String str2 = str.replace("l","rr"); // 이렇게 써줘야함
		System.out.println("str : [" +str + "]");
		System.out.println("str : [" +str2 + "]"); 
		
		// 공백이 제거된 문자열을 반환
		str="              Hello  World       ";
		System.out.println("[" + str+ "]의 길이 : " + str.length());
		str= str.trim();
		System.out.println("[" + str+ "]의 길이 : " + str.length()); // 좌우에 있는 공백만 세어짐, 중간에 있는 건 세어지지 않음.
		
		// 소문자로 반환 / 대문자로 반환
		str= "Hello WOrld";
		System.out.println("toUpperCase() : " + str.toUpperCase());
		System.out.println("toLowerCase() : " + str.toLowerCase());
		
		//문자열 나누기 
		str = " 경기도 성남시 수정로 398";
		String[] strArr = str.split(" ");
		System.out.println("str : [" + str + "]");
		System.out.println(Arrays.toString(strArr)); // 보통 전화번호부, ip주소 등에 사용
		
		
		String ip= "172.31.9.164";
		String[] ipArr = ip.split("\\.");
		System.out.println("ip : " + ip);
		System.out.println(Arrays.toString(ipArr));
		
		// 정수를 문자열로 형변환 시키고 싶을때
		int no =123;
		double no2 = 10.23 ;
		
		System.out.println(no + 100); // 223 
		System.out.println(no2+ 100); // 110.23
		
		System.out.println(no + "" + 1100); //123이 숫자가 된게 아니라 글자로 인식해서 123100가 된 꼼수방법!
		
		System.out.println(String.valueOf(no) + 100); // 이게 제대로 된  형변환 방법
		System.out.println(String.valueOf(no2) + 100);
	}
}
