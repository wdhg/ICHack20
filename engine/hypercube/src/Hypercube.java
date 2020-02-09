import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Hypercube {

  private List<Vector4> vertices;
  private List<Integer> edgeData;
  private Vector4 rotation;

  public Hypercube() {
    this.vertices = new ArrayList<>();
    this.rotation = new Vector4();
    this.vertices.add(new Vector4(-1,-1,-1,-1));
    this.vertices.add(new Vector4(-1,-1,-1,1));
    this.vertices.add(new Vector4(-1,-1,1,-1));
    this.vertices.add(new Vector4(-1,-1,1,1));
    this.vertices.add(new Vector4(-1,1,-1,-1));
    this.vertices.add(new Vector4(-1,1,-1,1));
    this.vertices.add(new Vector4(-1,1,1,-1));
    this.vertices.add(new Vector4(-1,1,1,1));
    this.vertices.add(new Vector4(1,-1,-1,-1));
    this.vertices.add(new Vector4(1,-1,-1,1));
    this.vertices.add(new Vector4(1,-1,1,-1));
    this.vertices.add(new Vector4(1,-1,1,1));
    this.vertices.add(new Vector4(1,1,-1,-1));
    this.vertices.add(new Vector4(1,1,-1,1));
    this.vertices.add(new Vector4(1,1,1,-1));
    this.vertices.add(new Vector4(1,1,1,1));
    this.edgeData = Arrays.asList(
      0,1,1,5,5,4,4,0,0,2,2,3,3,7,7,6,6,2,4,6,5,7,1,3,
      8,9,9,13,13,12,12,8,8,10,10,11,11,15,15,14,14,10,12,14,13,15,9,11,
      0,8,1,9,2,10,3,11,4,12,5,13,6,14,7,15
    );
  }

  public List<Vector4> getVertices() {
    return vertices;
  }

  public List<Integer> getEdgeData() {
    return edgeData;
  }

  public void rotateZW(double delta) {
    List<Vector4> vertices = new ArrayList<>();
    for(Vector4 vertex : this.getVertices()) {
      vertices.add(vertex.rotateZW(delta));
    }
  }
}
