package kr.ac.kopo.day11.Homework;

import java.util.Scanner;

public class Scannerutil { //오늘 배운 스캐너클래스 활용해보자!!

	Scanner sc;
	Scannerutil() {
	sc = new Scanner(System.in); 
}
	//문자 입력
	String str(String msg) {
		System.out.println(msg);
		return sc.nextLine();
	}
	// 숫자입력
	int getInt(String msg) {
		System.out.println(msg);
		return sc.nextInt();

	
	}
}
