package kr.ac.kopo.day08;

import java.util.Arrays;

public class ArrayMain04 {

	public static void main(String[] args) {
		
		int loc=0; //만약 중간에 변수를 추가하고 싶지만 순차적으로 적어야 하기때문에
		           //  이렇게 추가되는 로컬을 0부터 시작하고 ++가 되도록 설정하면 가능하다!
		
		// "하이테크 " "자바" "교육"
		//String[] strArr = {"하이테크", "자바", "교육");
		String[] strArr = new String[5]; // 이렇게 참조변수는 3개밖에 없는데 그 이상의 수를 입력하면
		                                   // null 이라고 찍힌다.
		strArr[loc++] = "하이테크";
		strArr[loc++] = "자바";
		strArr[loc++] = "인공지능 소프트웨어과" ;// 이렇게 추가해도 순차는 변하지 않고 중간에만 넣을 수 있다.
		strArr[loc++] = "교육";
		
		System.out.println("<index 이용 출력 > ");
		for(int i = 0 ; i <strArr.length; i++){
			System.out.println(strArr[i]);
			
		}
		System.out.println("<1.5버전 for 출력>");
		for(String str:strArr){
			System.out.println(str);
			
		
		}
				System.out.println("<Arrays.toString() 이용출력>");
				System.out.println(Arrays.toString(strArr));
			//"[" + strArr[0] + ", " } strArr[1] | "," + strArr[2] + "]");

	}
}


// [art] + [shift]+ [a] 누르면 세로 커서 등 한번에 블록처리 가능 (한번에 수정할 거 있으면 누를 것)
// [art]+[ctrl]+[위 아래 방향키] 누르고 복사한 후 , [art] 누른채 방향키 누르면 그대로 이동이 가능!!