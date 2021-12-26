package Employee;

public class Cook extends Employee implements CanCook{
    public Cook(String name) {
        super(name);
    }

    @Override
    public void CanCook() {
        System.out.println("Повар готовит");
    }
}
