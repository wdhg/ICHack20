public class Main {
  public static void main(String[] args) throws InterruptedException {
    Camera camera = new Camera();
    // Hypercube hypercube = new Hypercube();
    Cube cube = new Cube();
    while(true) {
      camera.draw(cube);
      cube.rotate(new Vector3(
        Math.PI / 1000,
        Math.PI / 1000,
        0
      ));
      Thread.sleep(1000/60);
    }
  }
}
