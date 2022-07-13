package proxy;

public class ProxyTest {
    public static void main(String[] args) {
        ProxySubject proxy = new ProxySubject();
        proxy.request();
    }
}

interface Subject {
    void request();
}

class RealSubject implements Subject {

    @Override
    public void request() {
        System.out.println("访问真实主题...");
    }
}

class ProxySubject implements Subject {

    private RealSubject realSubject;

    @Override
    public void request() {
        if (realSubject == null) {
            realSubject = new RealSubject();
        }
        preRequest();
        realSubject.request();
        postRequest();
    }

    private void postRequest() {
        System.out.println("访问真实主题的后续处理");
    }

    private void preRequest() {
        System.out.println("访问真实主题前的预处理");
    }
}

