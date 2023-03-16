package kr.ac.kopo.day07;

public class ArrayMain02 {

	public static void main(String[] args) {

		//int[] arr= {10,20,30,40,50};
		// 이렇게도 표현할 수 있다 ! 이것을 배열의 초기화라고 함!
		// 첫번째는 arr를 새롭게 중복으로 다시 쓸 수가 없음 -> 오류가 뜸!
		// 이미 arr 이 만들어져있기에 블록만으로는 초기화를 할 수가 없다! // 새로운 참조변수를 사용해야만 가능
		
		
		int[]arr =new int[] {10,20,30,40,50}; // 10~50의 의미를 가진 정수를 만들라는 것
		//이것또 또다른 배열의 초기화 모습! 총 두가지 모습이 있다는 것을 알면 됨
		//하지만 둘의 의미는 같으면서도 조금의 차이가 있음.
		// 두번째 new int는 사용하면 새롭게 다시 heap 영역에 새로운 배열이 만들어 위치를 가리킴
		// 전에 있던 위치는 잊혀짐! (전에 있던 것을 유령의 공간이라고 함) - > 이것을 가비지컬렉터(쓰레기모집)가 처리함!
		
		/*
		for(int i =0 ; i<arr.length; i++) {
			arr[i] = (i+1) * 10;
		}
		//반복문을 정확히 이해해야 이렇게
		//규칙을 이용해 코드를 짤 수 있음
		/*
		arr[0] = 10;
		arr[1] = 20;
		arr[2] = 30;
		arr[3] = 40;
		arr[4] = 50;
		// [i] = (i+1) *1 라는 규칙을 알 수 있음*/
		
		System.out.println("<PRINt>");
		for(int i=0 ; i< arr.length ; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

}
