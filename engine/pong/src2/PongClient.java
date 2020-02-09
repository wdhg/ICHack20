import java.util.Random;

public class PongClient {
  public static void main(String[] args) {
    Random rng = new Random();

    Ball ball = new Ball(new Vector2(0, 0), new Vector2(rng.nextDouble(), rng.nextDouble()));
  }
}
