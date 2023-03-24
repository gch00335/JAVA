package kr.ac.kopo.day13.abs01;

import java.util.Scanner;

public class PrinterView {
	
	private Scanner sc = new Scanner(System.in);

	public void work() {
		System.out.println("출력할 프린터를 선택하세요(1. LG 2. SAMSUNG) : ");
		int choice = sc.nextInt();
		sc.nextLine();
		
		switch(choice){
		case 1 :
			LGPrinter lg = new LGPrinter();
			lg.lgPrint();
			
			break;
		case 2 :
			SanmsungPrinter sam = new SanmsungPrinter();
			sam.samPrint();
			break;
		
			
		}
		
	}
}
