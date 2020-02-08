import java.util.ArrayList;
import java.util.List;

public class World2D {

  Camera camera;
  List<GameObject2D> gameObjects;

  public World2D() {
    this.camera = new Camera(new Vector3(0, 0, 0));
    this.gameObjects = new ArrayList<>();
  }

  public void addGameObject(GameObject2D gameObject) {
    this.gameObjects.add(gameObject);
  }

  public Camera getCamera() {
    return this.camera;
  }

  public List<GameObject2D> getGameObjects() {
    return this.gameObjects;
  }
}
