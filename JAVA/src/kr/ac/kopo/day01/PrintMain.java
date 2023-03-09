package kr.ac.kopo.day01;

/*

 출력메소드 system.out.출력메소드()
 print()   : 개행문자x
 println() : 개행문자o
 printf()  : 1.5버전이후에 만들어짐, 개행문자x
 */
public class PrintMain {

	public static void main(String[] args) {

		System.out.printf("%d %2f %s\n", 10, 12.34, "홍길동");

		System.out.println(10 + " " + "12.34" + " " + "홍길동");

		System.out.println('A' + 'B');

		// 10 12.34 홍길동
		System.out.print(10);
		System.out.print(' ');
		System.out.print(12.34);
		System.out.print(' ');
		System.out.println("홍길동");

		System.out.print('홍');

		// 방법3
		System.out.print("A\n");
		// 방법2
		System.out.print('A');
		System.out.print('\n');
		// 방법1
		System.out.println('A');

		System.out.println(10);
		System.out.println(12.34);

	}
}
