package kr.ac.kopo.day10;

public class ConstrucutorMain02 {

	public static void main(String[] args) {
	/*Member m = new Member();
	m.name= "홍길동";
	m.age = 25;
	m.bloodType="A";
	*/
		
		
		
		Member m = new Member("홍길동" , 25, "A");
		Member m2 = new Member();
		Member m3 = new Member("홍길순");
		Member m4 = new Member("강길동",30);
		
		m.info();
		m2.info();
		m3.info();
		m4.info();
	}

}
