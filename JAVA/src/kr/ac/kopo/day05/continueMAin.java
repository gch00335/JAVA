package kr.ac.kopo.day05;

public class continueMAin {

	public static void main(String[] args) {
		int cnt =1;
		 for(cnt =1; cnt<=10; cnt++) {
			 if(cnt >=3) {
				continue; 		
			} 
			 
			System.out.println("HI");
		 }
		System.out.println("cnt :" +cnt );
	}

}

/*
 * if(cnt ==3) { //continue; * 거의 안씀..!
 * 
 * // [continu]는 else로도 바꿀 수 있음. // 반복문의 특정지점에서 제어를 반복문 처음으로 보낸다. } else
 * System.out.println("HI"); }
 */

