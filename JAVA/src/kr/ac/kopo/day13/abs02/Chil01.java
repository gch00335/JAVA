package kr.ac.kopo.day13.abs02;

public class Chil01 extends Parent {
	private String name = "자식01";
	private int age = 20 ;
	
	 @Override
	 public void info() {
		 System.out.println("나는"+ name + "이고, 나이는"+age + "이다");
		 
	 }

	 public void study() {
		 System.out.println("나는 공부를 합니다");
	 }
	 public void sleep() {
		 System.out.println("나는 잠을 잡니다");
		 
	 }
}
