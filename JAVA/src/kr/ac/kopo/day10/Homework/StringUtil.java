package kr.ac.kopo.day10.Homework;

public class StringUtil {

	// 알파벳 대문자 : 65 ~ 90
	// 알파벳 소문자 : 97 ~ 122
/*  
- 아래의 내용을 만족하는 StringUtil 클래스를 작성합니다. (1번 ~7번)
*/
	
//하나의 문자를 입력받아 해당 문자가 대문자이면 true 를 반환하는 isUpperChar( char c ) 메소드를 작성하시오
		
	boolean isUpperChar(char c) {

		if( (int)c<=90 && 65<=(int)c) {
			return true;
		}
		return false;

	}
//하나의 문자를 입력받아 해당 문자가 소문자이면 true를 반환하는 isLowerChar(char c) 메소드를 작성하시오

	boolean isLowerChar(char b) {

		if( (int)b <=122 && (int)b>=97) {
			return true;
		}
		return false;
	}
//두개의 숫자를 입력받아 큰 수를 반환하는 max(int i, int j) 메소드를 작성하시오	
	int max(int i , int j) {
		if( i >  j) { 
			return i ;
		} else if (i < j) { 
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
		for(int i= 0; i<str.length() ; i++) { 
			m += str.charAt(Last);
			Last -= 1;
		}
		return m;
	}
//문자열을 입력받아 대문자로 변경하는 toUpperString( String str ) 메소드를 작성하시오
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
//문자열을 입력받아 소문자로 변경하는 toLowerString( String str ) 메소드를 작성하시오	
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
//두개의 문자열을 입력받아 문자열 크기를 비교하는 compareTo(String str, String str2) 메소드를 작성하시오.	
	int compareTo(String str, String str2) {

		int length = str.length()< str2.length()? str.length() : str2.length();
		for(int i = 0 ; i< length ; i++) {
			if(str.charAt(i)!= str2.charAt(i)) { 
				return str.charAt(i) - str2.charAt(i); 
			}	
		}
		return length;
	}

//9. 문자열 입력받고, 검색할 문자열을 입력받아 검색할 문자열로 끝나는 endsWith(String str1, String sub) 메소드 작성
//문자열 입력 : hello world
//검색할 문자열 입력 : ld
//ld로 끝나는지 여부 판단 : true
	boolean endsWith(String str1, String sub) {


		int eIdx = -1;
		for(int i = str1.length() - sub.length(); i<str1.length(); i++) {
			if(str1.charAt(i)!= sub.charAt(eIdx)) {
				return false ;
			}
			++eIdx;
		}
		return true ;
	} 
//왜..헬로우 월드만 쳐도 에러가 날까요.......다시해봐도 안되네..
	
//

//10. 문자열 입력받고, 검색할 문자열을 입력받아 검색할 문자열이 어느 위치에 있는지 검색하는 indexOf(String str1, String sub) 메소드 작성
//문자열 입력 : hello world
//검색할 문자열 : or
//or은 7번지에 위치함

	int indexOf(String sub1, String sub2) {


		for(int i =0 ; i <sub1.length(); i++) {
			int s =0;
			if(sub1.charAt(i) == sub2.charAt(0)) {
				s++;
			} else {

			}
			if(s == sub2.length()) {
				return i;
			}

		}


		//문자열에서 s를 탐색기회로 잡고 ,  sub1 과  sub2의 시작점이 같으면 탐색시작..왜 안되는거지...
		return 0;
	}


// 03.21 문제 01)
//다음은 주어진 문자열에서 문자를 찾는 문제입니다. 입력값에 따라 다음과 같은 출력이 나
// 오도록 해당 char 의 개수를 리턴하는 ch eckChar 메소드를 작성하시오.



//문제 02)문자열에서 특정 문자를 제거 // 문자열 (oriStr)의 내용 중 주어진 문자(delChar)를 삭제

