package OOP_7;

public class Fraction {
    private int numerator, denominator;


    public Fraction(int numerator, int denominator) {
        if (denominator <= 0)
            throw new IllegalArgumentException("Знаменатель не может быть отрицательным или равен 0 ");
        this.numerator = numerator;
        this.denominator = denominator;
        simplify();
    }

    // Сложение дробей
    public Fraction sum(Fraction fraction) {
        int numerator = this.numerator * fraction.getDenominator() + fraction.getNumerator() * this.denominator;
        int denominator = this.denominator * fraction.getDenominator();
        return new Fraction(numerator, denominator);
    }

    // Сложение целого числа
    public Fraction sum(int number) {
        int numerator = this.numerator + number * this.denominator;
        int denominator = this.denominator;
        return new Fraction(numerator, denominator);
    }

    // Вычитание дробей
    public Fraction minus(Fraction fraction) {
        int numerator = this.numerator * fraction.getDenominator() - fraction.getNumerator() * this.denominator;
        int denominator = this.denominator * fraction.getDenominator();
        return new Fraction(numerator, denominator);
    }

    // Вычитание целого числа
    public Fraction minus(int number) {
        int numerator = this.numerator - number * this.denominator;
        int denominator = this.denominator;
        return new Fraction(numerator, denominator);
    }

    // Приведение дроби к наименьшему общему знаменателю
    private void simplify() {
        int gcd = gcd(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;
    }

    // Нахождение НОД с использованием алгоритма Евклида
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return Math.abs(a);
    }

    private int getNumerator() {
        return numerator;
    }

    private int getDenominator() {
        return denominator;
    }

    @Override
    public String toString() {
        return "Fraction: " + numerator + "/" + denominator;
    }
}
