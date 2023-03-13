package kr.ac.kopo.day05.Homework;

import java. util.Scanner;
public class HomeworkMain01 {
// 숙제 중 3번째 
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 3개 입력 : ");
		int num = sc.nextInt();
		int num2 = sc.nextInt();
		int num3 = sc.nextInt();
		
		int min = num , max = num2 ;
		if (num > num2) {
			min = num2 ;
			max = num;
			
		}
		
		if (num3 < min) {
			 System.out.println(num3 + " < " + min + " < " + max);
		} else if(num3 < max ) {
			 System.out.println(min + " < " + num3 + "<" + max);
		} else {
			System.out.println(min + " < " + max + " < " + num3);
		}
		
		
		
		/*
		System.out.println(num + " : " + num2 + ":" + num3);
		
		if ( num < num2 && num2 < num3) {
		} else if (num < num3 && num3 < num2) {
		} else if (num2 < num && num < num3) {
		} else if (num2 < num3 && num3 < num ) {
		} else if (num3 < num && num < num2 ) {
		} else if ( num3< num2 && num2< num) {
		} */
		

	}

}
