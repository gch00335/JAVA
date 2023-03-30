package kr.ac.kopo.day17.Homework;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class LottoView01_Teacher2 {

	
private static final int Random = 0;

private Random r = new Random() ;

public void start() {
	
	System.out.print("게임수를 입력 : ");
	Scanner sc = new Scanner(System.in);
	int gameCnt = sc.nextInt();
	for(int i = 1; i <= gameCnt; i++) {
		System.out.println("게임 " + i + " : " + Arrays.toString(getLotto()));
	}
	
}

 private int[] getLotto() {
	 int[] lottoNums = new int[6];
	 boolean[]flags = new boolean[45]; // 0 ~ 44
	 
	 for(int i= 0 ; i < lottoNums.length ; ) {
		 int random = r.nextInt(45);
		 if(!flags[random]) { // 우리가 이걸 배웠어..? 느낌표하나만 붙이는거? != 이뜻인가..?
			                 // 몰겠ㄷ..이것도 주말에 복습
		 lottoNums[i++] = random + 1 ;
		 flags[random] = true ;
	 } else
		 System.out.println('!');
	 
 }
	return lottoNums;
}
}