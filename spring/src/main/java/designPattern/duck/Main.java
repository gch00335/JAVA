package designPattern.duck;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import designPattern.duck.client.DecoyDuck;
import designPattern.duck.client.Duck;
import designPattern.duck.client.MallardDuck;
import designPattern.duck.client.RubberDuck;
import dexignPAttern.duck.quackBehavior.MuteQuack;
import spring.di.ui.DisplayExam;

public class Main {
	  public static void main(String[] args) {
	        // spring container ¸¸µé±â
		      ApplicationContext context = new ClassPathXmlApplicationContext("designPattern/duck/setting.xml");
		      MuteQuack mutequack = context.getBean(MuteQuack.class);
	        
	        
		      /*
		       * Duck mallardDuck = new MallardDuck(); mallardDuck.display();
		       * mallardDuck.performFly(); mallardDuck.performQuack();
		       */
	        
//	        Duck rubberDuck = new RubberDuck();
//	        rubberDuck.display();
//	        rubberDuck.performFly();
//	        rubberDuck.performQuack();
//	        
//	        Duck decoyDuck = new DecoyDuck();
//	        decoyDuck.display();
//	        decoyDuck.performFly();
//	        decoyDuck.performQuack();
	        
	        
	    }

	
}
