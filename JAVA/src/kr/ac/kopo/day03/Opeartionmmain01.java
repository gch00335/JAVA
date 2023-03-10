package kr.ac.kopo.day03;

public class Opeartionmmain01 {

	 public static void main(String[] args) {

		 int num = 123;
		 
		 //num = num + 1;
		 // 자신의 수에 1을 더하는 코드 
		 
		// num = num + 50;
		 // 50을 더하는 코드
		 
		 //num += 50;
		 //이렇게 해도 50을 더하는 위 코드와 같음! -> 복합대입연산자, 배정연산자
		 // +=, -\, *=, '=, %=
		 
		 ++num; // 증감연산자 
		 
		 
		 System.out.println("num : " + num);
	
		// int a= 10;
		 
		// System.out.println(a + 20);
		 //System.out.println(a);
		 // 이렇게 '='을 써줘야만 결과값이 바뀌는데 , 증감연산자 '++, --' 은 '=' 안써도 바뀜
		 // 이것을 증감연산자라고 함
		 
		 //int a = 5;
		 //int b = a--;
		 //System.out.println(b); 전위증가와 후위증가가 이렇게 다르므로 기억해둘 것 
		 // 답이 다르게 도출
		 
		 int a= 5;
		  System.out.println(a++); //5
		  System.out.println(++a); //6(후행처리)+1 = 7 
		  System.out.println(--a); // 7-1= 6
		  System.out.println(a  );// 6
		  System.out.println(a--); //6
		  System.out.println(a++); //후행처리(6-1) 
	 }
}
