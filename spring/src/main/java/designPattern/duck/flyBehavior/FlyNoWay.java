package designPattern.duck.flyBehavior;

public class FlyNoWay implements FlyBehavior {

	@Override
	public void fly() {

		System.out.print("나는 못 날아요..");
	
	}

}