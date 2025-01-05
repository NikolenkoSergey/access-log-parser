package ru.courses.OOP_8;

import ru.courses.OOP_6.Point;
import ru.courses.OOP_6.PolyLine;

public class ClosedPolyLine extends PolyLine {

    public ClosedPolyLine(Point[] arrPoint) {
        this.arrPoint = arrPoint;
    }

    @Override
    public double getLength() {
        double sum = super.getLength();
        double len1, len2;
        len1 = arrPoint[arrPoint.length - 1].getX() - arrPoint[0].getX();
        len2 = arrPoint[arrPoint.length - 1].getY() - arrPoint[0].getY();
        return sum + Math.sqrt(len1 * len1 + len2 * len2);
    }
}
