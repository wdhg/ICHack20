import java.util.ArrayList;
import java.util.List;

public abstract class Shape {

  private List<Vector2> vertices;
  private List<Integer> edgeData;

  public Shape() {
    this.vertices = new ArrayList<>();
    this.edgeData = new ArrayList<>();
  }

  public Shape(List<Vector2> vertices, List<Integer> edgeData) {
    this.vertices = vertices;
    this.edgeData = edgeData;
  }

  public void setVertices(List<Vector2> vertices) {
    this.vertices = vertices;
  }

  public void setEdgeData(List<Integer> edgeData) {
    this.edgeData = edgeData;
  }
}
