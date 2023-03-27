package kr.ac.kopo.day14_1Homework;

import java.util.Random;
import java.util.Scanner;

import kr.ac.kopo.day10.Homework.Teacher_ScannerUtil;

public class ballQuiz {


	Teacher_ScannerUtil scan = new Teacher_ScannerUtil();

	// 랜덤 수 3자리 만들게 하기
	public void Start() {
	
		int q = 0; // 내가 입력한 숫자
		int Strik = 0;
		int ball = 0;
		int Homerun = 0;
		int Chance = 0; // 기회
		int out = 1;


		Random random = new Random();
		
		int r1 = 0  ;
		int r2 = 0 ;
		int r3 = 0 ;
		

		while(r1 == r2 || r2== r3 || r1 ==r3) {
			 r1 = random.nextInt(10); 
			 r2 = random.nextInt(10);
			 r3 = random.nextInt(10);	
		} 
			
		
		int Random[] = { r1, r2, r3 };
		
	//	System.out.println(Arrays.toString(Random)); // 컴퓨터가 뽑아낸 숫자 확인용

		// 기회 6번 설정
		while (Chance !=6) {
			Scanner sc = new Scanner(System.in);
			System.out.println("0 ~ 9사이 중 세자리 수를 말하시오");
			q = sc.nextInt();

			int m = q / 100; // 100단위 
			int t = q % 100 / 10; // 10단위
			int o = q % 100 % 10;// 1 단위

			int num[] = { m, t, o };
			// System.out.println(Arrays.toString(num)); // 내가 한거랑 컴퓨터랑 비교해보기 확인용
			
			// ball과 strik 나오게 할 규칙. 볼과 스트라이크는 총 3번으로 나타내니까 i , j 가 3이 나오면 나오게 하기
			for (int i = 0; i < Random.length ; i++) {
				for (int j = 0; j < num.length; j++) {
					if (i == j) {
							if (Random[i] == num[i]) {
								Strik++;				
							
							//	System.out.println(Random[i] + " value " + num[j]); 내가 생각한대로 for문 돌아가는지 확인용
						}
					} else if (Random[i] == num[j]) {
						++ball;
						
					}

				}

			} 
			Chance ++ ; // 한번 돌때마다 기회 플라스!

			
			//스트라이크 3번이면 '스트라이크' 대신 '홈런'이 나오게 설정
			if (Strik == 3) { 
				System.out.println("Homerun");
				break;
			}

			System.out.printf("%dStrik\t , %dball\n ", Strik, ball);
			Strik = 0;
			ball = 0;

			// 숫자 + 순서 모두 맞추면 홈런
			if (m == r1 && t == r2 && o == r3) {
				System.out.println("Homerun");
				Homerun++;
				break;

			} else if (m != r1 && m != r2 && m != r3 && t != r1 && t != r2 && t != r3 && o != r1 && o != r2
					&& o != r3) {
				// 다 틀리면 out
				System.out.printf("%dout\n", out);
				out++;
				Chance++; // 아웃일때도 찬스가 올라가게!
				
				// game over 의 규칙 : 아웃 3번 되었을 때 
			} if (out == 4) {
					System.out.println("기회 소진 : Game Over");
					break;

				// game over 의 규칙 :기회 6번 되었을 때 
			}if (Chance == 6)   {
					System.out.println("기회 소진 : Game Over");
					break;
				}

			}
		}
	}


