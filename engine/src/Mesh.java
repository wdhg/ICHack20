import java.util.ArrayList;

public class Mesh {

  private ArrayList<Vector3> verticies;
  private ArrayList<Integer> edgeData;

  public Mesh() {
    this.verticies = new ArrayList<>();
    this.edgeData = new ArrayList<>();
  }

  public Mesh(ArrayList<Vector3> verticies, ArrayList<Integer> edgeData) {
    this.verticies = verticies;
    this.edgeData = edgeData;
  }
}
