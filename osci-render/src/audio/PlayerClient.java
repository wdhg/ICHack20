package audio;

import shapes.Line;
import shapes.Shape;
import shapes.Square;

import java.util.ArrayList;
import java.util.List;

public class PlayerClient {
  private static int SAMPLE_RATE = 192000;

  public static void main(String[] args) {
    AudioRenderer player = new AudioRenderer(SAMPLE_RATE, 440);

    AudioRenderer.addShape(new Square(5, 103, 33));
    AudioRenderer.addShape(new Square(38, 70, 33));
    AudioRenderer.addShape(new Square(5, 38, 33));
    AudioRenderer.addShape(new Square(70, 38, 33));
    AudioRenderer.addShape(new Square(70, 103, 33));
    AudioRenderer.scale(1d / 103d);


    player.start();

    while (true) {

    }
  }
}
