package OOP_8.GeometricFigures;

import OOP_6.Line;
import OOP_6.Point;


public class Circle extends Figure{

    private Line radius;

    public Circle(Point point, Line radius) {
        super(point);
        privateSetRadius(radius);
    }

    public Line getRadius() {
        return radius;
    }

    public void setRadius(Line radius) {
        privateSetRadius(radius);
    }

    private void privateSetRadius(Line radius) {
        if (radius.getLength() <=0) throw new IllegalArgumentException("Радиус круга должен быть положительным");
        this.radius = new Line(radius.getStart(), radius.getEnd());
    }
    @Override
    public double getArea() {
        return Math.PI*Math.pow(getRadius().getLength(), 2);
    }

    @Override
    public String toString() {
        return "Круг: " +
                "радиус= " + radius +
                ", центр= " + this.getPoint() +
                '}';
    }

}
