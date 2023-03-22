package kr.ac.kopo.day12.Homework;

import kr.ac.kopo.day10.Homework.Teacher_ScannerUtil;

public class IceCreamMarket {
void open() {
		
	Teacher_ScannerUtil scan = new Teacher_ScannerUtil(); 
		
		int cnt = scan.nextInt("아이스크림 몇개 입력할래? => ");
		IceCream[] iceArr = new IceCream[cnt];
		
		for(int i = 0; i < iceArr.length; i++) {
			System.out.printf("*** %d번째 아이스크림 구매정보 입력 ***\n", i+1);
			String 	name  = scan.nextString("아이스크림명 : ");
			int 	price = scan.nextInt("아이스크림가격 : ");
			
			iceArr[i] = new IceCream(name, price);
		}
		
		System.out.printf("< 총 %d개 아이스크림 구매정보 출력 >\n", iceArr.length);
		System.out.println("----------------------------------------");
		System.out.println("번호\t아이스크림명\t아이스크림가격");
		System.out.println("----------------------------------------");
		for(int i = 0; i < iceArr.length; i++) {
			System.out.println(i+1 + "\t" + iceArr[i].getName() 
					+ "\t\t" + iceArr[i].getPrice());
		}
		System.out.println("----------------------------------------");
		IceCream.totalInfo();
		
	}
}












