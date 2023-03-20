package kr.ac.kopo.day10;

public class StringMain03 {

	public static void main(String[] args) {
		
		String str = "Hello World";
		char ch = 'r';
		
		System.out.println("str : [" +str + "]");
		int idx = str.indexOf(ch); 
		System.out.println(ch + "위치 :"+ idx);
		//System.out.println(ch + "위치 :"+ str.indexOf(ch));
		
		ch= 'p';
		System.out.println(ch + "위치 :"+ str.indexOf(ch)); 
		// 찾고자 하는 문자가 없을때는 -1 로 뜬다!
		
		String searchStr = "lo";
		System.out.println(searchStr + "위치 :"+ str.indexOf(searchStr)); 
		
		// 둘의 차이
		
		ch='l';
		System.out.println("indexOf()"+ "위치 :"+ str.indexOf(ch)); //앞에서부터
		System.out.println("indexOf()"+ "위치 :"+ str.indexOf(ch,3)); 
		System.out.println("lastIndexOf()" + "위치 :"+ str.lastIndexOf(ch)); //뒤에서부터
		
		
		
	}

}
