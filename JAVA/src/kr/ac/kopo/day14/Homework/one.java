package kr.ac.kopo.day14.Homework;

public class one {

protected 	int a;
protected 	int b;
public 		int c;

public void print() {
	System.out.println("a : " + this.a);
	System.out.println("b : " + this.b);
	System.out.println("c : " + this.c);
}
}

class Two extends one {
	
	private 	int a;
	protected 	int b2;
	public 		int c2;

	public void print() {
		this.a= 10; // 지금 one클래스에서 private 	int a; 는 자신의 클래스에서만 보이게 설정했기에 
		super.a= 10;   // super과 two클래스 서로 다른 클래스여서 수정이 불가능하다. 같은 이름이라 할지라도 오직 this로만 자기 것만 수정 가능
		              
		this.c = 10;  // 하지만 b와 c는 protected 	int b; //public int c; 이렇게 볼 수 있는 접근제한자가 있어서 
		super.c = 10 ; // this 로 자신의 클래스에 있는 것 수정외에도 super를 이용해 부모것도 수정 가넝
		
	
	}




public static void main(String[] args) {
	
}
}
