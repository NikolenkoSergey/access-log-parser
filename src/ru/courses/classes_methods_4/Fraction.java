package ru.courses.classes_methods_4;

public class Fraction {

    public static double fraction(double x){
        x-=(int)x;
        return Math.round(x*1000)/1000.;
    }
}
