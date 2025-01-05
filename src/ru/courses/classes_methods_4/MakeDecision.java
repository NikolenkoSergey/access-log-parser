package ru.courses.classes_methods_4;

public class MakeDecision {
    public static String makeDecision(int x, int y){
        String str = x +" == "+ y;
        if (x>y) str=x +" > "+ y;
        if (x<y) str=x +" < "+ y;
        return str;
    }



}
