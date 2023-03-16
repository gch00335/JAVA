package kr.ac.kopo.day06;

public class ArrayMain01 {

	public static void main(String[] args) {
		
		int[] ar;
		ar = new int[10];
		
		
		System.out.println("ar :" + ar);
		// 실행했을 때 @ 가 나오면 위치라고 생각하면 된다. 
		// 이 주소는 실제주소가 아닌 가상의 주소다.
		System.out.println("ar의 배열 :"+ ar.length);
		
		System.out.println("첫번째 정수 :"+ ar[0]);
		System.out.println("두번쨰 정수 :" + ar[1]);
		System.out.println("세번째 정수 :" + ar[2]);
		System.out.println("네번째 정수 :" + ar[3]);
		System.out.println("다섯번째 정수 :" + ar[4]);
	//	System.out.println("여섯번째 정수 :" + ar[5]); // 범위를 넘어섰기때문에 오류가 뜸!
		 // 디폴트로 정해져있기에 별다른 말이 없으면 실행 했을 때처럼 0이 나옴!
		
		for(int i =0; i< ar.length ; i++) {
			//  [i<= ar.length -1] 와 [i < ar.length] 은 같음!
			//배열의 초기는  '0' 부터! 
			
			 System.out.println("ar["+i+ "]:"+ ar[i]);
			 // System.out.println("첫번째 정수 :"+ ar[0]); 이렇게 따로 쓰지 않고
			 // length 를 쓰면 처음에 설정해둔 범위로 자동으로 설정실행됨!
		}
	}

}


