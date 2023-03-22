package kr.ac.kopo.day12.extend;
// **알아두면 좋은 점 f2누르면 이름 변경 가능 // 이름을 변경하면서 속해있는 코드도 같이 변경!
public class Manager02 extends Employee {
	int 		no;
	String 		name;
	int 		salary;
	String 		grade;
	Employee[] 	empList;	// 관리사원 목록
	

	public Manager02(int no, String name, int salary, String grade, Employee[] empList) {
		this.no = no;
		this.name = name;
		this.salary = salary;
		this.grade = grade;
		this.empList = empList;
	}
	
	public void info() {
		super.info();
		System.out.println("--------------------------------------------------");
		System.out.println("\t\t< 관리사원 리스트 >");
		System.out.println("--------------------------------------------------");
		for(Employee e : empList) {
			e.info();
		}
		System.out.println("--------------------------------------------------");
	}
}








