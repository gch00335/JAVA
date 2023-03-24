package kr.ac.kopo.day14.Homework;

public abstract class Figure {
	
	protected double area; 
	
	// 외부에서 내 맴버변수를 보여줄 때 쓰는 코드 get값입력()  [게터]라고 부른다
	// area 값을 외부에 보여줘! 하는 코드 // 항상 보여주는 값앞은 대문자를 써야 한다.
	
	public double getArea() {
		return this.area;
		
	}
	
	public void setArea(double area) { 
		this.area = area;
	// 외부에서 내 맴버변수를 보여준 후 수정하려는 코드는 set값입력()  [ 세터 ] 라고 부른다.
	
	}
	
	public abstract void printArea();

}

