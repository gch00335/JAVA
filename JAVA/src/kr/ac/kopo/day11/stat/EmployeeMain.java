package kr.ac.kopo.day11.stat;

public class EmployeeMain {

	public static void main(String[] args) {
	
		// 중요한건 여기서 , 클래스는 이미 소프트웨어와 동시에 생성되었기에 객체를 생성하지 않고동 호출이가능해야함
		// 객체를 생성하지 않아도 호출할 수 있는 기능이 바로 'static'  이것을 이용하는 것.
		
		Employee.employeeCntInfo();		
		
		//System.out.println("입사한 총 사원 수 : " + EmployeeMain.employeeCnt + "명"); 
		//이 한줄만 적어도 총 명수를 알 수 있다.(new 객체를 따로 만들지 않고 클래스명으로 접근!)
		// 생성자로도 접근해도 되는 것이 가능하나, 되도록이면 클래스명으로 접근하는 것이 좋다.
		
		
		
		Employee e = new Employee(1, "홍길동", 3_400, "사원"); // 돈의 금액을 한번에 알 수 있도록 3_400 해주면 좋음
		
		Employee e2 = new Employee(2,"고길동",3_700,"주임");
		
		Employee e3 = new Employee(3,"임길동", 3_500, "사원");
		
 
		e.info();
		e2.info();
		e3.info();
		
		//System.out.println("입사한 총 사원 수 : " + Employee.employeeCnt + "명");
		// 총 3개의 합이 나오길 원했지만 결과는 한개만 나옴
		// 그 이유는 새로운 new를 만들어도 그건 각각의 독립적으로 인정하기때문에 총 하나로만 인정되는 것
		
		
		// * 알아두면 좋은 특징 [ctrl] + [del] 누르면 한 줄 바로 지우기 가능함!
		
		
		//객체를 형성해야 호출이 가능!
		Employee.employeeCntInfo();
	}

	}
	


