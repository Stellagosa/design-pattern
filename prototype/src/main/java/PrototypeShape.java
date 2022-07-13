import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PrototypeShape {
    public static void main(String[] args) {
        PrototypeManager manager = new PrototypeManager();
        Shape circle = manager.getShape("Circle");
        circle.countArea();
        Shape square = manager.getShape("Square");
        square.countArea();
    }
}

interface Shape extends Cloneable {
    Object clone();

    void countArea();
}

class Circle implements Shape {
    @Override
    public Object clone() {
        Circle c = null;
        try {
            c = (Circle) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("Circle拷贝失败");
        }
        return c;
    }

    @Override
    public void countArea() {
        System.out.println("请输入圆的半径");
        Scanner input = new Scanner(System.in);
        int r = input.nextInt();
        System.out.println("该圆的半径为：" + 3.14 * r * r);
    }
}

class Square implements Shape {
    @Override
    public Object clone() {
        Square s = null;
        try {
            s = (Square) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("Square拷贝失败");
        }
        return s;
    }

    @Override
    public void countArea() {
        System.out.println("这是一个正方形，请输入它的边长");
        Scanner scanner = new Scanner(System.in);
        int w = scanner.nextInt();
        System.out.println("该正方形面积为：" + w * w);
    }
}

class PrototypeManager {

    private Map<String, Shape> map;

    public PrototypeManager() {
        map = new HashMap<>();
        map.put("Circle", new Circle());
        map.put("Square", new Square());
    }

    public Shape getShape(String key) {
        return (Shape) map.get(key).clone();
    }

    public void setMap(String key, Shape shape) {
        map.put(key, shape);
    }
}
