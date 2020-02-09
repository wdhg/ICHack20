import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cube {

  private Vector3 position;
  private List<Vector3> vertices;
  private List<Integer> edgeData;
  private double rotation;

  public Cube() {
    this.position = new Vector3(0,0,2);
    this.vertices = Arrays.asList(
      new Vector3(0,0,0),
      new Vector3(0,0,1),
      new Vector3(0,1,0),
      new Vector3(0,1,1),
      new Vector3(1,0,0),
      new Vector3(1,0,1),
      new Vector3(1,1,0),
      new Vector3(1,1,1)
    );
    this.edgeData = Arrays.asList(0,1,1,3,3,2,2,0,0,4,4,5,5,7,7,6,6,4,2,6,3,7,1,5);
  }

  // delta is in radians
  public void rotate(double delta) {
    this.rotation += delta;
    this.rotation %= 2 * Math.PI;
  }

  public List<Vector3> getVertices() {
    List<Vector3> vertices = new ArrayList<>();
    for(Vector3 vertex : this.vertices) {
      vertices.add(new Vector3(
        Math.cos(rotation) * vertex.getX() - Math.sin(rotation) * vertex.getY(),
        Math.sin(rotation) * vertex.getX() + Math.cos(rotation) * vertex.getY(),
        vertex.getZ()
      ));
    }
    return vertices;
  }

  public List<Integer> getEdgeData() {
    return edgeData;
  }
}
