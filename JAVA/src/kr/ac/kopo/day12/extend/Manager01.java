package kr.ac.kopo.day12.extend;

public class Manager01 {
	int 		no;
	String 		name;
	int 		salary;
	String 		grade;
	Employee[] 	empList;	// 관리사원 목록
	
	public Manager01() {
		
	}
	
	public Manager01(int no, String name, int salary, String grade, Employee[] empList) {
		this.no = no;
		this.name = name;
		this.salary = salary;
		this.grade = grade;
		this.empList = empList;
	}
	
	public void info() {
		System.out.println("사번 : " + no + ", 이름 : " + name 
				+ ", 연봉 : " + salary + "만원, 직급 : " + grade);
		System.out.println("--------------------------------------------------");
		System.out.println("\t\t< 관리사원 리스트 >");
		System.out.println("--------------------------------------------------");
		for(Employee e : empList) {
			e.info();
		}
		System.out.println("--------------------------------------------------");
	}
}










