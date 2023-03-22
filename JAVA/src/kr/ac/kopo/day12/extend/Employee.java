package kr.ac.kopo.day12.extend;

public class Employee {
 
	int no;
	String name;
	int salary;
	String grade;
	
	Employee(){
	
	}
	Employee(int no, String name, int salary, String grade){
	
		this.no = no; 
		this.name = name ;
		this.salary = salary;
		this.grade = grade;
		
	}
	public void info() {
		System.out.println("사번 : " + no + ", 이름 : " + name
				+ ", 연봉 : " + salary + "만원, 직급 : " + grade);
	}
}
