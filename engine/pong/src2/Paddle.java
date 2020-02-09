public class Paddle {
  private Vector2 topLeft;
  double width;
  double height;

  public Paddle(Vector2 topLeft, double width, double height) {
    this.topLeft = topLeft;
    this.width = width;
    this.height = height;
  }

  public Vector2 getTopLeft() {
    return topLeft;
  }

  public double getWidth() {
    return width;
  }

  public double getHeight() {
    return height;
  }

  public void setTopLeft(Vector2 topLeft) {
    this.topLeft = topLeft;
  }
}
