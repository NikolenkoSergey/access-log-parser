package classes_methods_4;

public class IsInRange {
    public static boolean isInRange(int a, int b, int num) {
        return num <= a && num >= b || num >= a && num <= b;
    }


}
