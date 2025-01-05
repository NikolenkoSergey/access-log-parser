package ru.courses.classes_methods_4;

public class Age {
    public static String age(int x){
        if (x%10==1 && x%100!=11 ) {
            return x +" Год";
        } else if (x%10==2 && x%100!=12 || x%10==3 && x%100!=13 || x%10==4 && x%100!=14) {
            return x +" Года";
        }
        return x +" Лет";
    }

}
