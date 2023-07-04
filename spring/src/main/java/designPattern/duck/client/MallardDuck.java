package designPattern.duck.client;

import designPattern.duck.flyBehavior.FlyWithWings;
import designPattern.duck.quackBehavior.Quack;

public class  MallardDuck extends Duck {
    public MallardDuck() {
        flyBehavior = new FlyWithWings();
        quackBehavior = new Quack();
    }
    
    public void display() {
        System.out.println("Looks like a mallard");
    }
}
