package designPattern.duck.client;

import designPatten.duck.flyBehavior.FlyWithWings;
import dexignPAttern.duck.quackBehavior.Quack;

public class  MallardDuck extends Duck {
    public MallardDuck() {
        flyBehavior = new FlyWithWings();
        quackBehavior = new Quack();
    }
    
    public void display() {
        System.out.println("Looks like a mallard");
    }
}
