import java.util.ArrayList;
import java.util.List;

public class Camera extends Renderer{

  // position at 0,0,0,0
  // rotation towards positive z axis

  private double focalLength;
  private double clipping = 0.001;
  private Vector3 position;
  private double fov;

  public Camera() {
    this.focalLength = 0.3;
    this.position = new Vector3(0,0,-1);
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
    Vector3 projected3D = new Vector3();
    return this.project(projected3D);
  }

  private Vector2 project(Vector3 vertex) {
    if(vertex.getZ() - this.position.getZ() < clipping) {
      return new Vector2(0, 0);
    }
    return new Vector2(
      vertex.getX() * focalLength / vertex.getZ() + this.position.getX(),
      vertex.getY() * focalLength / vertex.getZ() + this.position.getY()
    );
  }
}
