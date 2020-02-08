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
}
