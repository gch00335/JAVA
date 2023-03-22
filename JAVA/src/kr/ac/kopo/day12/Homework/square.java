package kr.ac.kopo.day12.Homework;

public class square extends shapeQuiz  {

	public square() { //정사각형, 직사각형
	}
	
	
	square(int no, int m, int c, int m2){
	
	super(no, m, c, m2);
	}
	
	
	public void area(int m2) {
	System.out.println("가로" + m2 + "세로" + m2 +" 정사각형 넓이는"+ m2 *m2 + "입니다");
	}
	public void area2(int m3, int c2) {
		System.out.println("가로" + m3 + "세로" + c2 +" 직사각형 넓이는"+ m3 * c2 + "입니다");
}
}