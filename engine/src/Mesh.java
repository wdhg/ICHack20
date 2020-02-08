import java.util.ArrayList;

public class Mesh {

  private ArrayList<Vector3> vertices;
  private ArrayList<Integer> edgeData;

  public Mesh() {
    this.vertices = new ArrayList<>();
    this.edgeData = new ArrayList<>();
  }

  public Mesh(ArrayList<Vector3> vertices, ArrayList<Integer> edgeData) {
    this.vertices = vertices;
    this.edgeData = edgeData;
  }
}
