import java.util.List;

public abstract class Shape {

  private List<Vector2> vertices;
  private List<Integer> edgeData;

  public Shape(List<Vector2> vertices, List<Integer> edgeData) {
    this.vertices = vertices;
    this.edgeData = edgeData;
  }
}
