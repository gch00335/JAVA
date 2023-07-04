package designPattern.duck;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import designPattern.duck.client.Duck;
public class Main {
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("designPattern/duck/setting.xml");
		Duck duck = context.getBean("duck", Duck.class);
		
		duck.display();
        duck.performFly();
        duck.performQuack();

		/* 자바코드
		Duck mallardDuck = new MallardDuck();
		mallardDuck.display();
		
		mallardDuck.performFly();
		mallardDuck.performQuack();
		
		Duck redheadDuck = new RedheadDuck();
		redheadDuck.display();
		
		redheadDuck.performFly();
		redheadDuck.performQuack();
		
		Duck rubberDuck = new RubberDuck();
		rubberDuck.display();
		rubberDuck.performFly();
		rubberDuck.performQuack();
		
		Duck decoyDuck = new DecoyDuck();
		decoyDuck.display();
		decoyDuck.performFly();
		
		decoyDuck.performQuack();
		*/
	}
}
