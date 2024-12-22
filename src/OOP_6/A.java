package OOP_6;

public class A {

    private B b;

    public B getB() {
        return b;
    }

    public void setB(B b) {
        if(b.x<0) throw new IllegalArgumentException("sdfsd");
        this.b = new B(b.x);
    }
    public void setB1(B b) {
        if(b.x<0) throw new IllegalArgumentException("sdfsd");
        this.b = b;
    }

    @Override
    public String toString() {
        return "A{" +
                "b=" + b +
                '}';
    }
}

