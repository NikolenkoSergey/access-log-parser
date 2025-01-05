package ru.courses.classes_methods_4;

public class Is35 {
    public static boolean is35(int x){
        if (x%3==0 && x%5==0) return false;
        return  (x%3==0 || x%5==0);
    }

}
