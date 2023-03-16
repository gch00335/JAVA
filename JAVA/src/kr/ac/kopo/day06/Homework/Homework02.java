package kr.ac.kopo.day06.Homework;

public class Homework02 {

	public static void main(String[] args) {
		/*
		 * 1. 다음의 결과를 보이는 프로그램을 작성하시오 (1~4)
		 * 
		 * 4) 달팰이가 100m 깊이의 우물에 빠졌습니다. 달팽이는 한시간에 5m씩 우물을 기어오릅니다. 달팽이가 올라간 높이가 50m미만일때는
		 * 1시간에 1m씩 미끌어지고 50m이상일때는 1시간에 2m씩 미끌어집니다. 달팽이가 몇 시간만에 우물을 탈출하는지 코드로 작성하시오
		 * [1시간후] 달팽이가 올라간 총 높이 : 4M [2시간후] 달팽이가 올라간 총 높이 : 8M ... [XX시간후] 달팽이가 올라간 총 높이
		 * : 100m , 101m, 102m
		 */
		// 규칙 h = 1 시간 + 5 / 50m 미만 -1 ,50m이상 -2 /

		// k가 거리 , i 시간

		int k = 0;

		for (int i = 1; i <= 100; i++) {
			k = k+=5;
			if (k < 50) {
				k--;
				System.out.printf("[" + "%d" + "시간 후] 달팽이가 올라간 총 높이 :" + "%d" + "m"+ "\n", i, k);
			} else {
				k -= 2;
				System.out.printf("[" + "%d" + "시간 후] 달팽이가 올라간 총 높이 :" + "%d"+"m" + "\n", i, k);
			}
			if (k >= 100) {
				break;
			}
		}

		System.out.println();
		System.out.print("교수님 사랑합니다");
	}
}
// 교수님께서 알려주신 방법
/* 
 * [방법 1] 
 int snail = 0 , hour =0;

while(snail<100)   // for 문 보다는 while이 더 좋음
snail +=5;
snail += (snail < 50 ? -1 : -2);
System.out.printf("[%d 시간 후] 달팽이가 올라간 총 높이 : &d\n", ++hour,snail);
}
}


[방법2]
 int snail = 0 , hour =0;

while((snail+=5) <100)   // 달팽이가 100m를 갔음에도 - 되는 규칙때문에 30시간 102m 찍히는데 
                            굳이 규칙을 먼저하지 않고 100m달성시 멈추는것을 규칙으로 해보기
snail +=5;
snail += (snail < 50 ? -1 : -2);
System.out.printf("[%d 시간 후] 달팽이가 올라간 총 높이 : &d\n", ++hour,snail);
}
System.out.printf("[%d 시간 후] 달팽이가 올라간 총 높이 : &d\n", ++hour,snail); 
// 한번 더 적어줘야함! (최종 몇 m / 몇 시간인지 알 수 있도록)
}


[방법3]
int snail = 0 , hour =0;

while(snail <100) {
snail += (snail < 50 ? 5-1 :5-2);
System.out.printf("[%d 시간 후] 달팽이가 올라간 총 높이 : &d\n", ++hour,snail);
}

 */

