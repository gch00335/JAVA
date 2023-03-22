package kr.ac.kopo.day12.Homework;

public class circle extends shapeQuiz  {

	public circle() { // 원
	}
	
	
	circle(int no, int m, int c, int m2){
	
	super(no, m, c, m2);
	}
	
	public void area(int m4) {
	System.out.println("반지름" + m4 + "의 원 넓이는"+ m4 * m4 + "입니다");
}
}