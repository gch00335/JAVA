package kr.ac.kopo.day15;

import java.util.Random;

public class ExceptionMain01 {

	public static void main(String[] args) {
		System.out.println("===start===");
		
		Random r = new Random();
		int random = r.nextInt(3);
		
		System.out.println("random : " + random);
		System.out.println(10/random);
		
		
		System.out.println("===end==="); //에러가 발생되면 이 밑에 있는 end까지 실행이 되지 않음.
		                                 // 이러한 상황을 없애기 위해 예외처리를 진행하려고 함.
	}

}
