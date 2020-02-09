public class Vector4 {
  private double w, x, y, z;

  public Vector4() {
    this.w = 0;
    this.x = 0;
    this.y = 0;
    this.z = 0;
  }

  public Vector4(double x, double y, double z, double w) {
    this.x = x;
    this.y = y;
    this.z = z;
    this.w = w;
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

  public Vector4 rotateZW(double delta) {
    return new Vector4(
      getX(),
      getY(),
      Math.cos(delta) * getZ() - Math.sin(delta) * getZ(),
      Math.sin(delta) * getZ() + Math.cos(delta) * getZ()
    );
  }
}
