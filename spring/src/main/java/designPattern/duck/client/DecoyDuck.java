package designPattern.duck.client;

import designPatten.duck.flyBehavior.FlyNoWay;
import dexignPAttern.duck.quackBehavior.MuteQuack;

public class  DecoyDuck extends Duck {
    public DecoyDuck() {
        flyBehavior = new FlyNoWay();
        quackBehavior = new MuteQuack();
  }
    
    public void display() {
        System.out.println("Looks like a rubber duck");
    }
}
