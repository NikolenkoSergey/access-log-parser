package ru.courses.OOP_8.GeometricFigures;

public class AreaCalculator {
    public static double sumAllAreas(Countrable... figures){
        double sum =0;
        for (Countrable figure : figures) {
            sum += figure.getArea();
        }
        return sum;
    }

}
