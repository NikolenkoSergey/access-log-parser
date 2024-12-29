package OOP_8.GeometricFigures;

import OOP_6.Line;
import OOP_6.Point;
import OOP_8.Birds.Birdable;


public abstract class Figure implements Countrable{
        private Point point;

        public Figure(Point point) {
                this.point = point;
        }

        public Point getPoint() {
                return point;
        }

        public void setPoint(Point point) {
                this.point = new Point(point.getY(), point.getY());
        }

        public abstract double getArea();
}
