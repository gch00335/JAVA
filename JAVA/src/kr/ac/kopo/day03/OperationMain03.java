package kr.ac.kopo.day03;



/* 
  두 개 정수 입력 : 12 5
  12는 5의 배수판단 : false
  
  두 개 정수 입력 : 12 6 
  12는 6의 배수판단 : true
  
 */
public class OperationMain03 {

	public static void main(String[] args) {
		
		int num01 = 15 , num02 = 0; 
		//% 사용했을 경우 나머지가 0 일경우 무조건 배수라고 인식이 되서
		//num01 = 0 일경우 배수가 아님에도 TRUE로 인정됨 . 그렇기에 num01은 0이면 안된다라는 조건부도 작성해야함


		boolean bool = (num02 != 0 &&num01 % num02 == 0);
		System.out.printf("%d는 %d의 배수판단 : %b\n", num01, num02, bool);
		
				
		// 이럴경우 ',' 를 이용해 옆으로도 이용할 수 있음. 이걸 순서연산자라고 함
 
	
	}

}

