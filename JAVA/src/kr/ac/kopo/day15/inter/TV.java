package kr.ac.kopo.day15.inter;

public interface TV {
	
	/*public static final */ int MAX_VOLUME_SIZE = 50 ; // 최대볼륨
	int MIN_VOLUME_SIZE = 0; // 최소 볼륨
	
	/*public abstract 가 생략되어있음 */void powerOn();
	void powerOff();
	void channelUp();
	void chaanelDown();
	void volumeUp();
	void volumeDown();
	void mute();
	

}
