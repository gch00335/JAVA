package kr.ac.kopo.day12.Homework;

public class triangle  extends shapeQuiz  {

	public triangle() {//삼각형
	}
	

	triangle(int no, int m, int c, int m2){
	
	super(no, m, c, m2);
	}
	
	
	public void area(int m2, int c) {
	System.out.println("밑변" + m2 + "높이"+c + "의 삼각형의 넓이는"+0.5*m2*c+"입니다");
}
}
