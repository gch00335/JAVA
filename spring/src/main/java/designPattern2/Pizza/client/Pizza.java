package designPattern2.Pizza.client;

public abstract class Pizza {
    private String type;

    public Pizza(String type) {
        this.type = type;
        System.out.println("Creating a " + type); 
    }

    // ���ڿ� ���� ���� ���� ����
    public void prepare() {
        System.out.println("Preparing the " + type);
    }

    public void bake() {
        System.out.println("Baking the " + type);
    }

    public void cut() {
        System.out.println("Cutting the " + type);
    }

    public void box() {
        System.out.println("Boxing the " + type);
    }
}

