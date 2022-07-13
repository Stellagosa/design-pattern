package adapter;

public class ClassAdapterTest {
    public static void main(String[] args) {
        Target target = new ClassAdapter();
        target.request();
    }
}

interface Target {
    void request();
}

class Adaptee {
    public void specificRequest() {
        System.out.println("适配者中的业务代码调用");
    }
}

class ClassAdapter extends Adaptee implements Target{

    @Override
    public void request() {
        specificRequest();
    }
}

