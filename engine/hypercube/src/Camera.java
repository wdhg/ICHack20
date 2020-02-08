import java.util.ArrayList;
import java.util.List;

public class Camera extends Renderer{

  // position at 0,0,0,0

  private double d;
  private double fov;

  public Camera() {
    this.d = 1;
    this.fov = 60;
  }

  public void draw(Hypercube hypercube) {
    List<Vector2> vertices = new ArrayList<>();
    for(Vector4 vertex : hypercube.getVertices()) {
      vertices.add(this.project(vertex));
    }
    this.render(
      vertices,
      hypercube.getEdgeData()
    );
  }

  private Vector2 project(Vector4 vertex) {
    Vector3 projected3D = new Vector3(
      vertex.getX() * d / vertex.getW(),
      vertex.getY() * d / vertex.getW(),
      vertex.getZ() * d / vertex.getW()
    );
    return new Vector2(
      projected3D.getX() * d / projected3D.getZ(),
      projected3D.getY() * d / projected3D.getZ()
    );
  }
}
