package kr.ac.kopo.day04;
import java.util.Scanner; 
public class homework02 {

	public static void main(String[] args) {
		//문제 2번
/*물건값을 입력하고, 돈을 지불했을 때 거스름돈과 잔액을 표시하는 코드를 작성하시오
   물건값을 입력 : 4230
   지불한 돈 입력 : 10000
   
   거스름돈 : 5770원
   1000원 : 5개
    500원 : 1개
    100원 : 2개
     50원 : 1개
     10원 : 2개
        
   물건값을 입력 : 4230
   지불한 돈의 액수 : 3000
   1230원이 부족합니다*/
		
		Scanner sc = new Scanner(System.in);
		int price;
		int pay;
		int charge;
		
		System.out.println("물건값을 입력 : ");
		price = sc.nextInt();
				
		System.out.println("지불한 돈 입력 :");
		pay = sc.nextInt();
		
		charge = pay - price;
		System.out.println("\n");
		
		int th = charge/1000;
		int hun = (charge%1000)/100;
		int tt = charge% 100 /50;
		int ten = charge%50/10; // 50의 배수여서 %50을 했어도 됬지만 
		//올바른 코드는 %1000%500%100%50/10 이렇게 구해야 올바른 식임!! *10원 구하는 식!
		
		System.out.println("거스름돈 :" + charge + "원");
		System.out.println("1000원 : " + (int)(th) + "개");
		System.out.println("500원 : " + (int)(hun>=5 ? 1:0) + "개");
		System.out.println("100원 : " + (int)(hun>=5 ? hun-5:hun) + "개");
		System.out.println("50원 : " + tt + "개");
		System.out.println("10원 : " + ten + "개");
		System.out.println("\n");
		System.out.println(price + " 원 : 물건 값");
		System.out.println(pay + " 원 : 지불한 돈");
		System.out.println(charge + "원이 부족합니다");
	
	
	
	

	
	
	}

}
