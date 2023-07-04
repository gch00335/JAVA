package dexignPAttern.duck.quackBehavior;

public class MuteQuack implements QuackBehavior {
    public void quack() {
        System.out.println("Cannot quack");
    }
}
