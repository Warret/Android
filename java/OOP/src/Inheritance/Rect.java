package Inheritance;

public class Rect extends Figure {
    public Rect(int a, int b) {
        super(a, b);
    }

    public Rect(int size) {
        super(size, size);
    }

    @Override
    public double area() {
        return getA() * getB();
    }


}
