package ru.courses.OOP_8.Points;

public abstract class Points{
    private int x;
    private String color, time;

    public Points(int x,  String color, String time) {
        privateSetX(x);
        this.color = color;
        this.time = time;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        privateSetX(x);
    }

    private void privateSetX(int x) {
        if (x <= 0) throw new IllegalArgumentException("Должет быть положительным");
        this.x = x;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

}
