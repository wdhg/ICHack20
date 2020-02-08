package shapes;

public class Circle extends Shape {
  private final double radius;
  private final Point point;

  public Circle(Point point, double radius) {
    this.point = point;
    this.radius = radius;

    length = 2 * Math.PI * radius;
  }

  public Circle(double x, double y, double radius) {
    this(new Point(x, y), radius);
  }

  @Override
  public Circle scale(double factor) {
    return new Circle(point.scale(factor), radius * factor);
  }

  @Override
  public double nextX(double drawingProgress) {
    return point.getX() + radius * Math.sin(2 * Math.PI * drawingProgress);
  }

  @Override
  public double nextY(double drawingProgress) {
    return point.getY() + radius * Math.cos(2 * Math.PI * drawingProgress);
  }
}
