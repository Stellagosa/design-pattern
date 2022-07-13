package flyweight;

import java.util.HashMap;
import java.util.Map;

public class FlyweightPattern {
    public static void main(String[] args) {
        FlyweightFactory flyweightFactory = new FlyweightFactory();
        Flyweight flyweight01 = flyweightFactory.getFlyweight("a");
        Flyweight flyweight02 = flyweightFactory.getFlyweight("a");
        Flyweight flyweight03 = flyweightFactory.getFlyweight("a");
        Flyweight flyweight11 = flyweightFactory.getFlyweight("b");
        Flyweight flyweight12 = flyweightFactory.getFlyweight("b");

        flyweight01.operation(new UnsharedConcreteFlyweight("第一次调用a"));
        flyweight02.operation(new UnsharedConcreteFlyweight("第二次调用a"));
        flyweight03.operation(new UnsharedConcreteFlyweight("第三次调用a"));
        flyweight11.operation(new UnsharedConcreteFlyweight("第一次调用b"));
        flyweight12.operation(new UnsharedConcreteFlyweight("第二次调用b"));

    }
}

class UnsharedConcreteFlyweight {
    private String info;

    public UnsharedConcreteFlyweight(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}

interface Flyweight {
    void operation(UnsharedConcreteFlyweight state);
}

class ConcreteFlyweight implements Flyweight {

    private String key;

    public ConcreteFlyweight(String key) {
        this.key = key;
        System.out.println("具体享元" + key + "被创建");
    }

    @Override
    public void operation(UnsharedConcreteFlyweight state) {
        System.out.println("具体享元" + key + "被调用");
        System.out.println("非享元信息是：" + state.getInfo());
    }
}

class FlyweightFactory {

    private Map<String, Flyweight> map = new HashMap<>();

    public Flyweight getFlyweight(String key) {
        Flyweight flyweight = map.get(key);
        if (flyweight == null) {
            flyweight = new ConcreteFlyweight(key);
            map.put(key, flyweight);
        } else {
            System.out.println("具体享元" + key + "已存在");
        }
        return flyweight;
    }
}
