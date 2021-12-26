package test;

public class Worker {
    String Name;
    String Position;
    int Salary;

    public Worker(String Name, String Position, int Salary) {
        this.Name = Name;
        this.Position = Position;
        this.Salary = Salary;
    }

    String info(int i) {
        return "Сотрудник " + Name + " Имеет должность " + Position
                + " за последние " + i + " месяцев " + "Получил " + i * Salary + " рублей";

    }
}
