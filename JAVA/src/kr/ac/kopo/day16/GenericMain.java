package kr.ac.kopo.day16;

import kr.ac.kopo.day15.inter.LGTV;


class A {
	private Object member;
	
	A(Object member) {
		this.member = member;
	}
	
	Object getMember() {
		return member;
	}
}
class B<T> { // 원하는 타입으로 바뀌는 것  // 제너릭
	private T member;
	
	B(T member) {
		this.member = member;
		
	}
	T getmember() {
		return member;
	}
}
//그래서 리스트를 제너릭으로 만듦

class List<t> {
}


public class GenericMain {

	public static void main(String[] args) {
		
		B<String> b1 = new B<String>("Hello"); // 문자열을 저장하는 제네릭을 만들고 싶어
		B<LGTV> b2 = new B<LGTV>(new LGTV()); // 타입이 LGTV형으로 바뀜
		
		//제너릭이 좋은 이유 - 타입이 안맞으면 컴파일시점에서 오류가 남/ 
        //                 이러한 오류를 적어지게 할 수 있다.
		// 매번타입에 대해 미리 보여줌 
		// 형변화을 해줄필요가 없고, 문법적인 문제가 거의 없음
		
		A a1 = new A("hello");
		String str = (String)a1.getMember();
		System.out.println("문자열의 길이 : " + str.length());		
		
		A a2 = new A(new LGTV());
		LGTV tv = (LGTV)a2.getMember();
		tv.powerOn();
	}
}
