package OOP_8;

import java.util.List;

public class SumCalculator {
    public static double allSum(List<Number> numbers){
        double sum =0;
        for (Number number : numbers) {
            sum += number.doubleValue();
        }
        return sum;
    }
}
