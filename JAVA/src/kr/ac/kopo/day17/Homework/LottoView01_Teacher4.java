package kr.ac.kopo.day17.Homework;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;


public class LottoView01_Teacher4 {

	
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
	
	 Set <Integer>lottos = new HashSet<>();
	 while (lottos.size()<6) {
			lottos.add(r.nextInt(45)+1);
		//	System.out.print('!'); // 겹치는게 있는지 확인
	 }
	 int i = 0;
	 for(int num : lottos) {
			lottoNums[i++] = num;
	 }
		return lottoNums;
	}
}

