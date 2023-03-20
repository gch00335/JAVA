package kr.ac.kopo.day10.Homework;

public class StringUtil {

	
		// 알파벳 대문자 : 65 ~ 90
		// 알파벳 소문자 : 97 ~ 122
/*  
 - 아래의 내용을 만족하는 StringUtil 클래스를 작성합니다. (1번 ~7번)

 */
		
// 하나의 문자를 입력받아 해당 문자가 대문자이면 true 를 반환하는 isUpperChar( char c ) 메소드를 작성하시오
			
		boolean isUpperChar(char c) {
			
			if( (int)c<=90 && 65<=(int)c) {
				return true;
			}
			return false;

}
//하나의 문자를 입력받아 해당 문자가 소문자이면 true를 반환하는 isLowerChar(char c) 메소드를 작성하시오

		boolean isLowerChar(char c) {
			
			if( (int)c>=97 && 122>=(int)c) {
				return true;
			}
			return false;
}
//두개의 숫자를 입력받아 큰 수를 반환하는 max(int i, int j) 메소드를 작성하시오	
	int max(int i , int j) {
				if( i >  j) { // i가 크면 i 반환
					return i ;
			} else if (i < j) { //i 가 작으면 j 반환
				return j;
			}
		return 0;
}
	//두개의 숫자를 입력받아 작은수를 반환하는 min(int i, int j) 메소드를 작성하시오
	int min (int i , int j) {
		if(i>j) {
			return j;
		} else if(i < j) {
			return i ;
			}
	return 0;
} 
	//문자열을 입력받아 거꾸로 변경하는 reverseString( String str ) 메소드를 작성하시오
	String everseString( String str ) { 
		String m = "";
	
		int Last = str.length() -1 ;
		for(int i= 0; i<str.length() ; i++) { //i한글자 표현
			m += str.charAt(Last);
			Last -= 1;
		}
		return m;
	}
//	문자열을 입력받아 대문자로 변경하는 toUpperString( String str ) 메소드를 작성하시오
	String toUpperString( String str ) {
		String n = "";
		
		for(int i= 0; i<str.length() ; i++) { //i한글자 표현
		char word = str.charAt(i); 
		if((int) word >90) {// 알파벳 대문자 : 65 ~ 90
		                 	// 알파벳 소문자 : 97 ~ 122
			word -=32; 
			//단어가 90보다 크면 소문자가 122까지고 대문자는 90까지니까 둘을 빼줌
		}
		n += word;
		
		}		
				return n;
		
	}
// 문자열을 입력받아 소문자로 변경하는 toLowerString( String str ) 메소드를 작성하시오	
	String toLowerString( String str ) {
	String o = "";
	
	for(int i= 0; i<str.length() ; i++) { //i한글자 표현
	char word = str.charAt(i); 
	if((int) word <97) {// 알파벳 대문자 : 65 ~ 90
	                 	// 알파벳 소문자 : 97 ~ 122
		word +=32; 
		//단어가 97보다 작으면 소문자가 97부터고 대문자는 65부터니까 둘을 더해줌
	}
	o += word;
	
	}		
			return o;
	
}
//8. 두개의 문자열을 입력받아 문자열 크기를 비교하는 compareTo(String str, String str2) 메소드를 작성하시오.	
	String compareTo(String str, String str2) {
	String str01;
	String str02;
	
	if(str01==str02) {
		System.out.println(str1 + "=="+str2);
		
	} else if(str1> ) {
		System.out.println(str2+ "<" + str1);
	} else {
		System.out.println(str1+ "<" + str2);
	}
 
	return s;
}
}

