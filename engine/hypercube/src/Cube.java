import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cube {

  private Vector3 position;
  private List<Vector3> vertices;
  private List<Integer> edgeData;
  private Vector3 rotation;

  public Cube() {
    this.position = new Vector3(0,0,2);
    this.rotation = new Vector3();
    /*
    this.vertices = Arrays.asList(
      new Vector3(-1,-1,-1),
      new Vector3(-1,-1,1),
      new Vector3(-1,1,-1),
      new Vector3(-1,1,1),
      new Vector3(1,-1,-1),
      new Vector3(1,-1,1),
      new Vector3(1,1,-1),
      new Vector3(1,1,1)
    );
    this.edgeData = Arrays.asList(0,1,1,3,3,2,2,0,0,4,4,5,5,7,7,6,6,4,2,6,3,7,1,5);
     */
    Mesh mesh = Mesh.loadFromFile("resources/Cube.obj");
    this.vertices = mesh.getVertices();
    this.edgeData = mesh.getEdgeData();
  }

  // delta is in radians
  public void rotate(Vector3 delta) {
    this.rotation = this.rotation.add(delta);
  }

  public List<Vector3> getVertices() {
    List<Vector3> vertices = new ArrayList<>();
    for(Vector3 vertex : this.vertices) {
      vertices.add(
        vertex
          .rotateX(this.rotation.getX())
          .rotateY(this.rotation.getY())
          .rotateZ(this.rotation.getY())
          .add(this.position));
    }
    return vertices;
  }

  public List<Integer> getEdgeData() {
    return edgeData;
  }
}
