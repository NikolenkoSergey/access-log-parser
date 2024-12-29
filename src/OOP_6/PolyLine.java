package OOP_6;

import OOP_8.Measurable;

import java.util.Arrays;

public class PolyLine implements Measurable {
    public Point[] arrPoint;

    public PolyLine(Point[] arrPoint) {
        this.arrPoint = arrPoint;
    }

    public PolyLine() {
    }

    public void setArrPoint(Point[] arrPoint) {
        this.arrPoint = arrPoint;
    }

    public Point[] getArrPoint() {
        return arrPoint;
    }

    @Override
    public String toString() {
        return "Линия "  + Arrays.toString(arrPoint);
    }

    public double getLengthLines() {
        double sum = 0;
        for (Line value : this.getLines()) {
            sum += value.getLength();
        }
        return sum;
    }
    public double getLength() {
        double sum = 0, len1, len2;
        for (int i = 0; i < arrPoint.length - 1; i++) {
            len1 = arrPoint[i].getX() - arrPoint[i + 1].getX();
            len2 = arrPoint[i].getY() - arrPoint[i + 1].getY();
            sum+= Math.sqrt(len1 * len1 + len2 * len2);
        }
        return sum;
    }
    public Line[] getLines() {
        Line[] arrL = new Line[this.getArrPoint().length - 1];
        for (int i = 0; i < this.getArrPoint().length; i++) {
            arrL[i] = new Line(this.getArrPoint()[i], this.getArrPoint()[i + 1]);
            if (i == this.getArrPoint().length - 2) break;
        }
        return arrL;
    }
}
