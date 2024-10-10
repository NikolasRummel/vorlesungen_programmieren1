package de.dhbw.nikolas.exercise;

import java.math.BigDecimal;
import java.math.MathContext;

public class RootFinderComparison {

    public static BigDecimal f(BigDecimal x) {
        return x.pow(3).subtract(BigDecimal.valueOf(3).multiply(x.pow(2))).add(x).add(BigDecimal.valueOf(3));
    }

    public static BigDecimal calculateNextX(BigDecimal x) {
        BigDecimal numerator = f(x);
        BigDecimal denominator = (BigDecimal.valueOf(3).multiply(x.pow(2))).subtract(BigDecimal.valueOf(6).multiply(x)).add(BigDecimal.ONE);
        return x.subtract(numerator.divide(denominator, MathContext.DECIMAL128));
    }

    public static BigDecimal bisectionMethod(BigDecimal a, BigDecimal b, BigDecimal tolerance, int maxIterations) {
        BigDecimal mid = a.add(b).divide(BigDecimal.valueOf(2), MathContext.DECIMAL128);
        for (int i = 0; i < maxIterations; i++) {
            mid = a.add(b).divide(BigDecimal.valueOf(2), MathContext.DECIMAL128);
            if (f(mid).compareTo(BigDecimal.ZERO) == 0) {
                return mid; // Found exact root
            } else if (f(a).multiply(f(mid)).compareTo(BigDecimal.ZERO) < 0) {
                b = mid; // Root is in left half
            } else {
                a = mid; // Root is in right half
            }

            if (b.subtract(a).abs().compareTo(tolerance) <= 0) {
                break;
            }
        }
        return mid;
    }

    public static void main(String[] args) {
        BigDecimal initialGuessNewton = BigDecimal.valueOf(1);
        BigDecimal tolerance = BigDecimal.valueOf(1e-10);
        BigDecimal a = BigDecimal.valueOf(-2);
        BigDecimal b = BigDecimal.valueOf(2);
        int maxIterations = 300;

        // Newton-Raphson method
        System.out.println("Newton-Raphson Method:");
        BigDecimal xNewton = initialGuessNewton;
        for (int i = 0; i < maxIterations; i++) {
            xNewton = calculateNextX(xNewton);
            System.out.printf("Iteration %d: x = %s, f(x) = %s\n", i + 1, xNewton.toString(), f(xNewton).toString());
        }

        // Bisection method
        System.out.println("\nBisection Method:");
        BigDecimal rootBisection = bisectionMethod(a, b, tolerance, maxIterations);
        System.out.printf("Root found: x = %s, f(x) = %s\n", rootBisection.toString(), f(rootBisection).toString());

        // Compare final results
        System.out.println("\nComparison of Results:");
        System.out.printf("Newton's final result: x = %s, f(x) = %s\n", xNewton.toString(), f(xNewton).toString());
        System.out.printf("Bisection's final result: x = %s, f(x) = %s\n", rootBisection.toString(), f(rootBisection).toString());

        System.out.println("----");
        System.out.println(xNewton.toString().length() / rootBisection.toString().length());
    }

}
