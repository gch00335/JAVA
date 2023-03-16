package kr.ac.kopo.day05;

public class LoopMain02 {

	public static void main(String[] args) {
	
		for(int cnt =1 ; cnt <= 5 ; ++cnt ) {
			System.out.println("Hello");
		}

	} 
	//System.out.println("cnt : " +cnt);
	// 에러가 나는 이유는 cnt 변수는 for 안에만 있기에 밖에서는 인식을 못함! 
	// 변수가 for 안에서만 사용되기에 같은 변수를 또 사용할 수 있
}
