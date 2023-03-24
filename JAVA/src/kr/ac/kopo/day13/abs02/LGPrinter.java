package kr.ac.kopo.day13.abs02;

public class LGPrinter extends Printer {
	
	private String model;
	
	public LGPrinter() {
		model = "LG프린터";
	}

	public void lgPrint () { // 추상메소드가 없을 경우 상위클래스의 메소드를 꼭 따라할필요도 해도 된다 안된다의 두가지 길이 있었지만
		System.out.println(model + "에서 출력중...");
	}
	@Override
	public void print() {
//		System.out.println("LG프린터에서 출력중...");
		lgPrint(); // 이렇게 위에서 하위클래스 개인변수를 다시 끌어와서 강제서을 준 추상메소드에 기능을 이어줌!
		           // 이러한것을 [둔감화]라고 한다.
		
 // 추상메소드에 대해 강제성을 주기 때문에
//  적지않으면 오류가 난다.
	}
}
