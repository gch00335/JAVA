package designPattern2.Pizza.client;

import designPattern2.ChicagoPizza.ChicagoStyleCheesePizza;
import designPattern2.ChicagoPizza.ChicagoStylePepperoniPizza;

public class ChicagoPizzaStore extends PizzaStore {
    // createPizza() 메서드 구현
    protected Pizza createPizza(String type) throws IllegalArgumentException {
        Pizza pizza = null;

        if (type.equals("cheese")) {
            pizza = new ChicagoStyleCheesePizza();
        } else if (type.equals("pepperoni")) {
            pizza = new ChicagoStylePepperoniPizza();
        } else {
            throw new IllegalArgumentException("Unsupported pizza type: " + type);
        }

        return pizza;
    }
}
