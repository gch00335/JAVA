package kr.ac.kopo.day11.Homework;

public class Teacher_icecream {
	
	//아이스크림이라는 사물이 추상화되서 나와야함 -> 아이스 클래스가 나와야 함
	// 속성 ->

	String name;
	int price;
	static int total; // 살때마다 총합을 이루면 되니까 ! static
	
	Teacher_icecream(){
	
	}
	
	Teacher_icecream(String name, int price) {
		this.name = name;
		this.price = price;
		Teacher_icecream.total += price;
	}
	public String getname() {
		return name; // 입력하는 이름에 대한 코드
		
	}
	public int getprice() {
		return price; //입력하는 가격에 대한 코드
	}
	public static void totalnfo() { // 객체를 만들고 총합을 하는 것이 아니기에 static을 붙여줘야 함
		System.out.println("총액 : " + Teacher_icecream.total + "원");
	}
}