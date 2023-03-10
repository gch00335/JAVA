package kr.ac.kopo.day02;

public class variablemain02 {

	public static void main(String[] args) {
	
		double num = 12.34;
		
		num =/*(double)*/ 34; //묵시적형변환
		/* 생략할 수 있는 것 : 범위가 넓은 데이터 형에 좁은 데이터 형에 대입하는 것 */ 

		System.out.println("num : " + num);
		
		int num2;
		num2 = (int)45.67; // 강제적(명시적)형변환
		/*명시적 : 범위가 좁은 데이터 형에 넓은 데이터 형을 대입하는 것 */
		System.out.println("num2 : " +num2);

		float num3;
		num3 = (float)10.4;
		num3 = 10.4f;
		
		System.out.println("num3 : " + num3);
		// 이것을 형변환이라고 함
		
		System.out.println(12 + (int)12.34);
		System.out.println(/*(double)*/12 + 12.34); /*정수에서 실수로 될경우 묵시적이기에 생략 가능*/
		// 정수는 정수 , 실수는 실수 이렇게 되어야만 더하기가 가능해지므로 변화시켜줘야함
	}

}
