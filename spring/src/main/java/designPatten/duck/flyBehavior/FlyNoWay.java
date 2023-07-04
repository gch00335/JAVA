package designPatten.duck.flyBehavior;

public class FlyNoWay implements FlyBehavior {
    public void fly() {
        System.out.println("Cannot fly");
    }
}
