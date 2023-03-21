package kr.ac.kopo.day11.stat;

public class Employee {

	int no;
	String name;
	int salary;
	String grade;
	static int employeeCnt; // 총 사원수에 대한 값 - > new 가 나올떄마다 늘어나므로 생성자를 이용해서 계산해보면 됨
// 클래스 당 하나로만 인정되면 되기에 'static'를 붙여주어야 함 

	Employee(){
		++employeeCnt;
	}
	Employee( int no, String name, int salary, String grade){
		this.no=no;
		this.name=name;
		this.salary = salary;
		this.grade = grade;
		employeeCnt++;

	}
	void info() {
		System.out.println("사번 :" + no + ", 이름 :" + name + ",연봉 :"+ salary + "만원, 직급 : " + grade);
	}
	static void employeeCntInfo() {
		System.out.println("입사한 총 사원 수 : " + Employee.employeeCnt + "명");
	} // 마음대로 볼 수(공개)있는 변수라는 것은 언제나 자유롭게 마음대로 고칠 수도 있다는 것
      //그렇기에 해당 클래스에 메소드를 만들어놓고 호출해서 쓰는게 좋다

}
