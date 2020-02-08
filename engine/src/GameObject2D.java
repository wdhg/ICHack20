public class GameObject2D {

  private static final double MAX_ROTATION = 360;

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

  public Shape getShape() {
    return this.shape;
  }

  public void move(Vector2 delta) {
    this.setPosition(this.getPosition().add(delta));
  }

  // in degrees clockwise (negative for anticlockwise
  public void rotate(double degrees) {
    this.setRotation((this.getRotation() + degrees) % MAX_ROTATION);
  }

  public boolean collidesWith(GameObject2D other) {
    return this.getShape().intersects(other.getShape());
  }
}
