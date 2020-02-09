package audio;

import pipe.Pipe;
import shapes.Circle;
import shapes.Shape;
import shapes.Shapes;

import java.io.IOException;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

public class PlayerClient {
  private static int SAMPLE_RATE = 192000;

  public static void main(String[] args) throws IOException {
    AudioRenderer player = new AudioRenderer(SAMPLE_RATE, 440);
    Pipe pipe = new Pipe();

//    List<Shape> squares = new ArrayList<>();
//
//    squares.addAll(Shapes.generateSquare(0.0485, 1.0085, 0.32));
//    squares.addAll(Shapes.generateSquare(0.3685, 0.6885, 0.32));
//    squares.addAll(Shapes.generateSquare(0.0485, 0.3685, 0.32));
//    squares.addAll(Shapes.generateSquare(0.6885, 0.369, 0.32));
//    squares.addAll(Shapes.generateSquare(0.6885, 1.0085, 0.32));
//
//    AudioRenderer.addShapes(Shapes.sortLines(squares));
//
//    AudioRenderer.addShape(new Circle(-0.5, 0.5, 0.262));
//    AudioRenderer.addShape(new Circle(-0.5, 0.5, 0.476));
//    AudioRenderer.addShape(new Circle(-0.762, -0.286, 0.238));
//    AudioRenderer.addShape(new Circle(-0.762, -0.762, 0.238));
//    AudioRenderer.addShape(new Circle(-0.286, -0.286, 0.238));
//    AudioRenderer.addShape(new Circle(-0.286, -0.762, 0.238));
//
//    AudioRenderer.addShapes(Shapes.generateSquare(0.0485, -0.0485, 0.631));
//    AudioRenderer.addShapes(Shapes.generateSquare(0.369, -0.369, 0.631));

    player.start();

    while (true) {
      List<Shape> frame = pipe.getFrame();

      AudioRenderer.updateFrame(Shapes.sortLines(frame));
    }
  }
}
