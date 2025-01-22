package ru.courses.OOP_8;

import java.util.Scanner;
import static java.lang.Math.pow;
import static java.lang.Integer.parseInt;

public class MyPow {

    public static void mypow(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите два числа");
        String num = scanner.nextLine();
        String powwer = scanner.nextLine();
        System.out.println((int) pow(parseInt(num), parseInt((powwer))));
    }
}
