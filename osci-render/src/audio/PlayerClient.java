package audio;

import shapes.Shapes;

public class PlayerClient {
  private static int SAMPLE_RATE = 192000;

  public static void main(String[] args) {
    AudioRenderer player = new AudioRenderer(SAMPLE_RATE, 440);

    AudioRenderer.addShapes(Shapes.generateSquare(5, 103, 33));
    AudioRenderer.addShapes(Shapes.generateSquare(38, 70, 33));
    AudioRenderer.addShapes(Shapes.generateSquare(5, 38, 33));
    AudioRenderer.addShapes(Shapes.generateSquare(70, 38, 33));
    AudioRenderer.addShapes(Shapes.generateSquare(70, 103, 33));
    AudioRenderer.scale(1d / 103d);


    player.start();

    while (true) {

    }
  }
}
