package kr.ac.kopo.day04;

public class OperationMain05 {

	public static void main(String[] args) {
		
		int num = 0x0055ff00;
		
		System.out.printf("%x\n", num);
		// x 가 소문자면 소문자로 , X가 대문자면  0X0055FF00 으로 나옴
		
		System.out.printf("%x\n" , ~num);
		// ~ 이거는 [반대연산자] 
	}

}
