package kr.ac.kopo.day12.extend;

public class Manager03 extends Employee {
	// 위에 있는 내용을 지웠지만
	// Emplopyee 에 속해있으므로
	//no,name,salary,grade를 지정하지 않아도 나올 수 있다!
	
	Employee[] 	empList;	// 관리사원 목록
	
	public Manager03() {
		
	}
	
	public Manager03(int no, String name, int salary, String grade, Employee[] empList) {
		
		// 여기서 속해있기에 this 말고도 super를 써도 된다
		super(no,name, salary, grade);
		this.empList = empList;
	}
	//오버라이딩 : super 외에 새로운 걸 정의//
	@Override // -> 이 주석을 적어주는 이유는 부모에 속해있을 때 달라서 틀리는 오류를 찾아준다.
	          // 이게 없으면 상속관계에 있어서 달라져 오류가 나는 것을 발견하기 힘들다.
	public void info() { 
		super.info();
		//System.out.println("사번 : " + no + ", 이름 : " + name + ", 연봉 : " + salary + "만원, 직급 : " + grade);
		//부모에도 속해있는 같은 말이기에 굳이 적지 않고 [super]을 적어도 가능하다.

		Manager03 m = new Manager03(100, "나최고", 10000, "부장", empList);
		System.out.println("--------------------------------------------------");
		System.out.println("\t\t< 관리사원 리스트 >");
		System.out.println("--------------------------------------------------");
		for(Employee e : empList) {
			e.info();
		}
		System.out.println("--------------------------------------------------"); 
	}
}











