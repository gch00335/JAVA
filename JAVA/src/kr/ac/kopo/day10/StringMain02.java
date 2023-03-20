package kr.ac.kopo.day10;

import java.util.Arrays;

public class StringMain02 {

	public static void main(String[] args) {

		String str01 = "Hello World";
		String str02 = "hello World";
		
		//주소를 비교하려는 것이 아닌 문자열을 비교하기 위한것이니
		// equals를 써야한다.
		System.out.println("str01 : [" + str01 + "]");
		System.out.println("str01 : [" + str02 + "]");
		
		
		//주소비교하는 것이다.
		if(str01==str02) {
			System.out.println("[주소비교]str01==str02");
		} else {
			System.out.println("[주소비교]str01!=str02");
		}
		
		//값비교(대소문자 구분 o)
		boolean bool = str01.equals(str02);
		if(bool) {
			System.out.println("[값비교]str01==str02");
		} else {
			System.out.println("[값비교]str01 != str02");
		}
		
		//값비교(대소문자 구분 X)
		bool = str01.equalsIgnoreCase(str02);
		if(bool) {
			System.out.println("[값비교]str01==str02");
		} else {
			System.out.println("[값비교]str01 != str02");
		}
		
		//찾고자 하는 이름.문자 있을 때 사용
		String[] names = {"홍길동","강길동","홍길순","홍길동","김길순","김길남","길동홍"};
		System.out.println("names"+Arrays.toString(names));
		System.out.println("<홍길동인 사람을 검색>");
		for(String name : names) { //1.5버전의 for문
			if(name.equals("홍길동")) {
				System.out.println(name);
			}
		}
		
		System.out.println("<홍씨성을 가진 사람을 검색>");
		for(String name : names) {
			if(name.startsWith("홍")) {
				System.out.println(name);
		}
		}
	
		System.out.println("<이름 길동인 사람을 검색>");
		for(String name : names) {
			if(name.endsWith("길동")) { // 확장자 검색을 할때 많이 이용함
				System.out.println(name);
			}
		}
		System.out.println("<\"길동\"이 포함된 사람을 검색>");
		for(String name : names) {
			if(name.contains("길동")) { // 처음과 끝 상관없이 포함된 것을 찾는 것
				System.out.println(name);
	}
}
		// 글자 크기 비교
		str01 = "banana";
		str02 = "boat";
		
		int cmp = str01.compareTo(str02);
		if(cmp == 0 ) {
			System.out.println(str01 + "==" + str02);
		} else if(cmp >0) {
			System.out.println(str02 + "<" + str01);
			
		} else {
			System.out.println(str01+"<" + str02);
		}
	
	}
}
