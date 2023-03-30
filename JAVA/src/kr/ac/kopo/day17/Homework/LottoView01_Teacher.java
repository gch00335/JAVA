package kr.ac.kopo.day17.Homework;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class LottoView01_Teacher {

	
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
		loop: for (int i = 0; i < lottoNums.length;) {
			lottoNums[i] = r.nextInt(45) + 1;
			boolean bool = true;
			for (int j = 0; j < i; j++) {
				if (lottoNums[i] == lottoNums[j]) {
					System.out.print('!'); // 중복체크를 하고 있다는 의미로 표시
					continue loop; // 이렇게 원하는 방향으로 바로가게 설정할 수 있다.
				}
			}
			if (bool) {
				i++;
			}
		}
		return lottoNums;
	}
}
	 
	 
	 
	/*
	 int[] lottoNums = new int[6];
	for(int i =0 ; i <lottoNums.length ; ) {
		lottoNums[i] = r.nextInt(45) + 1 ;
		boolean bool = true ;
		for(int j = 0 ; j < i ; j ++) {
			if(lottoNums[i] == lottoNums[j]) {
				System.out.print('!'); // 중복체크를 하고 있다는 의미로 표시
				bool = false ;
				break;
			}
		}
		if(bool) {
			i++ ;
		}
	} */
	 
	 
	//return lottoNums;
	
 