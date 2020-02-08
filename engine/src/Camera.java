public class Camera {

  private double d;
  private Vector3 position;
  private Vector3 rotation;
  private double fov;

  public Camera(Vector3 position) {
    position = position;
    this.d = 1;
  }

  public Vector2 projectPoint(Vector3 point){
    double newX = point.getX() * d/point.getZ();
    double newY = point.getY() * d/point.getZ();
    return new Vector2(newX, newY);
  }
}
