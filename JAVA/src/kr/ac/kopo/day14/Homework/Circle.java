package kr.ac.kopo.day14.Homework;

public class Circle extends Figure { // 상속하는 클래스가 추상클래스여서 오버라이드 해줘야함!
	
	private int radius;
	
	public Circle() {
		
	}
	public Circle(int radius) {
		this.radius = radius;
		
		double area = radius * radius *Math.PI ;
		setArea(area);
		

	
	}
	@Override
	public void printArea() {

		System.out.println("반지름 : " + radius + "원의 넓이 : " +  getArea());
}
}
