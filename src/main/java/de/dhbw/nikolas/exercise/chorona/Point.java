package de.dhbw.nikolas.exercise.chorona;

public class Point {

    private int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
	public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + this.x;
      result = prime * result + this.y;
      return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
         return true;
      }
		if (obj == null) {
         return false;
      }
		if (this.getClass() != obj.getClass()) {
         return false;
      }
		Point other = (Point) obj;
		if (this.x != other.x) {
         return false;
      }
		if (this.y != other.y) {
         return false;
      }
		return true;
	}

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
