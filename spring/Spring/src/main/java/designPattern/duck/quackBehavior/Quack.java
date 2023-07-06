package designPattern.duck.quackBehavior;

public class Quack implements QuackBehavior {

	@Override
	public void quack() {
		System.out.println(" Ва!!");
	}

}