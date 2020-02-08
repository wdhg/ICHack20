package audio;

import shapes.Line;
import shapes.Point;

public class PlayerClient {
  private static int SAMPLE_RATE = 192000;

  public static void main(String[] args) {
    AudioRenderer player = new AudioRenderer(SAMPLE_RATE, 440);
    AudioRenderer.addShape(new Line(0, 0, 0.5, 0.5));
    AudioRenderer.addShape(new Line(0.5, 0.5, 0, 0));

    player.start();

    while (true) {

    }
  }
}
