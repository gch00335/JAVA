package kr.ac.kopo.day11.Homework;

import kr.ac.kopo.day10.Homework.Teacher_ScannerUtil;
// 이렇게 [import]를 써주면 다른패키지에 있어도 가져올 수 있다.

public class Teacher_icecreamMarket {
// 직접 구매하고 판매하는 것을 여기서 진행하게 하려고 함
	
	void open() {
	
		Teacher_ScannerUtil scan = new Teacher_ScannerUtil(); 
		
/* 접근제한에는 총 4개가 있는데 따로 설정은 안해두면 [default]	로 자동인식됨!
 * 누구에게나 보여주기 위한 설정(다른 패키지에 있어도 가져오려면) [public] 으로 작성을 해주어야 함 
 * 일반적으로생성자나 메소드의 접근제한자를 [public]으로 적어주는 것이 좋음
 * (public , protocted, default, private)	
 *    <------------------------------
 *        이방향으로 점점 커지는 단계임
 */
		
		
	int cnt = scan.nextInt("아이스크림 몇 개 입력할래? =>");
	Teacher_icecream[] iceArr = new Teacher_icecream[cnt]; // 여기서 만든 배열은 [아이스크림]의 배열은
	                            // 아이스크림의 이름과 가격의 이름들을 기억할 [참조변수]의 배열만 만들어진거임!
	                            // [new icecream]을 써서 객체를 만들어야 null공간에 들어가 코드에 인식됨
                                // 이러한 상황을 -> null 포인터 인셉션 (NullPointException)
	for(int i=0 ; i <iceArr.length ; i++) {
		//iceArr[0].name = " "; (이렇게 적으면 위에서 말한 (NullPointException) 발생 
		System.out.printf("***%d번째 아이스크림 구매정보 입력***\n" , i+ 1);
		String name = scan.nextString("아이스크림명 : ");
		int price = scan.nextInt("아이스크림가격 : ");
		
		iceArr[i] = new Teacher_icecream(name, price);
	}
		
		// 분명 스캐너를 두개입력시켰지만 코드를 실행하면 입력이 하나만 인식이됨
		// [입력버퍼] 때문임  - 엔터가 나올때가지 입력을 받는것
		// 정수만 받을 경우에는(공백이 있을 경우에는 무시를 함) 문제가 안생기나 문자열일경우에(공백이 있을경우에는 문자로 인식)는 버퍼로 인해 에러가 남
		/*
		 * 정수 : 123 정수 : 61을 입력받으라고 하면
		 * 123 (\n엔터) 후 61(\n엔터)를 입력한다.
		 * 원래 컴퓨터는  |   |   |   |   | 이렇게 버퍼에 아무것도 없으면 입력 후 엔터가 될 때까지 기다린다.
		 * 그럼 컴퓨터에는 | 1 | 2 | 3 | \n | (버퍼안에 입력하는 것) 이렇게 입력 후 엔터를 인식이된다.
		 * 정수에 \n에서 숫자가 끝났구나 인식하고 정수에 123을 입력하고 \n을 무시해버려 버퍼가 다시 비워져버리고
		 *    다시 |   |   |   |   | 이렇게 버퍼에 아무것도 없면 입어서 다름 입력을 기다린다.
		 * 
		 * 하지만 정수 -> 문자를 갈때라든지 문자에서 문자까지 사용할때는
		 * 위에 같은 상황에서 ' \n ' 을 무시하지 않고 문자로 인식해서 버퍼가 비워지지 않으므로 이미 받은걸로 인식이 되어 오류가 남!
		 *  그렇기에
		 * 꼭 sc.nextLine(); // 버퍼가 비워지지 않도록 이것을 꼭 int 다음에 적어줘야함 
		 * ex) 
		 *   int nextInt(String msg) {
	         System.out.println(msg);
		     int num =sc.nextInt();
		     sc.nextLine(); // 버퍼가 비워지지 않도록 이것을 꼭 int 다음에 적어줘야함
		     return num;
		 * 
		 * 
		 */
		// 여기서 [버퍼buffer]란 예를들면 콩을 옮겨야하는 상황속에서, 한알씩 양쪽의 항아리에 옮겨야 하는 상황에서 세알이 필요한 경우
		// 한알씩 세번을 옮겨야할 것은 비효율적이기에 바가지를 이용해 콩을 잔뜩 푼 후 그 중 세알만꺼내 다른 항아리로 옮기는 것
		// 여기서 옮겨야 하는 콩의 수를 무시하고 잔뜩 퍼서 꺼내 효율적으로 빠르게 해주는 바가지를 [버퍼]라고 함!
		// 하지만 [버퍼]는 효율적이긴하나 필요한 수만큼의 콩이 바가지에 없을 경우 에러가 남!
	System.out.printf("<총 %d개 아이스크림 구매정보 충력 >\n", iceArr.length);
	System.out.println("----------------------------------------------");
	System.out.println("번호\t 아이스크림면\t아이스크림 가격");
	System.out.println("----------------------------------------------");
	for(int i=0 ; i<iceArr.length ; i++) {
		System.out.println(i+1 + "\t" + iceArr[i].getname() + "\t" + iceArr[i].getprice());
	}
	System.out.println("----------------------------------------------");
	Teacher_icecream.totalnfo();
		
		
	}
}

