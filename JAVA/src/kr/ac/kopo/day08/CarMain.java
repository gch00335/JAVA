package kr.ac.kopo.day08;

//tlfgodzmffotm
public class CarMain {

	void aaa() {
	// 에러가 나는 이유는 오직 메소드 안에서만 써야하기 때문이다! 
		           // num  은 메인메소드에 있기에 인식이 안되는 것!
		
	}
	public static void main(String[] args) {
		Car c = new Car(); // Heap 영역에 만들어진거임!
	// new kr.ac.kpop.day08.car 이렇게 만들어야함! 
   // 하지만 현재에는 오류가 나지 않은 이유는 같은 [패키지]안에 있기에
  // 오류가 나지 않고 객체가 형성된거임
	
		c.model = "소나타";
		c.price = 3000;
		
		Car c2 = new Car();
		
		c2.model = "모닝";
		c2.price = 1900;
		
		
	System.out.println("모델명 : "+ c.model +", 가격 : " + c.price + "만원");
	System.out.println("모델명 : "+ c2.model +", 가격 : " + c2.price + "만원");
}
}