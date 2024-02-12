package de.dhbw.nikolas.exercise.classes;

public class Polynom {

    private double a, b, c;

    public Polynom(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Polynom() {
        this(1, 1, 1);
    }

    public double f(int x) {
        return a * Math.pow(x, 2) + b * x + c;
    }

    public Polynom add(final Polynom p) {
        return new Polynom(a + p.a, b + p.b, c + p.c);
    }

    public Polynom substract(final Polynom p) {
        return new Polynom(a - p.a, b - p.b, c - p.c);
    }

    public Polynom multiply(final int k) {
        return new Polynom(k * a, k * b, k * c);
    }

    public double[] getRoots() {
        double d = Math.pow(b, 2) - 4 * a * c;

        if (d >= 0) {
            double x1 = (-b + Math.sqrt(d)) / (2 * a);
            double x2 = (-b - Math.sqrt(d)) / (2 * a);

            if (x1 == x2) {
                return new double[]{x1};
            }

            return new double[]{x1, x2};
        }

        return new double[]{};

    }

    public double getValue(double x) {
        return a * x * x + b * x + c;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    @Override
    public String toString() {
        return "Polynom{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }
}
