package Test;

public class Man {
    private String name;
    private String dolgnost;
    private int age;
    private double growth;

    public Man(String name, String dolgnost, int age, double growth) {
        this.name = name;
        this.dolgnost = dolgnost;
        this.age = age;
        this.growth = growth;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getDolgnost() {
        return dolgnost;
    }

    public void setDolgnost(String dolgnost) {
        this.dolgnost = dolgnost;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getGrowth() {
        return growth;
    }

    public void setGrowth(double growth) {
        this.growth = growth;
    }
}
