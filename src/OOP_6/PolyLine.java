package OOP_6;

import java.util.Arrays;

public class PolyLine {
    Point[] arrPoint;

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
        double sum = 0;
        for (int i = 0; i < this.getArrPoint().length; i++) {
            Line line = new Line(this.getArrPoint()[i], this.getArrPoint()[i + 1]);
            sum += line.getLength();
            if (i == this.getArrPoint().length - 2) break;
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
