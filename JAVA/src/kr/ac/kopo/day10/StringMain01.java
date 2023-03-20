package kr.ac.kopo.day10;

import java.util.Arrays;

public class StringMain01 {

	public static void main(String[] args) {
		
		String str = new String();
		String str2= new String("Hello");
		char[] chars = {'H','e','l','l','o'};
		String str3 = new String(chars);
		byte[]bytes = {72,101,108 ,108,111};
		String str4 = new String(bytes);
		
		
		
		System.out.println("str : [ " + str + "]"); 
		System.out.println("str2 : [ " + str2 + "]");
		System.out.println("str3 : [ " + str3 + "]");
		System.out.println("str4 : [ " + str4 + "]");
		
		System.out.println(str4 + "의 길이 : " + str4.length());
		
		for(int i = 0 ; i <str4.length(); i ++) { // 배열이 아니니까 [][]이것을 쓸 수 없음. 그럴때 charAt를 쓰면됨!
			System.out.println(i + "번째 문자ㅣ :" + str4.charAt(i));
		}
		
		chars = new char[10];
		System.out.println("chars : "+ Arrays.toString(chars));
		//str4.getChars(0, str4.length(), chars, 0); //0~4까지 있는 문자를 0부터 입력을 시작하라는 뜻
		str4.getChars(2,4,chars, 6); // 2번째부터 4번째 전까지의 글자를 6번째로 이동시키겠다는 뜻
		System.out.println("chars : "+ Arrays.toString(chars));
		
	}

}
