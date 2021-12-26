package Inheritance;

public class Triangle extends Figure {
    private int c;
    public  Triangle (int a, int b, int c){
        super(a,b);
        this.c = c;

    }

    @Override
    public double area() {
        double p = (getA() + getB() + c) /2;
        double s = p * (p - getA()) * (p-getB()) * (p-c);
        return Math.sqrt(s);
    }

    public  Triangle (int size){
        super(size,size);
        this.c = size;


    }
}
