package designPattern.duck.quackBehavior;

public class MuteQuack implements QuackBehavior {

	@Override
	public void quack() {
		System.out.println(" X");
	}

}