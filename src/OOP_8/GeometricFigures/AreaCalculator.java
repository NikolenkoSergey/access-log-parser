package OOP_8.GeometricFigures;

import java.util.List;

public class AreaCalculator {
    public static double sumAllAreas(Countrable... figures){
        double sum =0;
        for (Countrable figure : figures) {
            sum += figure.getArea();
        }
        return sum;
    }

}
