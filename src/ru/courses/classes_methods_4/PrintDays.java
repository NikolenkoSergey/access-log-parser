package ru.courses.classes_methods_4;

public class PrintDays {
    public static void printDays(String x) {
        switch (x) {
            case "Понедельник":
                System.out.println("Понедельник");
            case "Вторник":
                System.out.println("Вторник");
            case "Среда":
                System.out.println("Среда");
            case "Четверг":
                System.out.println("Четверг");
            case "Пятница":
                System.out.println("Пятница");
            case "Суббота":
                System.out.println("Суббота");
            case "Воскресенье":
                System.out.println("Воскресенье");
                break;
            default:
                System.out.println("Это не день недели");
        }
    }
}
