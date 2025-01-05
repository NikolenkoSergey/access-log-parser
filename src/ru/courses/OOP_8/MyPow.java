package ru.courses.OOP_8;

import java.util.Scanner;

public class MyPow {

    public double mypow(String number, String power){
        Scanner scanner = new Scanner(System.in);
        String num = scanner.nextLine();
        String pow = scanner.nextLine();
        double res;
        return res = Math.pow(Integer.parseInt(num), Integer.parseInt((pow)));

    }
}
