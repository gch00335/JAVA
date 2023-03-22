package kr.ac.kopo.day11.Homework;

public class Teacher_icecreamMain {

	public static void main(String[] args) {
		// 코드를 많이 쓰는 것보다 간편하게 하는게 좋음   / main에 모든 것을 다 적는 것은 [절차지향적]일때에만 좋음!
		// 다른 클래스에 코드를 만들어서 main은 짧을수록 좋다.
		
		Teacher_icecreamMarket market = new Teacher_icecreamMarket();
		market.open(); // 객체지향의 의미로 마켓 만들어서, 마켓이 열려있는 동안 구매하게 만들어보겠다.
		
		
	}

}
