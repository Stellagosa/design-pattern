public class TheadStateTest {
    public static void main(String[] args) {
        TheadContext context = new TheadContext();
        context.start();
        context.getCPU();
        context.suspend();
        context.resume();
        context.getCPU();
        context.stop();
    }
}

class TheadContext {
    private TheadState theadState;

    public TheadContext() {
        this.theadState = new New();
    }

    public TheadState getTheadState() {
        return theadState;
    }

    public void setTheadState(TheadState theadState) {
        this.theadState = theadState;
    }

    void start() {
        ((New) theadState).start(this);
    }
    void getCPU() {
        ((Runnable) theadState).getCPU(this);
    }
    void stop() {
        ((Running) theadState).stop(this);
    }
    void suspend() {
        ((Running) theadState).suspend(this);
    }
    void resume() {
        ((Blocked) theadState).resume(this);
    }
}

abstract class TheadState {
    protected String name;
}

class New extends TheadState {
    public New() {
        name = "新建";
        System.out.println("当前线程处于新建状态");
    }
    void start(TheadContext theadContext) {
        System.out.println("调用了start()方法");
        if (name.equals("新建")) {
            theadContext.setTheadState(new Runnable());
        } else {
            System.out.println("当前线程不是处于新建状态，不能调用start()方法");
        }
    }
}
class Runnable extends TheadState {
    public Runnable() {
        name = "就绪";
        System.out.println("当前线程处于就绪状态");
    }
    void getCPU(TheadContext theadContext) {
        System.out.println("调用了getCPU()方法");
        if (name.equals("就绪")) {
            theadContext.setTheadState(new Running());
        } else {
            System.out.println("当前线程不是处于就绪状态，不能调用getCPU()方法");
        }
    }
}
class Running extends TheadState {
    public Running() {
        name = "运行";
        System.out.println("当前线程处于运行状态");
    }
    void stop(TheadContext theadContext) {
        System.out.println("调用了stop()方法");
        if (name.equals("运行")) {
            theadContext.setTheadState(new Dead());
        } else {
            System.out.println("当前线程不是处于运行状态，不能调用stop()方法");
        }
    }
    void suspend(TheadContext theadContext) {
        System.out.println("调用了suspend()方法");
        if (name.equals("运行")) {
            theadContext.setTheadState(new Blocked());
        } else {
            System.out.println("当前线程不是处于运行状态，不能调用suspend()方法");
        }
    }
}
class Blocked extends TheadState {
    public Blocked() {
        name = "阻塞";
        System.out.println("当前线程处于阻塞状态");
    }
    void resume(TheadContext theadContext) {
        System.out.println("调用了resume()方法");
        if (name.equals("阻塞")) {
            theadContext.setTheadState(new Runnable());
        } else {
            System.out.println("当前线程不是处于阻塞状态，不能调用resume()方法");
        }
    }
}
class Dead extends TheadState {
    public Dead() {
        name = "死亡";
        System.out.println("当前线程处于死亡状态");
    }
}











