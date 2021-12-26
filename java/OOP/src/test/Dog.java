package test;

public class Dog {
    String Name;
    String Breed;
    int speed;

    void run() {
        for (int i = 1; i <= speed; i++) {
            if (i == speed) {
                System.out.print("бегу");
            } else System.out.print("бегу, ");
        }
    }

    String info() {
         return Name + " " + Breed + " " + " " + speed;
    }
}
