package shapes;

import java.util.List;
import java.util.stream.Collectors;

public class Line extends Shape {
  private final Point a;
  private final Point b;

  public Line(Point a, Point b, double weight) {
    this.a = a;
    this.b = b;
    this.weight = weight;
    this.length = Point.dist(a, b);
  }

  public Line(Point a, Point b) {
    this(a, b, Shape.DEFAULT_WEIGHT);
  }

  public Line(double x1, double y1, double x2, double y2, double weight) {
    this(new Point(x1, y1), new Point(x2, y2), weight);
  }

  public Line(double x1, double y1, double x2, double y2) {
    this(x1, y1, x2, y2, Shape.DEFAULT_WEIGHT);
  }

  @Override
  public double nextX(double drawingProgress) {
    return (float) (getX1() + (getX2() - getX1()) * drawingProgress);
  }

  @Override
  public double nextY(double drawingProgress) {
    return (float) (getY1() + (getY2() - getY1()) * drawingProgress);
  }

  @Override
  public Line scale(double factor) {
    return new Line(a.scale(factor), b.scale(factor), weight);
  }

  public static List<Line> scaleAll(List<Line> lines, double factor) {
    return lines.stream().map(l -> l.scale(factor)).collect(Collectors.toList());
  }

  public Point getA() {
    return a;
  }

  public Point getB() {
    return b;
  }

  private double getX1() {
    return a.getX();
  }

  private double getY1() {
    return a.getY();
  }

  private double getX2() {
    return b.getX();
  }

  private double getY2() {
    return b.getY();
  }
}
