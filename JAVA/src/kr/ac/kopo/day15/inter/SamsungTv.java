package kr.ac.kopo.day15.inter;

public class SamsungTv implements TV {

	
	public SamsungTv() {
		System.out.println("삼성TV구매완료..");
		
	}
	
	@Override
	public void powerOn() {
		System.out.println(" TV 전원 ON ");

	}

	@Override
	public void powerOff() {
		System.out.println(" TV 전원 Off ");

	}

	@Override
	public void channelUp() {
		System.out.println(" TV 채널 UP ");


	}

	@Override
	public void chaanelDown() {
		System.out.println(" TV 채널 Down ");

	}

	@Override
	public void volumeUp() {
		System.out.println(" TV 볼륨 UP ");

	}

	@Override
	public void volumeDown() {
		System.out.println(" TV 볼륨 Down ");

	}

	@Override
	public void mute() {
		System.out.println(" TV  mute... ");

	}

}
