package command;

public class CommandPattern {
    public static void main(String[] args) {
        Command command = new ConcreteCommand();
        Invoke invoke = new Invoke(command);
        invoke.call();
    }
}

class Invoke {
    private Command command;

    public Invoke(Command command) {
        this.command = command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public void call() {
        System.out.println("调用者执行命令command...");
        command.execute();
    }
}

interface Command {
    void execute();
}

class ConcreteCommand implements Command {
    private Receiver receiver;

    public ConcreteCommand() {
        receiver = new Receiver();
    }

    @Override
    public void execute() {
        receiver.action();
    }
}

class Receiver {
    public void action() {
        System.out.println("接收者的action()方法被调用");
    }
}




