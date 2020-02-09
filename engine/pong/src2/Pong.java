public class Pong {
  private Ball ball;
  private Paddle left;
  private Paddle right;

  private boolean won = false;

  public Pong(Ball ball, Paddle left, Paddle right) {
    this.ball = ball;
    this.left = left;
    this.right = right;
  }

  public void update() {
    checkBounds();
    checkEnd();

    if (!won) {
      ball.getPos().add(ball.getVel());

      checkCollision();
    }
  }

  private void checkCollision() {
    if (ball.getPos().getX() < left.getTopLeft().getX() + left.getWidth()
     && ball.getPos().getY() < left.getTopLeft().getY()
     && ball.getPos().getY() > left.getTopLeft().getY() - left.getHeight()) {
      ball.getVel().setX(-ball.getVel().getX());
    } else if (ball.getPos().getX() > right.getTopLeft().getX()
      && ball.getPos().getY() < right.getTopLeft().getY()
      && ball.getPos().getY() > right.getTopLeft().getY() - right.getHeight()) {
      ball.getVel().setX(-ball.getVel().getX());
    }
  }

  private void checkBounds() {
    if (ball.getPos().getY() > 1 || ball.getPos().getY() < - 1) {
      ball.getVel().setY(-ball.getVel().getY());
    }
  }

  private void checkEnd() {
    if (ball.getPos().getX() > 1 || ball.getPos().getX() < - 1) {
      won = true;
    }
  }
}
