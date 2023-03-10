package kr.ac.kopo.day04;

public class OperationMain05 {

	public static void main(String[] args) {
		
		int num = 0x0055FF00;
		// '0x'가 16진수 나타내라는 의미 ' %x '(이것도 16진수 나타내라는 표시)
		System.out.printf("%x\n", num);
		// x 가 소문자면 소문자로 , X가 대문자면  0X0055FF00 으로 나옴
		
		System.out.printf("%x\n" , ~num);
		// ~ 이거는 [반대연산자] 
		// 55ff00 을 반대로 연산하면 *16진수로 * ffaa00ff 가 나옴
		
		System.out.printf("%08x\n", num & 0xffff0000);
		System.out.printf("%08x\n", num & 0x0000ffff);
		// 앞에 0이 붙을경우 생략이 되므로 8자리까지 나타내라는 의미로 08을 붙여준다.
		// 참고로 0000 이렇게 붙여주는건 모자이크 표시 ! 
		
		
	
	}

}
