package shapes;

public abstract class Shape {
  public static int DEFAULT_WEIGHT = 100;

  protected double weight = DEFAULT_WEIGHT;
  protected double length;

  public double getWeight() {
    return weight;
  }

  public double getLength() {
    return length;
  }

  public abstract Shape scale(double factor);
  public abstract double nextX(double drawingProgress);
  public abstract double nextY(double drawingProgress);
}
