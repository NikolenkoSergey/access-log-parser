package ru.courses.OOP_8.GeometricFigures;

import ru.courses.OOP_6.Line;
import ru.courses.OOP_6.Point;

public class Square_figure extends Figure{

    private Line side;

    public Square_figure(Point point, Line side) {
        super(point);
        privateSetSide(side);
    }

    @Override
    public double getArea() {
        return Math.pow(side.getLength(), 2);
    }

    public Line getSide() {
        return side;
    }

    public void setSide(Line side) {
        privateSetSide(side);
    }

    private void privateSetSide(Line side) {
        if (side.getLength() <=0) throw new IllegalArgumentException("Сторона квадрата должна быть положительной");
        this.side = new Line(side.getStart(), side.getEnd());
    }
    @Override
    public String toString() {
        return "Квадрат: " +
                "Сторона= " + side +
                ", Левый верхний угол= " + this.getPoint();
    }
}
