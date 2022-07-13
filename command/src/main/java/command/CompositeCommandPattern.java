package command;

import java.util.ArrayList;
import java.util.List;

public class CompositeCommandPattern {
    public static void main(String[] args) {
        CompositeInvoker invoker = new CompositeInvoker();
        AbstractCommand command = new ConcreteCommand1();
        invoker.add(command);
        command = new ConcreteCommand2();
        invoker.add(command);
        invoker.execute();
    }
}

interface AbstractCommand {
    void execute();
}

class CompositeReceiver {
    public void action1() {
        System.out.println("调用接收者的 action1()方法");
    }
    public void action2() {
        System.out.println("调用接收者的 action2()方法");
    }
}

class ConcreteCommand1 implements AbstractCommand {

    private CompositeReceiver receiver;

    public ConcreteCommand1() {
        receiver = new CompositeReceiver();
    }

    @Override
    public void execute() {
        receiver.action1();
    }
}

class ConcreteCommand2 implements AbstractCommand {

    private CompositeReceiver receiver;

    public ConcreteCommand2() {
        receiver = new CompositeReceiver();
    }

    @Override
    public void execute() {
        receiver.action2();
    }
}

class CompositeInvoker implements AbstractCommand {
    private List<AbstractCommand> commandList = new ArrayList<>();

    public void add(AbstractCommand command) {
        commandList.add(command);
    }
    public void remove(AbstractCommand command) {
        commandList.remove(command);
    }

    public AbstractCommand getChild(int i) {
        return commandList.get(i);
    }

    @Override
    public void execute() {
        for (AbstractCommand command : commandList) {
            command.execute();
        }
    }
}
