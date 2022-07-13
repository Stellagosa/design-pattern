import java.util.ArrayList;
import java.util.List;

public class ObserverPatternTest {
    public static void main(String[] args) {
        Subject subject = new ConcreteSubject();
        Observer observer = new ConcreteObserver1();
        subject.add(observer);
        observer = new ConcreteObserver2();
        subject.add(observer);
        subject.notifyObserver();
    }
}

abstract class Subject {
    protected List<Observer> observers = new ArrayList<>();
    void add(Observer observer) {
        observers.add(observer);
    }
    void remove(Observer observer) {
        observers.remove(observer);
    }
    abstract void notifyObserver();
}

interface Observer {
    void response();
}

class ConcreteSubject extends Subject {
    @Override
    void notifyObserver() {
        for (Observer observer : observers) {
            observer.response();
        }
    }
}

class ConcreteObserver1 implements Observer {
    @Override
    public void response() {
        System.out.println("观察者1");
    }
}
class ConcreteObserver2 implements Observer {
    @Override
    public void response() {
        System.out.println("观察者2");
    }
}




















