public class Vector2 {

  private double x;
  private double y;

  public Vector2(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public double getX() {
    return x;
  }

  public double getY() {
    return y;
  }

  public void setX(double x) {
    this.x = x;
  }

  public void setY(double y) {
    this.y = y;
  }

  public void add(Vector2 other) {
    this.setX(this.getX() + other.getX());
    this.setY(this.getY() + other.getY());
  }
}
