package shapes;

public class Point extends Shape {
  private final double x;
  private final double y;

  public Point(double x, double y, double weight) {
    this.x = x;
    this.y = y;
    this.weight = weight;
    this.length = 0;
  }

  public Point(double x, double y) {
    this(x, y, Shape.DEFAULT_WEIGHT);
  }

  public double getX() {
    return x;
  }

  public double getY() {
    return y;
  }

  public Point setX(double x) {
    return new Point(x, y);
  }

  public Point setY(double y) {
    return new Point(x, y);
  }

  @Override
  public double nextX(double drawingProgress) {
    return x;
  }

  @Override
  public double nextY(double drawingProgress) {
    return y;
  }
}
