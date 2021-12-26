package main;


import Inheritance.Rect;
import Inheritance.Triangle;
import box.Box;
import box.BoxWeight;
import test.Empty;

import javax.swing.plaf.IconUIResource;

public class Main {

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            int random = (int) (Math.random() * 90 + 10);
            System.out.println(String.format("Случайное число %s Попробуйте еще раз", random));
        }


    }

}
