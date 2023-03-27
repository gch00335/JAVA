package kr.ac.kopo.day15.inter;

public  class LGTV implements TV{
//오버라이드를 해줌! 
// : 인터페이스를 상속받는 하위클래스 추상메소드를 반드시 오버라이딩(재정의) 해야한다.
	

	private boolean power;
	private int channelNo;
	private int volumeSize;
	private int tempVolumeSize; // 본래의 소리로 돌아올 수 있게 하는 기능의 변수 만들기
	private boolean muteFlag = false ; // 음소거의 해제기능이 담긴 변수 만들기
	
	public LGTV(){
		power = false ;
		channelNo = 10;
		volumeSize = 7 ;
		 System.out.println("LGTV를 구매했습니다.");
	}
	
	@Override
	public void powerOn() {
		//그렇기 때문에 여기에도 [public]을 꼭 써줘야 한다! 
		power = true ;
		System.out.println("TV전원을 켭니다.");
		info();
		
	}
	

	@Override
	public void powerOff() {
		power = false ;
		System.out.println("TV전원을 끕니다.");
		info();
	}

	@Override
	public void channelUp() {
		channelNo++;
		System.out.println("채널 Up을 선택했습니다");
		info();
	}

	@Override
	public void chaanelDown() {
		channelNo--;
		System.out.println("채널 Down을 선택했습니다");
		info();
		
	}

	@Override
	public void volumeUp() {
		if(TV.MAX_VOLUME_SIZE > volumeSize) {
		volumeSize++;
		System.out.println("볼륨Up을 선택했습니다.");
		info();
	}
	}
	
	@Override
	public void volumeDown() {
		if(TV.MIN_VOLUME_SIZE != volumeSize) {
			volumeSize--;
			System.out.println("볼륨Down을 선택했습니다.");
			info();
		}
		
	}

	@Override
	public void mute() {
		
		if(!muteFlag) {                    // 음소거 해제버튼을 안눌렀으면 음소거기능이 실행
		tempVolumeSize = volumeSize ; 
		  volumeSize = TV.MIN_VOLUME_SIZE ; // 하지만 이렇게 하면 0이었다가 다시 눌렀을때 본래의 음량으로 돌아가게 해야하는 기능이 없음
		  System.out.println("음소거중입니다.");
			info();
		} else {                           // 음소거 해제버튼을 눌렀을 경우 음소거기능히 해제 되게 하는 것 
			volumeSize = tempVolumeSize ; 
			muteFlag = false ;

			System.out.println("음소거가 해제됩니다.");
		}
		
	} 
	public void info() {
		System.out.println("채널번호 :" + channelNo+ ",음량크기 : "+ volumeSize );
	}

}
