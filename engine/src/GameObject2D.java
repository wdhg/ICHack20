public class GameObject2D {
  private Vector2 position;
  private double rotation;
  private Shape shape;

  public GameObject2D(Vector2 position, double rotation, Shape shape) {
    this.position = position;
    this.rotation = rotation;
    this.shape = shape;
  }

  public void move(Vector2 delta) {

  }

  public void rotate(double delta) {

  }

  public boolean collidesWith(GameObject2D other) {
    return false;
  }
}
