package facade;

public class FacadePatternDemo {
    public static void main(String[] args) {
        ShapeMaker shapeMaker = new ShapeMaker();
        shapeMaker.drawCircle();
        shapeMaker.drawRectangle();
        shapeMaker.drawSquare();
    }
}

class ShapeMaker {
    private Shape circle;
    private Shape rectangle;
    private Shape square;

    public ShapeMaker() {
        this.circle = new Circle();
        this.rectangle = new Rectangle();
        this.square = new Square();
    }

    public void drawCircle() {
        circle.draw();
    }
    public void drawRectangle() {
        rectangle.draw();
    }
    public void drawSquare() {
        square.draw();
    }
}

interface Shape {
    void draw();
}

class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Circle");
    }
}
class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Rectangle");
    }
}
class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Square");
    }
}














