package engine;

public class Point {
    private double x;
    private double y;
    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }

    public boolean isAbove(Point other){
        return y > other.getY();
    }

    public boolean isBelow(Point other){
        return y < other.getY();
    }

    public boolean isRightOf(Point other){
        return x > other.getX();
    }

    public boolean isLeftOf(Point other){
        return x < other.getX();
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
