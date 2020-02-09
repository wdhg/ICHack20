public class Main {
  public static void main(String[] args) throws InterruptedException {
    Camera camera = new Camera();
    // Hypercube hypercube = new Hypercube();
    Cube cube = new Cube();
    while(true) {
      camera.draw(cube);
      cube.rotate(Math.PI / 1000);
      Thread.sleep(1000/60);
    }
  }
}
