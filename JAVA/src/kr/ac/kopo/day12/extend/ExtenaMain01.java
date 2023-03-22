package kr.ac.kopo.day12.extend;

class One {
	One(){
		System.out.println("One() 생성자 호출...");
	}
}
class Two extends One {
	Two() {
		
		System.out.println("Two() 생성자 호출...");
	}
}

class Three extends Two{
	Three(){
		System.out.println("Tree() 생성자 호출...");
	}
}
public class ExtenaMain01 {

	public static void main(String[] args) {
		//new One();  // 이렇게 생략을 해도 one이 같이 나오는 이유는 Two와 하나로 묶여있기 때문
		//new Two(); // 이렇게 생략해도 Three는 Two가 서로 묶여있음
		new Three(); // 상속관계는 두개로만 이루어져있음 Three가 one까지 이어져있는게 아니라 Two로 이어져있음 
		             // 바로 윗 관계만 연결되어있지, 위에 위에까지 (아빠의 아빠가 누구인지까지는 궁금하지 않음!)

	}

}
