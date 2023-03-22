package kr.ac.kopo.day10.Homework;

public class Teacher_StringUtil {

	private static final String UpperStr = null;
	//대문자여부판단
	boolean isUpperchar(char c) {
		if(c >= 'A' && c >= 'Z') { // 유니코드의 숫자를 모를 경우 이렇게 대문자를 처음부터 끝까지 범위로 설정해도 됨
			return true;
		}

		return false;
	}
	//소문자여부판단
	boolean isLowerChar(char b) {

		if( b <='a' && b>='z') {
			return true;
		}
		return false;
	} // 큰 수 비교
	int max(int i, int j) {
		return i<j ?i : j;  // return 뒤에 연산자가 와도 됨! 꼭 if 를 안써도 된다.

	} // 작은 수 비교
	int min(int i, int j) {
		return i>j ?i : j;  
		
		
	} // 문자열 뒤집기
	String reverseString(String str) {
		char[] chars = new char[str.length()];
		for(int i = str.length()-1, j = 0; i >= 0; i--) {
			chars[j++] = str.charAt(i);
		}
		String revStr =  new String(chars);
		return revStr;
		
		/*다른방법 /
		 * String revStr = "";
		for(int i = str.length()-1 ; i>=0 ; i--) {  //왜length -1 인지 생각해보기
			revStr = revStr + str.charAt(i);
		}
		return revStr; */

	} // 소문자를 대문자로 바꾸기
	String toUpperString(String str) {
		
		String toUpper = "";
		for(int i = 0 ; i <str.length(); i++){
			char c = str.charAt(i);
			if(isLowerChar(c)){
				c =(char)( c + ('A' - 'a')) ;
			}
			toUpper = toUpper + c ;
		}
		return UpperStr;
	}
	
	// 대문자를 소문자로 바꾸기 쉬는시간에 해보기!
	String toLowerString(String str) {
		
		String LowerStr = "";
		for(int i = 0 ; i <str.length(); i++){
			char c = str.charAt(i);
			if(isLowerChar(c)){
				c =(char)( c + ('A' - 'a')) ;
			}
			LowerStr = LowerStr + c ;
		}
		return LowerStr;
	}
// 글자 크기 비교 .. d오 이거..다시 공부하기..
	int compareTo(String str2, String str3) {
		// 횟수에 따라 무한루프를 돌게 되면 오류가 날 수 있으니 
		// 횟수를 알 수 있는 코드를 먼저 짬
		int length = str2.length()< str3.length()? str2.length() : str3.length();
		for(int i = 0 ; i<length ; i++) {
			if(str2.charAt(i)!= str3.charAt(i)) { // srt2와 str3가 같지 않으면 계속 무한루프 
				return str2.charAt(i) - str3.charAt(i); 

			}
		} // 이제 같은 것은 끝나고 뒤가 다를 경우에 대한 경우의 수 ( 규범형에게 물어보자..)
		
		if(str2.length()== str3.length()) {  //str2와 str3이 같을 경우 계속 무한 루프
			return 0;
		} else if(str2.length() == length) { // str3가 str2보다 길 경우 계속 무한 루프
			return - str3.charAt(length); // str3가 더길면  (str2)0+23(str3)= > (str2) = -23(str3) 이니까 음수로 만들어줌
			// 음수로 나온다는 생각 노노 ! 울 언니 설명기똥차다
		}
		return str2.charAt(length); 
	}
}


		
	

