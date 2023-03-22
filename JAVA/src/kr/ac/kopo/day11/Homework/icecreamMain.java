package kr.ac.kopo.day11.Homework;

public class icecreamMain {


	
	public static void main(String[] args) {
		icecream ice = new icecream();
	
		System.out.println("아이스크림 몇 개 구입할래?");
		Scannerutil sc = new Scannerutil();
		int num = sc.getInt("");
	
		
		for(int i = 1 ; i<=num ; i++) {
		System.out.println("***"+ i +"번째 아이스크림 구매정보 입력***");
		String name = sc.str("아이스크림명 :");  // 왜 계속 입력이 안될까.. 숫자만 입력되고 왜 이름은 안될까..이걸해야 2번을 넘어가는데..
		
		System.out.println();
		int price = sc.getInt("아이스크림 가격 :"); 
		
		
	}
	
		System.out.println();
		System.out.println("<총"+ num + "개의 아이스크림 구매 정보 출력 >");
		System.out.println("번호\t" + "아이스크림\t" + "아이스크림 가격\t");
		ice. payer();
	}
	
}

	 
