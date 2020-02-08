import java.util.ArrayList;
import java.util.List;

public class World2D {

  List<GameObject2D> gameObjects;

  public World2D() {
    this.gameObjects = new ArrayList<>();
  }

  public void addGameObject(GameObject2D gameObject) {
    this.gameObjects.add(gameObject);
  }

  public List<GameObject2D> getGameObjects() {
    return this.gameObjects;
  }
}
