package OOP_7;

import OOP_6.Point;

public class Square {

    private int sideLength;
    public Point point;

    public Square(int sideLength, int x, int y) {
        setSideLength(sideLength);
        this.point = new Point(x, y);
    }

    public void setSideLength(int sideLength) {
        if (sideLength <=0) throw new IllegalArgumentException("Сторона квадрата должна быть положительной");
        this.sideLength = sideLength;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public void setPoint(int x, int y) {
        this.point = new Point(x,y);
    }

    @Override
    public String toString() {
        return "Квадрат в точке "+ point +" со стороной " + sideLength;
    }
}
