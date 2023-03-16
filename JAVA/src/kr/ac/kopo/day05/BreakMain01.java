package kr.ac.kopo.day05;

public class BreakMain01 {

	public static void main(String[] args) {
		int cnt =1;
		 for(cnt =1; cnt<=10; cnt++) {
			 if(cnt ==3) {
				continue; // 참일지라도 if 조건에 해당되면 브레이크되어서 빠져나옴!
			 }
			 System.out.println("HI");
		 }
		System.out.println("cnt :" +cnt );
	}

}

