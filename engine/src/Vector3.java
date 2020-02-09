import java.util.List;

public class Vector3 {
  private double x, y, z;

  public Vector3() {
    this.x = 0;
    this.y = 0;
    this.z = 0;
  }

  public Vector3(double x, double y, double z) {
    this.x = x;
    this.y = y;
    this.z = z;
  }

  public double getX() {
    return x;
  }

  public double getY() {
    return y;
  }

  public double getZ() {
    return z;
  }

  public Vector3 add(Vector3 other) {
    return new Vector3(
      this.getX() + other.getX(),
      this.getY() + other.getY(),
      this.getZ() + other.getZ()
    );
  }

  public Vector3 scale(double scalar) {
    return new Vector3(
      this.getX() * scalar,
      this.getY() * scalar,
      this.getZ() * scalar
    );
  }

  public static Vector3 meanPoint(List<Vector3> points) {
    Vector3 mean = new Vector3();
    for(Vector3 point : points) {
      mean = mean.add(point);
    }
    return mean.scale(1 / (points.size()));
  }
}
