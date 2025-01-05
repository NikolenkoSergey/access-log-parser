package ru.courses.OOP_8.Points;

public class OneDimensionalPoint extends Points{



    public OneDimensionalPoint(int x, String color, String time) {
        super(x, color, time);
    }

    @Override
    public  String toString() {
        return "Точка в координате {" + super.getX() +
                "} в " + super.getTime() +
                ", цвет: " + super.getColor();
    }

}
