package OOP_8.Points;

public class TwoDimensionalPoint extends Points{

    private int y;
    public TwoDimensionalPoint(int x, int y, String color, String time) {
        super(x, color, time);
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Точка в координате {" + super.getX() +","+ y+
                "} в " + super.getTime() +
                ", цвет: " + super.getColor();
    }
}
