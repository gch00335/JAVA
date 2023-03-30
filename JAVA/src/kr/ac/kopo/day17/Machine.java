package kr.ac.kopo.day17;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Machine {

	private List<Ball> balls; // 이렇게 멤버변수가 들어올 수도 있다.
	
	public Machine() {
		balls = new ArrayList<>();
		for(int i = 1; i <= 45; i++) {
			Ball ball = new Ball(i);
			balls.add(ball);
		}
	}
	
	public void start() {
		Collections.shuffle(balls);
	}
	
	public Ball getBall() {
		return balls.remove(0);
	}
}








