package kr.ac.kopo.day08.Homework;

import java.util.Scanner;

public class Homework01_teacher {

public static void main(String[] args) {
// i가 행 20개를 나타난게 j ...
	Scanner sc = new Scanner(System.in);
	
	int[][] numArr = new int[10][20];
	
	int loc = 0;

	System.out.println("정수를 입력하세요. 최대10개입력, 0 입력시 종료됩니다.");
	
	
	/* while(true){
	   numArr[loc++][0] = sc.nextInt();
    	if(numArr[loc][0]==0) {
		break;
  	}
	if(++loc ==numArr.length) {
		break;
	} */
	
	do{
	numArr[loc][0] = sc.nextInt();
	
	int j =1;
	for(int i = 1 ; i <= numArr[loc][0]; i ++) {
		if(numArr[loc][0] % i == 0) {
			numArr[loc][j++] = i ;
		}
	}
	 numArr[loc][0] = j - 1 ; //
	 
	} while(numArr[loc][0] != 0 && ++loc <10); 
	
	for(int i = 0 ; i< loc; i++) {
		int idx = numArr[i][0] ;
		System.out.print(numArr[i][idx] + "의 약수 :");
			for(int j= 1 ; j <=idx ; j++)
				System.out.print(numArr[i][j] + " ");
			System.out.println();
	}
}
}
