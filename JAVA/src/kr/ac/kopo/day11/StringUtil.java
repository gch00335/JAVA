package kr.ac.kopo.day11;

public class StringUtil {

	//day10일과제에 이어서 하기
	String removeChar(String str) {
			String delChar = "";
			
			
			for(int i= str.length() ; i>=0 ; i++) {
				delChar = str.charAt(i) ;
				Last = str.length()- delChar; 
			}
			return delChar ;
}
	
}
/* String revStr = "";
for(int i = str.length()-1 ; i>=0 ; i--) {  //왜length -1 인지 생각해보기
	revStr = revStr + str.charAt(i);
}
return revStr; */
/*
String everseString( String str ) { 
String m = "";

int Last = str.length() -1 ;
for(int i= 0; i<str.length() ; i++) { 
	m += str.charAt(Last);
	Last -= 1;
}
return m;
} */