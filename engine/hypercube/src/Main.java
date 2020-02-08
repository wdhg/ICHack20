public class Main {
  public static void main(String[] args) {
    Camera camera = new Camera();
    Hypercube hypercube = new Hypercube();
    while(true) {
      camera.draw(hypercube);
    }
  }
}
