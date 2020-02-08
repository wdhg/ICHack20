package audio;

import shapes.Circle;
import shapes.Line;
import shapes.Shapes;

public class PlayerClient {
  private static int SAMPLE_RATE = 192000;

  public static void main(String[] args) {
    AudioRenderer player = new AudioRenderer(SAMPLE_RATE, 440);

    AudioRenderer.addShapes(Shapes.generateSquare(0.0485, 1, 0.32));
    AudioRenderer.addShapes(Shapes.generateSquare(0.369, 0.68, 0.32));
    AudioRenderer.addShapes(Shapes.generateSquare(0.0485, 0.369, 0.32));
    AudioRenderer.addShapes(Shapes.generateSquare(0.68, 0.369, 0.32));
    AudioRenderer.addShapes(Shapes.generateSquare(0.68, 1, 0.32));
    AudioRenderer.addShape(new Circle(-0.5, 0.5, 0.262));
    AudioRenderer.addShape(new Circle(-0.5, 0.5, 0.476));
    AudioRenderer.addShape(new Circle(-0.762, -0.286, 0.238));
    AudioRenderer.addShape(new Circle(-0.762, -0.762, 0.238));
    AudioRenderer.addShape(new Circle(-0.286, -0.286, 0.238));
    AudioRenderer.addShape(new Circle(-0.286, -0.762, 0.238));
    AudioRenderer.addShapes(Shapes.generateSquare(0.0485, -0.0485, 0.631));
    AudioRenderer.addShapes(Shapes.generateSquare(0.369, -0.369, 0.631));

    player.start();

    while (true) {

    }
  }
}
