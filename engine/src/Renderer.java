import java.util.List;

public abstract class Renderer {

  private Pipe pipe;

  public Renderer() {
    try {
      this.pipe = new Pipe();
    } catch (Exception e) {
      System.err.println("Pipe cannot connect");
    }
  }

  public void render(List<Vector2> vertices, List<Integer> connections) {
    this.pipe.send(vertices, connections);
  }
}
