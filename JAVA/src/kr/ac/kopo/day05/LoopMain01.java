package kr.ac.kopo.day05;

public class LoopMain01 {

	public static void main(String[] args) {
		/*
		System.out.println("---start---");
		System.out.println("Hello");
		Systerm.out.println("---end---");
		*/
		
		int cnt =1;
		while(cnt <=5) {
			System.out.println("Hello");
			++cnt;

			
		}
		System.out.println("cnt : " +cnt);
		// [while]은 밖에서도 cnt 인식이 가능! 
		// 변수가 살아있기에 재사용을 할 수 없고, 다른 변수로 사용해야함
	}

}
