package classes_methods_4;

public class SumLastNums {
    public static int sumLastNums(int x){
        int y = x%10;
        int z = x%100/10;
        return y+z;
    }
}
