package kr.ac.kopo.day12.extend;

public class ExtendMain02 {

	public static void main(String[] args) {
		
		Employee e = new Employee(1, "홍길동", 4000, "사원");
		Employee e2 = new Employee(2, "고길동", 4200, "사원");
		Employee e3 = new Employee(3, "강길동", 5000, "대리");
		Employee e4 = new Employee(4, "임길동", 5500, "과장");
		
		e.info();
		e2.info();
		e3.info();
		e4.info();
		
		Employee[] empList = {e, e3, e4};
		
		Manager02 m = new Manager02(100, "나최고", 10000, "부장", empList);
		//Manager03 m = new Manager03(100, "나최고", 10000, "부장", empList);
		
		m.info(); 
	}
}

				
				