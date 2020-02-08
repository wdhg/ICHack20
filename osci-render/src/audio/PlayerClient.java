package audio;

import shapes.Circle;
import shapes.Line;
import shapes.Shape;
import shapes.Shapes;

import java.util.ArrayList;
import java.util.List;

public class PlayerClient {
  private static int SAMPLE_RATE = 192000;

  public static void main(String[] args) {
    AudioRenderer player = new AudioRenderer(SAMPLE_RATE, 440);

    List<Shape> squares = new ArrayList<>();

    squares.addAll(Shapes.generateSquare(0.0485, 1.0085, 0.32));
    squares.addAll(Shapes.generateSquare(0.3685, 0.6885, 0.32));
    squares.addAll(Shapes.generateSquare(0.0485, 0.3685, 0.32));
    squares.addAll(Shapes.generateSquare(0.6885, 0.369, 0.32));
    squares.addAll(Shapes.generateSquare(0.6885, 1.0085, 0.32));

    AudioRenderer.addShapes(Shapes.sortLines(squares));

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
