package decorator;

public class DecoratorTest {
    public static void main(String[] args) {
        Component component = new ConcreteComponent();
        component.operation();
        System.out.println("-----------------------");
        Component component1 = new ConcreteDecorator(component);
        component1.operation();
    }
}

interface Component {
    void operation();
}
class ConcreteComponent implements Component {
    public ConcreteComponent() {
        System.out.println("创建具体构件角色");
    }

    @Override
    public void operation() {
        System.out.println("调用具体构件的方法 operation()");
    }
}

class Decorator implements Component {
    private Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void operation() {
        component.operation();
    }
}

class ConcreteDecorator extends Decorator {

    public ConcreteDecorator(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        super.operation();
        addedFunction();
    }

    public void addedFunction() {
        System.out.println("为具体构件角色添加额外的功能 addedFunction()");
    }
}


