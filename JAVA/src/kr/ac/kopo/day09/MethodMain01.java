package kr.ac.kopo.day09;

public class MethodMain01 {
	
	static int prnStar(int num, String data) { // [호출자메소드] // 피호출자 메소드에 전달받을 내용 ( )에 기록
	
		
		System.out.println("*******");
		System.out.println("호출자가 넘겨준 정수 : " + num);
		/*boolean bool = true;
		if(bool)
			return;  */// 데이터 위에다가 리턴을 썻기에 문자열은 실행이 안됨
		System.out.println("호출자가 넘겨준 문자열 : " + data);

		int sum = num%10 + num/10;
		
		return sum;
	
	}
	
	
	
	public static void main(String[] args) {
		// 메소드끼리는 독립적인 객체다보니 서로 인식할 수 없다!
		int cnt = 10;
		int s = prnStar(cnt, "abc");
		System.out.println("자리수 합 : " + s);
		System.out.println("Hello");
		s = prnStar(5, "hi");
		System.out.println("자리수 합 : " + s);
		System.out.println("HI");
		s = prnStar(24, "good");
		System.out.println("자리수 합 : " + s);
		System.out.println("Good-bye");
		s = prnStar(9, "bye");
		System.out.println("자리수 합 : " + s);
	}
}
