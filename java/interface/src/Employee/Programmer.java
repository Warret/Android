package Employee;

public class Programmer extends Employee implements CanProgrammer {

    public Programmer(String name) {
        super(name);
    }

    @Override
    public void CanWrite() {
        System.out.println("Программист пишит код");
    }
}
