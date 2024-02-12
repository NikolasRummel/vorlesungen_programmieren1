package de.dhbw.nikolas.exercise.classes;

import java.util.Random;

public class ComplexNumber {

    private double real;
    private double imaginary;

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }


    public ComplexNumber add(ComplexNumber c) {
        return new ComplexNumber(real + c.real, imaginary + c.imaginary);
    }

    public ComplexNumber substract(ComplexNumber c) {
        return new ComplexNumber(real - c.real, imaginary - c.imaginary);
    }

    public ComplexNumber multiply(ComplexNumber c) {
        return new ComplexNumber(real * c.real - imaginary * c.imaginary, real * c.imaginary + imaginary * real);
    }

    public ComplexNumber divide(ComplexNumber c) {
        return new ComplexNumber(
                (real * c.real + imaginary * c.imaginary) / (real * real + c.imaginary * c.imaginary),
                (imaginary * c.real - real * c.imaginary) / (real * real + c.imaginary * c.imaginary)
        );
    }


    public double getMagnitude() {
        return Math.sqrt(real * real + imaginary * imaginary);
    }

    public boolean isLess(ComplexNumber c) {
        return getMagnitude() > c.getMagnitude();
    }

    public ComplexNumber() {
        this(0, 0);
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImaginary() {
        return imaginary;
    }

    public void setImaginary(double imaginary) {
        this.imaginary = imaginary;
    }

    @Override
    public String toString() {
        return "ComplexNumber{" +
                "real=" + real +
                ", imaginary=" + imaginary +
                '}';
    }


    public static void main(String[] args) {
        ComplexNumber[] complexNumbers = new ComplexNumber[10];

        for (int i = 0; i < 10; i++) {
            Random random = new Random();
            complexNumbers[i] = new ComplexNumber(random.nextDouble() * 10, random.nextDouble() * 10);
            System.out.println(complexNumbers[i]);
        }

        for (int i = 0; i < complexNumbers.length; i++) {
            for (int j = 0; j < complexNumbers.length - 1; j++) {
                if (complexNumbers[j].getMagnitude() < complexNumbers[j + 1].getMagnitude()) {
                    ComplexNumber temp = complexNumbers[j];
                    complexNumbers[j] = complexNumbers[j + 1];
                    complexNumbers[j + 1] = temp;
                }
            }
        }

        System.out.println("Sorted: ");
        for (int i = 0; i < 10; i++) {
            System.out.println(complexNumbers[i]);
        }
    }
}
