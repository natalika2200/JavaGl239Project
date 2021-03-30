package problem;

public class Vector {
    double x;
    double y;

    public Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vector minus(Vector a) {
        return new Vector(this.x - a.x, this.y - a.y);
    }

    public Vector norm() {
        double length = (double) Math.sqrt(Math.pow((x), 2) + Math.pow((y), 2));
        return new Vector(this.x / length, this.y / length);
    }

    public Vector plus(Vector a) {
        return new Vector(this.x + a.x, this.y + a.y);
    }

    public Vector mult(int i) {
        return new Vector(this.x * i, this.y * i);
    }

    @Override
    public String toString() {
        return String.format("[%.3f, %.3f]", x, y);
    }
}
