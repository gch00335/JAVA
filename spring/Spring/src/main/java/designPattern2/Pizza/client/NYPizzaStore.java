package designPattern2.Pizza.client;

import designPattern2.NYPizza.NYStyleCheesePizza;
import designPattern2.NYPizza.NYStylePepperoniPizza;

public  class NYPizzaStore extends PizzaStore {
    // createPizza() 메서드 구현
    protected Pizza createPizza(String type) throws IllegalArgumentException {
        Pizza pizza = null;

        if (type.equals("cheese")) {
            pizza = new NYStyleCheesePizza();
        } else if (type.equals("pepperoni")) {
            pizza = new NYStylePepperoniPizza();
        } else {
            throw new IllegalArgumentException("Unsupported pizza type: " + type);
        }

        return pizza;
    }
}
