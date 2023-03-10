package kr.ac.kopo.day04;



/* 
  두 개 정수 입력 : 12 5
  12는 5의 배수판단 : false
  
  두 개 정수 입력 : 12 6 
  12는 6의 배수판단 : true
  
 */
public class OperationMain04 {

	public static void main(String[] args) {
		
		//String msg = true ? "배수" : "배수아님" ;
		
		//System.out.println( true ? "배수다" : "배수가 아니다");
		
		int num01 = 15 , num02 = 3; 
		

		boolean bool = (num02 != 0 &&num01 % num02 == 0);

		String result = bool ? "배수입니다" : "배수가 아닙니다";
		
		System.out.printf("%d는 %d의 배수판단 : %s\n", num01, num02, result);
		
				
		// 3항 연산자 
		// 조건식 ? 수식 -1 : 수식 -2 
		// 수식 - 1 : 조건식의 결과가 참일때 수행되는 식
		// 수식 - 2 : 조건식의 결과가 거짓일때 수행되는 식
 
	
	}

}

