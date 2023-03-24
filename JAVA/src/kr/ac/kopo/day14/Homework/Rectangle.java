package kr.ac.kopo.day14.Homework;

public class Rectangle extends PlainFigure {
	public  Rectangle() {
		
	}
	public Rectangle(int width, int height) {
		super(width, height);
		double area = width * height;
		setArea(area);
	}

	@Override
	public void printArea() {

		System.out.printf("가로 %d 세로 %d인 직사격형의 넓이 : %f\n",
					getWith(), height, getArea());
	}
	
	
}
