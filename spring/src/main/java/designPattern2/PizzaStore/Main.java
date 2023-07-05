package designPattern2.PizzaStore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import designPattern.duck.client.Duck;
import designPattern2.Pizza.client.ChicagoPizzaStore;
import designPattern2.Pizza.client.NYPizzaStore;
import designPattern2.Pizza.client.Pizza;
import designPattern2.Pizza.client.PizzaStore;

public class Main {
	public static void main(String[] args) {

		 ApplicationContext context = new ClassPathXmlApplicationContext("designPattern2/PizzaStore/setting.xml");
	        PizzaStore pizzaStore = context.getBean("pizzaStore", PizzaStore.class); 

	        Pizza cheesePizza = pizzaStore.orderPizza("cheese");
	        System.out.println();

	        Pizza pepperoniPizza = pizzaStore.orderPizza("pepperoni");

		
		/*
		 * // ���� ���� ���Կ��� ġ�� ���� �ֹ� PizzaStore nyPizzaStore = new NYPizzaStore(); Pizza
		 * nyCheesePizza = nyPizzaStore.orderPizza("cheese"); System.out.println();
		 * 
		 * // ��ī�� ���� ���Կ��� ���۷δ� ���� �ֹ� PizzaStore chicagoPizzaStore = new
		 * ChicagoPizzaStore(); Pizza chicagoPepperoniPizza =
		 * chicagoPizzaStore.orderPizza("pepperoni");
		 */
		
	}
}