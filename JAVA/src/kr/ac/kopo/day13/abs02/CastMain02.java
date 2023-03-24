package kr.ac.kopo.day13.abs02;

public class CastMain02 {
	public static void main(String[] args) {
		
		// 참고로 Parenet 가 상위클래스 Chil 가 하위클래스로 만들어져있음(상속)
	
		
		
		
		
		
		Parent p = new Chil01 ();
		Chil01 c = (Chil01)p; //이렇게 하면 오류가 나지 않음
		
		
		
	//  밑에 방식처럼 [Parent p = new Chil01();] chil에도 를 가리키고 싶어서 chil01 c = p 라고 해도 오류가 남	
	//	Parent p = new Chil01();
	//	자식클래스 타입 = (자식클래스)부모클래스타입
		
		
		// 실행 시 오류 방생
//		Chil01 c = (Chil01)new Parent(); //이렇게 설정했음에도 오류 발생함 // 메모리가 부족하다는 이유로
		
		// 컴파일 오류발생
//      Chil01 c = new Parent();
		//이렇게 작성하면 오류가 발생함 왜냐하면 chil01에 자리가 작기때문이다.
		
	}

}
