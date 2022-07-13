package facade;

public class FacadePattern {
    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.method();
    }
}

class Facade {

    private SubSystem1 subSystem1 = new SubSystem1();
    private SubSystem2 subSystem2 = new SubSystem2();
    private SubSystem3 subSystem3 = new SubSystem3();

    public void method() {
        subSystem1.method1();
        subSystem2.method2();
        subSystem3.method3();
    }
}

class SubSystem1 {
    public void method1() {
        System.out.println("系统1中的方法1被调用");
    }
}
class SubSystem2 {
    public void method2() {
        System.out.println("系统2中的方法2被调用");
    }
}
class SubSystem3 {
    public void method3() {
        System.out.println("系统3中的方法3被调用");
    }
}


