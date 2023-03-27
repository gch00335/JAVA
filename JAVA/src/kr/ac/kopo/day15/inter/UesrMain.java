package kr.ac.kopo.day15.inter;

public class UesrMain {

	public static void main(String[] args) {
		
	//TV tv =	new LGTV(); // 객체형변환이 가능 // 인스턴스 오브 [ instanceof ]
	TV tv = new SamsungTv();
	tv.powerOn();
	tv.volumeDown();
	tv.mute();
	tv.channelUp();
	tv.mute();
	tv.powerOff();
	SamsungTv sam = (SamsungTv)tv;
	
	System.out.println(tv); // 이렇게 tv를 호출하면 삼성tv의 위치 주소값이 나온다.
	                        //여기서 중요한 것은 tv로는 toString이 안된다.
	                        // 인터페이스때문인데.. 
	
	System.out.println(tv.toString()); // 엥 안된다는게 무슨뜻일까..? 위치주소값나오는데..?
	
	
	System.out.println(sam);
	System.out.println(sam.toString()); // 위랑 아래 같은 값이 추력이 나오는 것을 볼 수 있다. 
	                                    // 즉 toString메소드로 출력이 되고 있다는 것.
	                                    // 모든 클래스는 무조건 object 클래스를 상속받기 때문에
	                                    // 오류가 나지 않고 설정되지 않았던 toString 메소드가 사용되는 것.
}

}
