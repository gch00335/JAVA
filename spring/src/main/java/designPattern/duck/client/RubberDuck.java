package designPattern.duck.client;

import designPatten.duck.flyBehavior.FlyBehavior;
import designPatten.duck.flyBehavior.FlyNoWay;
import dexignPAttern.duck.quackBehavior.QuackBehavior;
import dexignPAttern.duck.quackBehavior.Squeak;

public class RubberDuck extends Duck {
    public RubberDuck() {
    	 flyBehavior = new FlyNoWay();
         quackBehavior = new Squeak();
     }
     
     public void display() {
         System.out.println("Looks like a rubber duck");
     }
 }
