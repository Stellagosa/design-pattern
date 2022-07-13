package bridge;

public class BridgeTest {
    public static void main(String[] args) {
        Implementor implementor = new ConcreteImplementorA();
        Abstraction abstraction = new RefinedAbstraction(implementor);
        abstraction.Operation();
    }
}

//实现化角色
interface Implementor {
    void OperationImpl();
}

//具体实现化角色
class ConcreteImplementorA implements Implementor {
    @Override
    public void OperationImpl() {
        System.out.println("具体实现化角色被访问");
    }
}

abstract class Abstraction {
    protected Implementor implementor;
    protected Abstraction(Implementor implementor) {
        this.implementor = implementor;
    }
    public abstract void Operation();
}

class RefinedAbstraction extends Abstraction {
    protected RefinedAbstraction(Implementor implementor) {
        super(implementor);
    }
    @Override
    public void Operation() {
        System.out.println("扩展抽象化角色被访问");
        implementor.OperationImpl();
    }

}




