package de.dhbw.nikolas.exercise;

public class RecursiveMath {

    public static void main(String[] args) {
        System.out.println(new RecursiveMath().div(10, 5));
        System.out.println(new RecursiveMath().isLess(10, 5));
        System.out.println(new RecursiveMath().isLess(5, 10));
        System.out.println(new RecursiveMath().isLess(5, 5));
        System.out.println(new RecursiveMath().isLess(0, 5));
        System.out.println(new RecursiveMath().isLess(5, 0));
        System.out.println("----");
        System.out.println(new RecursiveMath().isBigger(10, 5));
        System.out.println(new RecursiveMath().isBigger(5, 10));
        System.out.println(new RecursiveMath().isBigger(5, 5));
        System.out.println(new RecursiveMath().isBigger(0, 5));
        System.out.println(new RecursiveMath().isBigger(5, 0));
    }

    public int div(int x, int y) {
        if (y > x) return 0;
        if(y == 0) throw new RuntimeException();
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
        return isLess(x-1, y-1);
    }

    public boolean isBigger(int x, int y) {
        if (x == y) return false;
        if (y == 0 && x != 0) {
            return true;
        }
        if (x == 0) {
            return false;
        }
        return isBigger(x-1, y-1);
    }
}