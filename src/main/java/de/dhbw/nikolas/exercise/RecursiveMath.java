package de.dhbw.nikolas.exercise;

import java.math.BigDecimal;
import java.math.MathContext;

public class RecursiveMath {

    public int div(int x, int y) {
        if (y > x) return 0;
        if (y == 0) throw new RuntimeException();
        else return 1 + div(x - y, y);
    }

    public boolean isLess(int x, int y) {
        if (x == y) return false;
        if (x == 0 && y != 0) {
            return true;
        }
        if (y == 0) {
            return false;
        }
        return isLess(x - 1, y - 1);
    }

    public boolean isBigger(int x, int y) {
        if (x == y) return false;
        if (y == 0 && x != 0) {
            return true;
        }
        if (x == 0) {
            return false;
        }
        return isBigger(x - 1, y - 1);
    }

    public static BigDecimal calculateNextX(BigDecimal x) {
        BigDecimal numerator = x.pow(3).subtract(x).subtract(BigDecimal.valueOf(2));
        BigDecimal denominator = BigDecimal.valueOf(3).multiply(x.pow(2)).subtract(BigDecimal.ONE);
        return x.subtract(numerator.divide(denominator, MathContext.DECIMAL128));
    }

    public static void main(String[] args) {
        BigDecimal initialGuess = BigDecimal.valueOf(1.5);
        BigDecimal x = calculateNextX(initialGuess);

        System.out.printf("%-10s\n", "Value of x");
        System.out.printf("%-10s\n", "----------");

        int i = 0;
        while (true) {
            i++;
            x = calculateNextX(x);
            System.out.println("------"+ i);
            System.out.println(x);
        }
    }
}

