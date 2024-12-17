import OOP_6.Line;
import OOP_6.Point;
import OOP_6.PolyLine;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Задание 6.1 точка
//        Point p1 = new Point(1, 3);
//        Point p2 = new Point(1, 3);
//        Point p3 = new Point(5, 8);
//
//        System.out.println(p1);
//        System.out.println(p2);
//        System.out.println(p3);
//
//        System.out.println(p1==p2);
//        System.out.println(p1==p3);
//-------------------------------

        // Задание 6.2 линия
        Point start1 = new Point(1, 3);
        Point end1 = new Point(5, 8);
        Point start2 = new Point(10, 11);
        Point end2 = new Point(15, 19);

        Line l1 = new Line(start1, end1);
        Line l2 = new Line(start2, end2);
        Line l3 = new Line(end1, start2);

        System.out.println("Координаты линии №3: " + l3);

        end1.setPoint(99, 100);
        start2.setPoint(200, 222);
        System.out.println("Координаты линии №3 после изменений: " + l3);
        sumLengthLine(l1,l2,l3);
        //-------------------------------

//        // Задание 6.3 Ломаная линия
//        Point p0 = new Point(1, 5);
//        Point p1 = new Point(2, 8);
//        Point p2 = new Point(5, 3);
//        Point p3 = new Point(8, 9);
//
//        Point[] r1 = new Point[]{p0, p1, p2, p3};
//        PolyLine pl1 = new PolyLine();
//        System.out.println("Ломаная без параметров: " + pl1);
//        pl1.setArrPoint(r1);
//        System.out.println(pl1);
//
//        p1.setPoint(12,8);
//        System.out.println("Длина ломаной: " + pl1.getLength());
//        System.out.println("Массив линий входящих в ломаную: " + Arrays.toString(pl1.getLines()));
//        System.out.println("Длина массива линий: " + pl1.getLengthLines());
//        System.out.println(pl1.getLengthLines() == pl1.getLength());

    }

    public static void sumLengthLine(Line... line) {
        double sum = 0;
        for (Line value : line) {
            sum += value.getLength();
        }
        if (line.length == 1) {
            System.out.println("Длина линий: " + sum);
        } else {
            System.out.println("Сумма длин " + line.length + " линий: " + sum);
        }
    }

}

