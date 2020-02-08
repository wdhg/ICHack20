public class Line3 {

  private final Vector3 firstPoint;
  private final Vector3 secondPoint;

  public Line3(Vector3 firstPoint, Vector3 secondPoint) {
    this.firstPoint = firstPoint;
    this.secondPoint = secondPoint;
  }

  public Vector3 getFirst(){
    return this.firstPoint;
  }

  public Vector3 getSecond(){
    return this.secondPoint;
  }
}
