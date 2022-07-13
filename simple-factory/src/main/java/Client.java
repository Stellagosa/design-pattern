public class Client {
    public static void main(String[] args) {
        Product product1 = SimpleFactory.makeProduct(2);
        assert product1 != null;
        product1.show();
        Product product2 = SimpleFactory.makeProduct(1);
        assert product2 != null;
        product2.show();
    }

    interface Product {
        void show();
    }

    static class ConcreteProduct1 implements Product {
        @Override
        public void show() {
            System.out.println("产品1号展示");
        }
    }

    static class ConcreteProduct2 implements Product {
        @Override
        public void show() {
            System.out.println("产品2号展示");
        }
    }

    static final class Const {
        static final int PRODUCT_A = 1;
        static final int PRODUCT_B = 2;
    }

    static class SimpleFactory {

        public static Product makeProduct(int num) {
            switch (num) {
                case Const.PRODUCT_A: return new ConcreteProduct1();
                case Const.PRODUCT_B: return new ConcreteProduct2();
            }
            return null;
        }
    }
}


