package kr.ac.kopo.day08;

import java.util.Arrays;

public class ArrayMain04 {

	public static void main(String[] args) {
		// "하이테크 " "자바" "교육"
		//String[] strArr = {"하이테크", "자바", "교육");
		String[] strArr = new String[3];
		strArr[0] = "하이테크";
		strArr[1] = "자바";
		strArr[2] = "교육";
		
		System.out.println("<index 이용 출력 > ");
		for(int i = 0 ; i <strArr.length; i++){
			System.out.println(strArr[i]);
			
		}
		System.out.println("<1.5버전 for 출력>");
		for(String str:strArr){
			System.out.println(str);
		}
				System.out.println("<Arrays.toString() 이용출력>");
				Arrays.toString(strArr);
				
			// 	"[" + strArr[0] + ", " } strArr[1] | "," + strArr[2] + "]"

	}

}
