package ru.courses.OOP_6;

import ru.courses.OOP_8.Measurable;

public class Line implements Measurable {
    public Point start, end;

    public Line(Point start, Point end) {
        this.start = new Point(start.getX(), start.getY());
        this.end = new Point(end.getX(), end.getY());

    }

    public Line(int x1, int y1, int x2, int y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }

    public Point getStart() {
        return start;
    }

    public Point getEnd() {
        return end;
    }

    @Override
    public String toString() {
        return "Линия от " +
                start + " до " + end;
    }

    public double getLength() {
        double x = start.getX() - end.getX();
        double y = start.getY() - end.getY();
        return Math.sqrt(x * x + y * y);
    }
}
