package designPattern.duck.client;

import designPattern.duck.flyBehavior.FlyWithWings;
import designPattern.duck.quackBehavior.MuteQuack;

public class  DecoyDuck extends Duck {
    public DecoyDuck() {
        flyBehavior = new FlyWithWings();
        quackBehavior = new MuteQuack();
  }
    
    public void display() {
        System.out.println("Looks like a decoy duck");
    }
}
