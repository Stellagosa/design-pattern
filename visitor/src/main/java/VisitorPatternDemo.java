import java.util.ArrayList;
import java.util.List;

public class VisitorPatternDemo {
    public static void main(String[] args) {
        ObjectStructure object = new ObjectStructure();
        object.add(new ConcreteElementA());
        object.add(new ConcreteElementB());
        Visitor visitorA = new ConcreteVisitorA();
        Visitor visitorB = new ConcreteVisitorB();

        object.accept(visitorA);
        object.accept(visitorB);

    }
}

class ObjectStructure {
    private List<Element> elements = new ArrayList<>();
    public void add(Element element) {
        elements.add(element);
    }
    public void remove(Element element) {
        elements.remove(element);
    }

    public void accept(Visitor visitor) {
        for (Element element : elements) {
            element.accept(visitor);
        }
    }
}

// 抽象访问者
interface Visitor {
    void visit(ConcreteElementA elementA);
    void visit(ConcreteElementB elementA);
}

class ConcreteVisitorA implements Visitor {
    @Override
    public void visit(ConcreteElementA elementA) {
        System.out.print("访问者A访问--->");
        elementA.operation();
    }

    @Override
    public void visit(ConcreteElementB elementA) {
        System.out.print("访问者A访问--->");
        elementA.operation();
    }
}
class ConcreteVisitorB implements Visitor {
    @Override
    public void visit(ConcreteElementA elementA) {
        System.out.print("访问者B访问--->");
        elementA.operation();
    }

    @Override
    public void visit(ConcreteElementB elementA) {
        System.out.print("访问者B访问--->");
        elementA.operation();
    }
}

// 抽象元素类
interface Element {
    void accept(Visitor visitor);
}

class ConcreteElementA implements Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void operation() {
        System.out.println("具体A元素操作");
    }
}
class ConcreteElementB implements Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
    public void operation() {
        System.out.println("具体B元素操作");
    }
}












