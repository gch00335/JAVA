package kr.ac.kopo.day13.abs02;

public class SanmsungPrinter extends Printer { // 상위 클래스가 추상클래스, 메소드를 사용하면 하위클래스는 무조건 오버라이딩(재정의)를 해줘야한다.
	                                           //안그러면 이렇게 오류가 뜸!

	public void samPrint() {
		System.out.println("삼성프린터에서 출렵합니다..");
	} //항상...{} 확인 잘하기..!
	@Override
		public void print() {
//			System.out.println("삼성프린터에서 출력중...");
			samPrint();
		}
	}

