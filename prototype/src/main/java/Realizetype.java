public class Realizetype implements Cloneable {

    public Realizetype() {
        System.out.println("原型创建成功");
    }

    public Object clone() throws CloneNotSupportedException {
        System.out.println("原型复制成功");
        return ((Realizetype) super.clone());
    }
}

class DemoTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        Realizetype r1 = new Realizetype();
        Realizetype r2 = (Realizetype) r1.clone();
        System.out.println("r1 == r2???：" + (r1 == r2));
    }
}
