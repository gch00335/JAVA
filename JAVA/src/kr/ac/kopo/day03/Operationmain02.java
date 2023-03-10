package kr.ac.kopo.day03;

public class Operationmain02 {

	public static void main(String[] args) {
		
		int a = 0, b = 0;
		
		//boolean result = ++a > 1 && ++b >= 0;
		// ++a = 1 인제 1보다 크다의 답에는 거짓
		// 그다음 ++b 도 1이 나와야 하지만 , 이미 앞에서 거짓이 나왔기 때문에 뒷처리를 할 필요가 없어서
		// b = 0 으로 무시를 한것임.(++b 를 무시한거임)
		
		boolean result = ++b > 0 && ++a > 1;
		System.out.printf("a = %d b = %d\n", a, b);
		// 이렇게 했을 때는 ++b >=0 이 진실로 성립되었을때
		// ++a 까지도 인식이 되서  ++a >1 거짓이어도   a=1이라고 결과값도출

	}

}
