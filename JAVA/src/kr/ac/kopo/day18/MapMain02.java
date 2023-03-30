
package kr.ac.kopo.day18;

import java.util.HashMap;
import java.util.Map;

class Employee{
	private String name;
	private String phone;
	
	Employee(String name, String phone){
		this.name = name ;
		this.phone = phone ;
		 
	}
	//하나씩 쓰는 방법도 있지만 
	//이클립스가 자동으로 만들게 해주는 방법도 있다! 
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		return true;
	}
	
	
}
 // 주차가 되어있는지 차량번호를 통해 아는 프로그램 짜기 //
class Car {
	String model ;
	String no;
	
	Car(String model, String no){
		this.model = model ;
		this.no = no;
	}
}
public class MapMain02 {

	public static void main(String[] args){
		//﻿equals 메소드 값이 리턴 값이 true 이고 , hashcode 값 도 동일해야 같게 인식이 된다..
		
		String s = "Hello";
		String s2 = new String("Hello");
		System.out.println(s.hashCode());
		System.out.println(s2.hashCode());
		
		Employee e = new Employee("홍길동", "010-1111-2222");
		Employee e2 = new Employee("홍길동", "010-1111-2222");
		Employee e3 = new Employee("홍길동", "010-1111-2223");
		
	
		
		/*	if(e==e2) {
			System.out.println("같다");
		} else {
			System.out.println("다르다");
		}
		// 우리가 생각한대로 덮어쓰는거라면 저e와 e2 서로 같다고 나와야 한다.
		// 하지만 실행결과는 '다르다'라고 나온다.
		// 왜냐하면 저 e와 e2는 같은 이름으로 설정하려 했지만 기억하는 위치가 다르기 때문!
		// 저 둘은 서로 다른 위치의 주소를 입력하고 나타내고 있기때문에 서로 다른 객체로 인식하는 것이다. */
		
		
		//그렇기 때문에 제대로 된 비교를 위해서는 equals(같은지 비교하는 코드)를 쓰면 될까? 하지만
		// 이것또한 다른객체로 인식된다고 나온다.
		//객체비교를 하기위해서는 위치비교가 아닌 , [홍길동]과[번호]가 같은지 비교하기 위해서 Employee내에서 오버라이딩이 필요한것!
		if(e.equals(e2)) {
			System.out.println("같다");
		} else {
			System.out.println("다르다");
		}
		
		System.out.println(e.toString());
		System.out.println(e2.toString());
		System.out.println(e3.toString());
		
		
	Map <Employee, Car> carList = new HashMap<>();
	
	carList.put(new Employee("홍길동", "010-1111-2222"),
			new Car("소나타", "123나4567"));
	carList.put(new Employee("고길동", "010-3333-4444"),
			new Car("산타페", "234라3416"));
	carList.put(new Employee("한길동", "010-7777-8888"), 
			new Car("K5", "567무2478"));
	carList.put(new Employee("홍길동", "010-1111-2222"), 
			new Car("벤츠", "346구7367"));
	
	// 홍길동이 차를 바꿨을 경우에 대해 코드 이렇게 짰을때
	// 프로그램 실행시 (홍길동 차에 또다른차를)덮어쓴거니까 등록된 차량수는 3대가 나와야하는데 덮어써지지 않고 4대라고 나옴..!
	// 이것이 문제! 왜 그런건지 ! 어떻게 해야하는지 알아보자
		
	
	
	System.out.println("등록된 차량대수 : " + carList.size());
	}
}
