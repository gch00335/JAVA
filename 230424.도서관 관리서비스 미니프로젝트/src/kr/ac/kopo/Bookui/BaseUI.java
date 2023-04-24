package kr.ac.kopo.Bookui;

import java.util.Scanner;

public class BaseUI  {
private Scanner sc;
	
	
	public BaseUI() {
		sc = new Scanner(System.in);
	
	}
	
	protected int scanInt(String msg) {
		System.out.print(msg);
		int num = Integer.parseInt(sc.nextLine());
		return num;
	}
	
	protected String scanStr(String msg) {
		System.out.print(msg);
		return sc.nextLine();
	}
}



