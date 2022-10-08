package Chapter5;

class Shape {
    public Shape next;
    public Shape() { next = null; }
    public void draw() {
        System.out.println("Shape");
    }
}
class Line extends Shape {
    public void draw() {  //오버라이딩 => 재정의
        System.out.println("Line");
    }
}
class Rect extends Shape {
    public void draw() {
        System.out.println("Rect");
    }
}
class Circle extends Shape {
    public void draw() {
        System.out.println("Circle");
    }
}

public class MethodOverridingEx {
    static void paint(Shape p) {
        p.draw();
    }
    public static void main(String[] args) {
        Line line = new Line();
        paint(line);
        paint(new Shape());
        paint(new Line());
        paint(new Rect());
        paint(new Circle());
    }
}