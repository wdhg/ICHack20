public class GameObject2D {
  private Vector2 position;
  private double rotation;
  private Shape shape;

  public GameObject2D(Vector2 position, double rotation, Shape shape) {
    this.position = position;
    this.rotation = rotation;
    this.shape = shape;
  }

  public void setPosition(Vector2 position) {
    this.position = position;
  }

  public Vector2 getPosition() {
    return this.position;
  }

  public void setRotation(double rotation) {
    this.rotation = rotation;
  }

  public double getRotation() {
    return this.rotation;
  }

  public void move(Vector2 delta) {

  }

  // in degrees clockwise (negative for anticlockwise
  public void rotate(double degrees) {

  }

  public boolean collidesWith(GameObject2D other) {
    return false;
  }
}
