package shapes;

public abstract class Shape {
  protected double weight;
  protected double length;

  public double getWeight() {
    return weight;
  }

  public double getLength() {
    return length;
  }

  public abstract double nextX(double drawingProgress);
  public abstract double nextY(double drawingProgress);
}
