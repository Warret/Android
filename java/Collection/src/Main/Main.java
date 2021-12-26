package Main;

import Test.Man;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
//        String str = "Это Иван, Ему 34 года, его рост 166.3 см. Должность - программист";
//        String name = str.substring(4, 8);
//        int age = Integer.parseInt(str.substring(14, 16));
//        double growth = Double.parseDouble(str.substring(32, 37));
//        String dolgnost = str.substring(54);
//        Man man = new Man(name, dolgnost,age,growth);
//        System.out.println(man.getName());
//        System.out.println(man.getAge());
//        System.out.println(man.getDolgnost());
//        System.out.println(man.getGrowth());


        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i=0; i<1000; i++){
            numbers.add(i);
        }
        int sum =0;
        for (int i:
             numbers) {
            sum +=i;
            System.out.println(sum);
        }
    }
}
