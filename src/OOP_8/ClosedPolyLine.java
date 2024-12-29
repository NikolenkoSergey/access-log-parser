package OOP_8;

import OOP_6.Line;
import OOP_6.Point;
import OOP_6.PolyLine;

public class ClosedPolyLine extends PolyLine {

    public ClosedPolyLine(Point[] arrPoint) {
        this.arrPoint = arrPoint;
    }

    @Override
    public double getLength() {
        double sum = 0, len1, len2;
        for (int i = 0; i < arrPoint.length - 1; i++) {
            len1 = arrPoint[i].getX() - arrPoint[i + 1].getX();
            len2 = arrPoint[i].getY() - arrPoint[i + 1].getY();
            sum+= Math.sqrt(len1 * len1 + len2 * len2);
        }
        len1 = arrPoint[arrPoint.length - 1].getX() - arrPoint[0].getX();
        len2 = arrPoint[arrPoint.length - 1].getY() - arrPoint[0].getY();
        return sum + Math.sqrt(len1 * len1 + len2 * len2);
    }

}
