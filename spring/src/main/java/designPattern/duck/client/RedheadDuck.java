package designPattern.duck.client;

import designPattern.duck.flyBehavior.FlyWithWings;
import designPattern.duck.quackBehavior.Quack;

public class RedheadDuck extends Duck {
	
	public RedheadDuck() {
		flyBehavior = new FlyWithWings();
		quackBehavior = new Quack();
	}
	
	public void display() {
		System.out.print("looks like a redhead : ");
	}
}