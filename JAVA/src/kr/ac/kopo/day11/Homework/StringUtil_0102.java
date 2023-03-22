package kr.ac.kopo.day11.Homework;

public class StringUtil_0102 {

	// 03.21 문제 01)
	//다음은 주어진 문자열에서 문자를 찾는 문제입니다. 입력값에 따라 다음과 같은 출력이 나
	// 오도록 해당 char 의 개수를 리턴하는 checkChar 메소드를 작성하시오.
	static int checkchar(String strData, char ch) {

		int count = 0 ;

		for(int i =1; i<= strData.length(); i++) {
			char k = strData.charAt(i) ;
			if(ch == k) {
				count++;
			}
		}
		return count;
	}

}




	//문제 02)문자열에서 특정 문자를 제거 // 문자열 (oriStr)의 내용 중 주어진 문자(delChar)를 삭제



