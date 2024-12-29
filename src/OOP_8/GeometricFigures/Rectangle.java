package OOP_8.GeometricFigures;

import OOP_6.Line;
import OOP_6.Point;

public class Rectangle extends Figure{

    private Line side1, side2;

    public Rectangle(Point point, Line side1, Line side2) {
        super(point);
        privateSetSide1(side1);
        privateSetSide2(side2);
    }

    public Line getSide1() {
        return side1;
    }

    public void setSide1(Line side1) {
        privateSetSide1(side1);
    }

    private void privateSetSide1(Line side1) {
        if (side1.getLength() <=0) throw new IllegalArgumentException("Сторона прямоугольника должна быть положительной");
        this.side1 = new Line(side1.getStart(), side1.getEnd());
    }

    public Line getSide2() {
        return side2;
    }

    public void setSide2(Line side2) {
        privateSetSide1(side1);
    }

    private void privateSetSide2(Line side2) {
        if (side2.getLength() <=0) throw new IllegalArgumentException("Сторона прямоугольника должна быть положительной");
        this.side2 = new Line(side2.getStart(), side2.getEnd());
    }
    @Override
    public double getArea() {
        return side1.getLength() * side2.getLength();
    }

    @Override
    public String toString() {
        return "Прямоугольник: " +
                "Сторона1= " + side1 +
                " Сторона2= " + side2 +
                ", Левый верхний угол= " + this.getPoint();
    }
}
