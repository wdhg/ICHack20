import java.util.ArrayList;
import java.util.List;

public class Pong extends Renderer {
  private Ball ball;
  private Paddle left;
  private Paddle right;

  private boolean won;

  public Pong(Ball ball, Paddle left, Paddle right) {
    this.ball = ball;
    this.left = left;
    this.right = right;

    won = false;
  }

  public void update() {
    checkBounds();
    checkEnd();

    if (!won) {
      ball.setPos(ball.getPos().add(ball.getVel()));

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

  public List<Integer> getConnections() {
    List<Integer> conns = new ArrayList<>();

    // ball conns.
    conns.add(0);
    conns.add(0);

    conns.add(1);
    conns.add(2);
    conns.add(2);
    conns.add(3);
    conns.add(3);
    conns.add(4);
    conns.add(4);
    conns.add(1);

    conns.add(5);
    conns.add(6);
    conns.add(6);
    conns.add(7);
    conns.add(7);
    conns.add(8);
    conns.add(8);
    conns.add(5);

    return conns;
  }

  public List<Vector2> getVertices() {
    List<Vector2> vertices = new ArrayList<>();

    double leftX = left.getTopLeft().getX();
    double leftY = left.getTopLeft().getY();
    double rightX = right.getTopLeft().getX();
    double rightY = right.getTopLeft().getY();

    vertices.add(ball.getPos());

    vertices.add(new Vector2(leftX, leftY));
    vertices.add(new Vector2(leftX + left.getWidth(), leftY));
    vertices.add(new Vector2(leftX + left.getWidth(), leftY + left.getHeight()));
    vertices.add(new Vector2(leftX, leftY + left.getHeight()));

    vertices.add(new Vector2(rightX, rightY));
    vertices.add(new Vector2(rightX + right.getWidth(), rightY));
    vertices.add(new Vector2(rightX + right.getWidth(), rightY + right.getHeight()));
    vertices.add(new Vector2(rightX, rightY + right.getHeight()));

    return vertices;
  }
}
