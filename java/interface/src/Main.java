import Employee.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Programmer programmer1 = new Programmer("Володя");
        Programmer programmer2 = new Programmer("Саня");
        Programmer programmer3 = new Programmer("Женя");

        Driver driver1 = new Driver("Митяй");
        Driver driver2 = new Driver("Кирилл");
        Driver driver3 = new Driver("Понтий");

        Cook cook1 = new Cook("Петр");
        Cook cook2 = new Cook("Олег");
        Cook cook3 = new Cook("Мария");

        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(programmer1);
        employees.add(programmer2);
        employees.add(programmer3);

        employees.add(driver1);
        employees.add(driver2);
        employees.add(driver3);

        employees.add(cook1);
        employees.add(cook2);
        employees.add(cook3);

        for (Employee empl : employees){
            empl.voice();
        }

        ArrayList<Programmer> prog = new ArrayList<>();
        prog.add(programmer1);
        prog.add(programmer2);
        prog.add(programmer3);

        for (Programmer programmer: prog) {
            programmer.CanWrite();
        }

      
    }

}
