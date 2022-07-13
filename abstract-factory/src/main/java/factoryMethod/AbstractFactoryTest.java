package factoryMethod;

public class AbstractFactoryTest {
    public static void main(String[] args) {
        try {
            AbstractFactory abstractFactory = (AbstractFactory) ReadXML1.getObject();
            assert abstractFactory != null;
            Product product = abstractFactory.createProduct();
            product.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

interface Product {
    void show();
}

class ConcreteProduct1 implements Product {
    @Override
    public void show() {
        System.out.println("产品1号展示");
    }
}

class ConcreteProduct2 implements Product {
    @Override
    public void show() {
        System.out.println("产品2号展示");
    }
}

interface AbstractFactory {
    Product createProduct();
}

class ConcreteFactory1 implements AbstractFactory {
    @Override
    public Product createProduct() {
        System.out.println("工厂1号生产1号产品...");
        return new ConcreteProduct1();
    }
}

class ConcreteFactory2 implements AbstractFactory {
    @Override
    public Product createProduct() {
        System.out.println("工厂2生产2号产品");
        return new ConcreteProduct2();
    }
}
