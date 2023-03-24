package kr.ac.kopo.day10.Homework;

import java.util.Scanner;

public class Teacher_ScannerUtil {
/**
 * 
 * 다양한 상수를 입력받을 수 있는 기능 클래스
 * @auther User
 */

	Scanner sc;
	
	public Teacher_ScannerUtil(){ // 생성자 형성
	sc = new Scanner(System.in);
	}
	
	public char nextchar(String msg) { // 하나의 메세지를 받고 리턴하겠다.
		System.out.println(msg);
		char ch = sc.nextLine().charAt(0);
		return ch;
		//return sc.nextLine().charAt(0); // 위에 두줄을 이렇게 한줄로도 표현할 수 있다. 
	}
	public int nextInt(String msg) {
		System.out.println(msg);
		int num =sc.nextInt();
		sc.nextLine(); // 버퍼가 비워지지 않도록 이것을 꼭 int 다음에 적어줘야함
		return num;
	}
	public String nextString(String msg) {
		System.out.println(msg);
		String str = sc.nextLine();
		return str;
	}


	}
	
	


