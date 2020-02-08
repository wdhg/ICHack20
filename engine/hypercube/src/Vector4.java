public class Vector4 {
  private double w, x, y, z;

  public Vector4() {
    this.w = 0;
    this.x = 0;
    this.y = 0;
    this.z = 0;
  }

  public Vector4(double w, double x, double y, double z) {
    this.w = w;
    this.x = x;
    this.y = y;
    this.z = z;
  }

  public double getW() {
    return w;
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
