package ru.courses.main;
import ru.courses.OOP_8.Measurable;
import ru.courses.OOP_9.Fraction;
import ru.courses.OOP_9.Line;
import ru.courses.OOP_9.Point;
import ru.courses.OOP_8.Student.Student;
import ru.courses.OOP_9.PolyLine;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{
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
//        Point start1 = new Point(1, 3);
//        Point end1 = new Point(5, 8);
//        Point start2 = new Point(10, 11);
//        Point end2 = new Point(15, 19);
//
//        Line l1 = new Line(start1, end1);
//        Line l2 = new Line(start2, end2);
//        Line l3 = new Line(end1, start2);
//
//        System.out.println("Координаты линии №3: " + l3);
//
//        end1.setPoint(99, 100);
//        start2.setPoint(200, 222);
//        System.out.println("Координаты линии №3 после изменений: " + l3);
//        sumLengthLine(l1,l2,l3);
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
        //-------------------------------

//        // Задание 7.1 Дробь
//        Fraction f1 = new Fraction(1, 3);
//        Fraction f2 = new Fraction(2, 5);
//        Fraction f3 = new Fraction(7, 8);
//
//        System.out.println(f1.sum(f2).sum(f3).minus(5));
        //-------------------------------

        // Задание 7.2 Квадрат
//        Square s = new Square(10, 2, 4);
//        Point p = new Point(30,40);
//        System.out.println(s);
//        s.setSideLength(20);
//        s.setPoint(5, 7);
//        System.out.println(s);
//        s.setPoint(p);
//        System.out.println(s);
//        System.out.println(s.getPoint());
        //-------------------------------

//        // Задание 7.3 Студент
//        int[] g = new int[]{4,4,2,0,2};
//
//        Student s = new Student("Alex", g);
//        System.out.println(s);
//
//        g[0] = 3;
//        g[1] = 3;
//        g[0] = 3;
//        System.out.println("------------");
//        System.out.println(s);
//        System.out.println(Arrays.toString(s.getGrades()));
//
//        s.setGrades(5);
//        s.setGrades(4);
//        s.setGrades(3);
//        s.setGrades(5);
//        System.out.println("------------");
//        System.out.println(s);
//        System.out.println(Arrays.toString(s.getGrades()));
        //-------------------------------

//        // Задание 7.4 Сотрудник и отделы
//        Department home = new Department("Home", null);
//        Employee sergey = new Employee("Sergey", home);
//        Employee fatima = new Employee("Fatima", home);
//        home.setBoss(fatima);
//
//        Employee artem = new Employee("Artem", home);
//        Department home1 = new Department("Home1", null);
//        Employee roman = new Employee("Roman", home1);
//
////        artem.setDepartment(home1);
//        home.setBoss(artem);
//        home1.setBoss(roman);
//        artem.setDepartment(home1);
//
//        System.out.println(sergey);
//        System.out.println(fatima);
//        System.out.println(artem);
//        System.out.println(home);
//        System.out.println(home1);
        //-------------------------------

//        // Задание 8.1 Point3D

//        Point3D p = new Point3D(1,2,3);
//        System.out.println(p);
//        p.setY(33);
//        p.setZ(44);
//        System.out.println(p);
        //-------------------------------

        // Задание 8.2 ClosedPolyLine
//        Point p1 = new Point(1, 1);
//        Point p2 = new Point(2, 2);
//        Point p3 = new Point(3, 3);
//        Point[] arrp = new Point[]{p1, p2, p3};
//        PolyLine p5 = new PolyLine(arrp);
//        ClosedPolyLine p4 = new ClosedPolyLine(arrp);
//
//        System.out.println(p4);
//        System.out.println(p4.getLength());
//        System.out.println(p5);
//        System.out.println(p5.getLength());
        //-------------------------------

//        // Задание 8.3 Measurable интерфейсы
//        Point p1 = new Point(1, 1);
//        Point p2 = new Point(2, 2);
//        Point p3 = new Point(3, 3);
//        Point[] arrp = new Point[]{p1, p2, p3};
//        Line l = new Line(p1,p2);
//        PolyLine p5 = new PolyLine(arrp);
//        ClosedPolyLine p4 = new ClosedPolyLine(arrp);
//        System.out.println(lengthPolyLines(p4));
//        System.out.println(lengthPolyLines(p5));
//        System.out.println(lengthPolyLines(l));
//        System.out.println(l.getLength());
        //-------------------------------

//        // Задание 8.4 Длина строки - задание необязательное
//        String str = "sdfs";
//        System.out.println(str.length());
//        Measurable measurableStr = new Measurable() {
//            @Override
//            public double getLength() {
//                return str.length();
//            }
//        };
//        System.out.println(lengthPolyLines(measurableStr));
        //-------------------------------

//        // Задание 8.5 Дробь это число
//        Fraction f1 = new Fraction(1, 4);
//        Fraction f2 = new Fraction(4, 2);
//        System.out.println(f1.intValue());
//        System.out.println(f2.intValue());
//        System.out.println(f1.longValue());
//        System.out.println(f2.longValue());
//        System.out.println(f1.floatValue());
//        System.out.println(f2.floatValue());
//        System.out.println(f1.doubleValue());
//        System.out.println(f2.doubleValue());
        //-------------------------------

//        // Задание 8.6 Сложение
//        Fraction f1 = new Fraction(3,5);
//        List<Number> list1 = List.of(2, f1, 2.3);
//        System.out.println(SumCalculator.allSum(list1));
//
//        Fraction f2 = new Fraction(49,12);
//        Fraction f3 = new Fraction(3,2);
//        List<Number> list2 = List.of(3.6, f2, 3, f3);
//        System.out.println(SumCalculator.allSum(list2));
//
//        Fraction f4 = new Fraction(1,3);
//        List<Number> list3 = List.of(f4,1);
//        System.out.println(SumCalculator.allSum(list3));
        //-------------------------------

//        // Задание 8.7 Птицы
//        Sparrow sparrow = new Sparrow();
//        sparrow.sing();
//        Cuckoo cuckoo =new Cuckoo();
//        cuckoo.sing();
//        Parrot parrot = new Parrot();
//        parrot.sing();
        //-------------------------------

//        // Задание 8.8 Птичий рынок
//        Sparrow sparrow = new Sparrow();
//        Sparrow sparrow1 = new Sparrow();
//        Sparrow sparrow2 = new Sparrow();
//
//        Cuckoo cuckoo =new Cuckoo();
//        Cuckoo cuckoo1 =new Cuckoo();
//
//        Parrot parrot = new Parrot();
//        Parrot parrot1 = new Parrot();
//
//        birdSong(sparrow,sparrow1,sparrow2,cuckoo,cuckoo1,parrot,parrot1);
        //-------------------------------

////        // Задание 8.9 Фигуры
//        Point p1 = new Point(3, 5);
//        Point p2 = new Point(4, 4);
//        Line l1 = new Line(p1, p2);
//        Circle circle = new Circle(p1, l1);
//        System.out.println(circle);
//        System.out.println("Площадь круга: " + circle.getArea());
//
//        p2.setPoint(6, 6);
//        Square_figure square = new Square_figure(p2, l1);
//        System.out.println(square);
//        System.out.println("Площадь квадрата: " + square.getArea());
//
//        p2.setPoint(7, 7);
//        Point p3 = new Point(1, 1);
//        Line l2 = new Line(p2, p3);
//        Rectangle rectangle = new Rectangle(p2, l1, l2);
//        System.out.println(rectangle);
//        System.out.println("Площадь прямоугольника: " + rectangle.getArea());
//        //-------------------------------
//
////        // Задание 8.10 Общая площадь
//        Point p11 = new Point(7, 6);
//        Point p21 = new Point(5, 7);
//        Line l11 = new Line(p11, p21);
//
//        Circle circle1 = new Circle(p11, l11);
//        Square_figure square1 = new Square_figure(p21, l11);
//        Square_figure square3 = new Square_figure(p3, l2);
//
//        System.out.println(square.getArea() + square1.getArea()+square3.getArea()+circle.getArea()+circle1.getArea());
//        System.out.println("Сума полощадей фигур " + AreaCalculator.sumAllAreas(square,square1,square3,circle,circle1));
//        //-------------------------------
//
////        // Задание 8.12 Студент с правилом
//        Student s = new Student("Sasha", grade-> grade >= 2 && grade <= 5);
//        Student s1 = new Student("Sasha", grade-> grade >= 1 && grade <= 1000000 && grade%2==0);
//        s1.addGrade(1000002);
//        s1.addGrade(2);
//        s1.addGrade(1000000);
//        System.out.println(s1);
//        //-------------------------------
//
////        // Задание 8.2.3 Возведение в степень
//        MyPow.mypow();
//        //-------------------------------
//
////        // Задание 8.2.4 Простые имена
//        Point p1 = new Point(3,4);
//        java.awt.Point p2 = new java.awt.Point(5,6);
//        System.out.println(p1);
//        System.out.println(p2);
//        //-------------------------------
//
////        // Задание 9.1.2 Сравнение точек
//        Point p1 = new Point(3,3 );
//        Point p2 = new Point(3,3 );
//        System.out.println(p1==p2);
//        System.out.println(p1.equals(p2));
//        System.out.println("-----------------");
//        Point p3 = p1.clone();
//        System.out.println(p1==p3);
//        System.out.println(p1.equals(p3));
//        System.out.println(p3);
//        //-------------------------------
//
//        // Задание 9.1.3 Сравнение Линий
//        Point p1 = new Point(3,3 );
//        Point p2 = new Point(3,2 );
//        Point p3 = new Point(3,3 );
//        Line l1 = new Line(p1,p2);
//        Line l2 = new Line(p1,p2);
//        Line l3 = new Line(p1,p3);
//        System.out.println(l1==l2);
//        System.out.println(l1.equals(l2));
//        System.out.println("-----------------3");
//        System.out.println(l1==l3);
//        System.out.println(l1.equals(l3));
//        System.out.println("-----------------4");
//        Line l4 = (Line) l3.clone();
//        System.out.println(l3==l4);
//        System.out.println(l3.equals(l4));
//
//        System.out.println("-----------------4Point");
//        p1.setX(99);
//        System.out.println(l3==l4);
//        System.out.println(l3.equals(l4));
//
//        System.out.println("-----------------4+++");
//        l3.setStart(p2);
//        System.out.println(l3==l4);
//        System.out.println(l3.equals(l4));
//        //-------------------------------
//
//        // Задание 9.1.4 Сравнение ломаных Линий
//        Point p1 = new Point(3,1 );
//        Point p2 = new Point(3,2 );
//        Point p3 = new Point(3,3 );
//        Point p4 = new Point(3,4 );
//        PolyLine pl1 = new PolyLine(p1,p2,p3);
//        PolyLine pl2 = new PolyLine(p1,p2,p3);
//        PolyLine pl3 = new PolyLine(p1,p2,p4);
//        System.out.println(pl1==pl2);
//        System.out.println(pl1.equals(pl2));
//        System.out.println("-----------------");
//        System.out.println(pl1==pl3);
//        System.out.println(pl1.equals(pl3));
//        //-------------------------------
//
//        // Задание 9.1.1 Сравнение дробей
        Fraction f1 = new Fraction(1,2);
        Fraction f2 = f1.clone();
        f1.setDenum(9);
        System.out.println(f1==f2);
        System.out.println(f1.equals(f2));
        System.out.println(f1);
        System.out.println(f2);

    }


//    // Задание 8.3 Measurable интерфейсы. Измерение длины
//    public static double lengthPolyLines(Measurable object) {
//        return object.getLength();
//    }
//
//    // Задание 6.2 линия
//    public static void sumLengthLine(Line... line) {
//        double sum = 0;
//        for (Line value : line) {
//            sum += value.getLength();
//        }
//        if (line.length == 1) {
//            System.out.println("Длина линий: " + sum);
//        } else {
//            System.out.println("Сумма длин " + line.length + " линий: " + sum);
//        }
//    }

}

