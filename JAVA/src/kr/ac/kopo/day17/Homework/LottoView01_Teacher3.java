package kr.ac.kopo.day17.Homework;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class LottoView01_Teacher3 {

	
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
	 int []nums = new int[45];
	 for(int i = 0 ; i < nums.length ; i ++) {
		 nums[i] = i +1 ;
	 }
//		System.out.println(Arrays.toString(nums));
	 for(int i=0 ; i<6 ; i ++) {
		 int randIdx = r.nextInt(45-i);
		 
		 int temp = nums[randIdx];
		 nums[randIdx] = nums[45-1-i];
		 nums[45-1-i] = temp ;
	 }
	//ystem.out.println(Arrays.toString(nums)); 맞게 되었는지 확인용
	 System.arraycopy(nums, nums.length-lottoNums.length , lottoNums, 0, lottoNums.length);
	 //우리가...arraycopy를 배웠어..?
	return lottoNums;
 }
}
	 