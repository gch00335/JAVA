package kr.ac.kopo.day14_1Homework;

import java.util.Random;
import java.util.Scanner;

import kr.ac.kopo.day10.Homework.Teacher_ScannerUtil;

public class Quiz {

	Teacher_ScannerUtil scan = new Teacher_ScannerUtil();;

	// 랜덤 수 3자리 만들게 하기
	public void Start() {

		int q = 0;
		int Strik = 0;
		int ball = 0;
		int Homerun = 0;
		int Chance = 0; // 기회
		int out = 0;


		Random random = new Random();
		int r = random.nextInt(10); 

		int rr = r;
		for (  ; r == rr ; ) {
			rr =random.nextInt(10);
		}

		int rrr = rr;
		for(  ; r==rrr ||rr== rrr; ) { 
			rrr= random.nextInt(10); 
		}


		
		int an = (r * 100) + (rr * 10) + (rrr * 1);

		System.out.println(an);
		
		
		while (Chance != 7) {
			Scanner sc = new Scanner(System.in);
			System.out.println("0 ~ 9사이 중 세자리 수를 말하시오");
			q = sc.nextInt();

			int m = q / 100; // 100단위 m = q % 100
			int t = q % 100 / 10; // 10단위 t = q%100 - m
			int o = q % 100; // 1 단위 0 =

			// 숫자 + 순서 모두 맞추면 홈런
			if (m == r && t == rr && o == rrr) {
				System.out.println("Homerun");
				Homerun++;
				break;
			} // 숫자 + 순서 하나라도 맞추면 Strik
			else if (m == r || t == rr || o == rrr) {

				Strik++; 
				System.out.printf("%dStrik\n", Strik);
				 
				// 숫자는 맞지만 순서가 다르면 ball
			} else if(r == t || r == o || rr == m || rr == o || rrr == m || rrr == t) {
				ball++;
				System.out.printf("%dball\n", ball);
			} else  { // 다 틀리면 out
				System.out.printf("%dout\n", out);
				out++;
			}
			if (Chance == 7 || out ==3 ) {
				System.out.println("기회 소진 : Game Over");
				break;
			}

		}
	} 
}


		
		
		
		
		
		
		
		
		
	