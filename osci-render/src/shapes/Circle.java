package shapes;

public class Circle extends Shape {
  private final double radius;
  private final Point point;

  public Circle(double radius, Point point) {
    this.radius = radius;
    this.point = point;
  }

  @Override
  public Circle scale(double factor) {
    return new Circle(radius * factor, point.scale(factor));
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
