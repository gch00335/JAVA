package kr.ac.kopo.day12.extend;

public class Manager extends Employee {
	
	Employee[] empList;
	//이클립스의 자동완성 기능

	public Manager() {
		super();
}
	//매게변수 자동으로 만들기
	public Manager(int no, String name, int salary, String grade, Employee[] empList) {
		super(no, name, salary, grade);
		this.empList = empList;
	}
	@Override
	public void info() {
		// TODO Auto-generated method stub
		super.info();
	}
}
