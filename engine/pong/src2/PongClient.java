import java.util.Random;
import java.util.Scanner;

public class PongClient {
  public static void main(String[] args) throws InterruptedException {
    Random rng = new Random();

    Ball ball = new Ball(new Vector2(0, 0), new Vector2(rng.nextDouble() / 10, rng.nextDouble() / 10));
    Paddle left = new Paddle(new Vector2(-1, 0.5), 0.1, 0.4);
    Paddle right = new Paddle(new Vector2(0.9, 0.5), 0.1, 0.4);

    Pong pong = new Pong(ball, left, right);

    Scanner keyboard = new Scanner(System.in);
    System.out.println("Enter command (quit to exit):");

    while (true) {
      Thread.sleep(1000 / 30);
      pong.update();
      pong.render(pong.getVertices(), pong.getConnections());

      String input = keyboard.next();
      if(input != null) {
        switch (input) {
          case "w":
            left.move(0.1);
            break;
          case "s":
            left.move(-0.1);
            break;
          case "i":
            right.move(0.1);
            break;
          case "k":
            right.move(-0.1);
            break;
        }

      }
    }
  }
}
