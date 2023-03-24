package kr.ac.kopo.day13.abs02;

import java.util.Scanner;

public class PrinterView {
	
	private Scanner sc = new Scanner(System.in);

	public void work() {
		System.out.println("출력할 프린터를 선택하세요(1. LG 2. SAMSUN 3. HP : "); 
		int choice = sc.nextInt();
		sc.nextLine();
		
		Printer p = null ;
		switch(choice){
		case 1 :
			p = new LGPrinter(); // 부모의 참조변수를 자식값으로 받으로 있을 수 있어서 이렇게 지워도 가넝!!
			break;
		case 2 :
			p = new SanmsungPrinter(); //  만약 삼성을 지우고 삼성자리에 HP를 하고 싶다고 하면
		                              // 저 삼성만지우고 HP  로 바꿔 적으면 바로 적용이 된다 --> 이것이 추상메소드의 가장 큰 장점
			break;
			default : 
				System.out.println("잘못입력하셨습니다.");
		
			
		}
		if(p != null) {
		p.print();  // 부모의 값을 참조변수로 설정 후  switc 밖으로 [p.print]는 같아서 빼서 적는 방법도 설정이 가능하다..!
		
	}
}
}





/* 방법1
switch(choice){
case 1 :
	LGPrinter lg = new LGPrinter(); // 부모의 참조변수를 자식값으로 받으로 있을 수 있어서 이렇게 지워도 가넝!!
	lg.Priner();
	
	break;
case 2 :
	SanmsungPrinter sam = new SanmsungPrinter();
	sam.Priner();
	break;
*/

/* 방법2
switch(choice) {
case 1: 
	Printer lg = new LGPrinter();
	lg.print();
	break;
case 2 : 
	Printer sam = new SamsungPrinter();
	sam.print();
	break;
}
*/