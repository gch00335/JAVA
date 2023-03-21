package kr.ac.kopo.day10.Homework;

public class Teacher_Homework02 {

	public static void main(String[] args) {
	// 왜 메인을 하나 더 만든거지?
		
		Teacher_ScannerUtil scan = new Teacher_ScannerUtil();
		Teacher_StringUtil util = new Teacher_StringUtil();
		
		String str = scan.nextString("문자열을 입력 : ");
		String revstr = util.reverseString(str);
		System.out.println("Str : " + str);
		System.out.println("revStr : " + revstr);
		
	}

}
