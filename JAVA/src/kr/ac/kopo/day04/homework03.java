package kr.ac.kopo.day04;
import java.util.Scanner;

public class homework03 {

	public static void main(String[] args) {
	
/*3개의 정수를 입력받아 작은수에서 큰수순으로 출력하는 코드 작성
  정수 3개를 입력 : 12 7 22
  num1, num2, num3
  첫번째 정수 : 12
  두번째 정수 : 7
  세번째 정수 : 212
  
  7  12  22 */
	Scanner sc = new Scanner(System.in);	
    System.out.println("정수 3개 입력크기 비교");
	
    System.out.println("첫번째  :");
    int a = sc.nextInt();
    
    System.out.println("두번째  :");
    int b = sc.nextInt();
    
    System.out.println("세번째  :");
    int c = sc.nextInt();
    
   
	if(a>b) {
		if(a>c) {
			if(b>c) {System.out.printf("첫번째 정수 : %d 두번째 정수 : %d 세번째정수 : %d", a, b, c);
			} else {
				System.out.printf("첫번째 정수 : %d 두번째 정수 : %d 세번째정수 : %d", a, c, b);
			}
			} else {
				System.out.printf("첫번째 정수 : %d 두번째 정수 : %d 세번째정수 : %d", c, a, b);
			}
		} else {
			if(b>c) {
				if(a>c) {
					System.out.printf("첫번째 정수 : %d 두번째 정수 : %d 세번째정수 : %d", b, a, c);
				} else {
					System.out.printf("첫번째 정수 : %d 두번째 정수 : %d 세번째정수 : %d", b, c, a);
			}
		}
			else {
				System.out.printf("첫번째 정수 : %d 두번째 정수 : %d 세번째정수 : %d", c, b, a);
}
		}
	}
}