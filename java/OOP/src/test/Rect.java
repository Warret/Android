package test;

public class Rect {
    int width;
    int height;

    void construct(int width, int height){
        this.height=height;
        this.width=width;
    }
    int Per(){
        return 2 * (width + height);
    }
    int Squ(){
        return width * height;
    }
}
