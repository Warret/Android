package box;

public class BoxWeight extends Box {

    private double weight;



    public BoxWeight(double width, double height, double length, double weight) {
        super(width, height, length);
        this.weight = weight;
    }

    public BoxWeight (){
        super();
        this.weight= 0;
    }

    public BoxWeight(double size, double weight) {
        super(size);
        this.weight = weight;
    }






    public double getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println(" Вес " + getWeight());
    }
}

