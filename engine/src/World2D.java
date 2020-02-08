import java.util.ArrayList;
import java.util.List;

public class World2D {

  Camera camera;
  List<GameObject2D> gameObjects;

  public World2D() {
    this.camera = new Camera(new Vector3(0, 0, 0));
    this.gameObjects = new ArrayList<>();
  }
}
