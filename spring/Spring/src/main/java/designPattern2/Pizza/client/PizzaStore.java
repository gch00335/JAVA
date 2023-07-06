package designPattern2.Pizza.client;

public class PizzaStore {
    private NYPizzaStore nyPizzaStore;
    private ChicagoPizzaStore chicagoPizzaStore;

    public void setNyPizzaStore(NYPizzaStore nyPizzaStore) {
        this.nyPizzaStore = nyPizzaStore;
    }

    public void setChicagoPizzaStore(ChicagoPizzaStore chicagoPizzaStore) {
        this.chicagoPizzaStore = chicagoPizzaStore;
    }

    public Pizza orderPizza(String type) {
        Pizza pizza = null;
     
        try {
            if (type.equals("cheese")) {
                if (nyPizzaStore != null) {
                    pizza = nyPizzaStore.createPizza("cheese");
                } else {
                    throw new IllegalStateException("NYPizzaStore is not set.");
                }
            } else if (type.equals("pepperoni")) {
                if (chicagoPizzaStore != null) {
                    pizza = chicagoPizzaStore.createPizza("pepperoni");
                } else {
                    throw new IllegalStateException("ChicagoPizzaStore is not set.");
                }
            } else {
                throw new IllegalArgumentException("Unsupported pizza type: " + type);
            }

            if (pizza != null) {
                pizza.prepare();
                pizza.bake();
                pizza.cut();
                pizza.box();
            } else {
                System.out.println("Invalid pizza type.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid pizza type: " + e.getMessage());
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }

        return pizza;
    }
}