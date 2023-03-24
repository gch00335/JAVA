package kr.ac.kopo.day14_1Homework;
import java.util.Random;
import java.util.Scanner;

import kr.ac.kopo.day10.Homework.Teacher_ScannerUtil;

public class Secend {

		Teacher_ScannerUtil scan = new Teacher_ScannerUtil();

		// 랜덤 수 3자리 만들게 하기
		public void Start() {
			
			
			String q = new String();
			int Strik = 0;
			int ball = 0;
			int Homerun = 0 ;
			int Chance = 0 ; // 기회
		
			

			Random r = new Random();
			int random = r.nextInt(10);

			Random rr = new Random();
			int random2 = rr.nextInt(10);

			Random rrr = new Random();
			int random3 = rrr.nextInt(10);

			int a = (random * 100) + (random2 * 10) + (random3 * 1);
			System.out.println(a);
			
			


			
			Scanner sc = new Scanner(System.in);
			System.out.println("0 ~ 9사이 중 세자리 수를 말하시오");
			 q = sc.next();

			 
			while(Chance !=7)  {
				
			}
			//숫자 + 순서 모두 맞추면 스트라이크 
			if(q.charAt(0)==r.Start(0) &&q.charAt(1)==r.Start()&&q.charAt(2)==r.Start()){
				System.out.println("Homerun");
				Homerun ++;
			}// 숫자 + 순서 하나라도 맞추면 Strik
			else if (q.charAt(0)==q.charAt(0)||q.charAt(1)==q.charAt(1)||q.charAt(2)==q.charAt(2)){
				Strik ++;
				
				// 다 틀리면 ball
			}
			else if (q.charAt(0)==q.charAt(1)||q.charAt(0)==q.charAt(2)||q.charAt(1)==q.charAt(0)||q.charAt(1)==q.charAt(2)
					||q.charAt(2)==q.charAt(0) ||q.charAt(2)==q.charAt(1)){
				ball ++;
			}
			else {
				System.out.println("out");
				Chance++;
			}
			if(Chance == 7) {
				System.out.println("6기회 소진 : Game Over");
			}
			
		}
	}