package Employee;

public class Driver extends Employee implements CanDriver {

    public Driver (String name){
        super(name);
    }

    @Override
    public void CanDrive() {
        System.out.println("Водитель водит машину");
    }
}
