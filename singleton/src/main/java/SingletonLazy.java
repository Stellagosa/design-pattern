public class SingletonLazy {
    public static void main(String[] args) {
        President president1 = President.getInstance();
        president1.getName();
        President president2 = President.getInstance();
        president2.getName();

        if (president1 == president2) {
            System.out.println("president1 == president2");
        } else {
            System.out.println("president1 != president2");
        }
    }
}

class President {
    public static volatile President instance = null;

    private President() {
        System.out.println("产生一个总统");
    }

    public static President getInstance() {
        if (instance == null) {
            instance = new President();
        } else {
            System.out.println("已经有以为总统了");
        }
        return instance;
    }

    public void getName() {
        System.out.println("我是总统特朗普");
    }
}
