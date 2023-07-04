package designPattern.duck.client;

import designPattern.duck.flyBehavior.FlyBehavior;
import designPattern.duck.flyBehavior.FlyNoWay;
import designPattern.duck.quackBehavior.QuackBehavior;
import designPattern.duck.quackBehavior.Squeak;

public class RubberDuck extends Duck {
    public RubberDuck() {
    	 flyBehavior = new FlyNoWay();
         quackBehavior = new Squeak();
     }
     
     public void display() {
         System.out.println("Looks like a rubber duck");
     }
 }
