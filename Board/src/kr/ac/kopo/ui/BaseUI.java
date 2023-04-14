package kr.ac.kopo.ui;

import java.util.Scanner;

public abstract class BaseUI implements IBoardUI {
// [implements IBoardUI ] 그런데 이 최고봉은 전달만 해주는 거지, 따로 정의를 해줄 필요가 없기 때문에
//추상메소드[abstract]를 만들어줘야함!! 
	
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

