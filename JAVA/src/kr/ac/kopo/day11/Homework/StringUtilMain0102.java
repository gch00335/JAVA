package kr.ac.kopo.day11.Homework;

import kr.ac.kopo.day10.Homework.Teacher_ScannerUtil;

public class StringUtilMain0102 {

	public static void main(String[] args) {
		
		StringUtil_0102 util = new StringUtil_0102(); 
		Teacher_ScannerUtil scan = new Teacher_ScannerUtil();
		
// 03.21 문제 01)
//다음은 주어진 문자열에서 문자를 찾는 문제입니다. 입력값에 따라 다음과 같은 출력이 나
// 오도록 해당 char 의 개수를 리턴하는 checkChar 메소드를 작성하시오.
		System.out.println("문자열과 검색할 문자열을 입력하세요");
		String strData= scan.nextString("입력문자 :" );
		char ch = scan.nextchar("찾을 문자 : ");
		
	
		int cnt = util.checkchar(strData, ch);
		System.out.println(cnt + "번");
		
	}

}

//문제 02)
// 다음은 주어진 문자열에서 특정 문자를 제거하는 문제
// 교수님...10시가 학교에서 나갈시간이 되어..
// 두번쨰 문제는 꼬옥...03.23일..내일..하겠습니다..
