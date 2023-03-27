package kr.ac.kopo.day15;

import java.util.Random;

public class ExceptionMain03 {

	public static void main(String[] args) {
		System.out.println("===start===");
		
		Random r = new Random();
		int random = r.nextInt(3);
		
		try {
		System.out.println("random : " + random);
		System.out.println(10/random);
		
		String str = "hello";
		System.out.println(str.charAt(5)); 
		
	//방법3
		} catch(Exception e) { // 묵시적형변환..!
			e.printStackTrace();
		}
		
		
		
		System.out.println("===end==="); //에러가 발생되도 끝까지 실행이 됨! 
		                                 //이러한 것이 바로 에러의 안전장치!
		                                
	}

}
