import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Ball {
    public static final double WIDTH = 0.05, HEIGHT = 0.05;
    private Game game;
    private double x, y, xa = 2, ya = 2;
    private Vector2 position;
    private Rectangle2D.Double ball;

    public Ball(Game game) {
        x = 0.0;
        y = 0.0;
        position = new Vector2(x, y);
        ball = new Rectangle2D.Double(x, y, WIDTH, HEIGHT);
        this.game = game;
    }

    public void update() {
        x += xa;
        y += ya;

        position.setX(x);
        position.setY(y);

        ball = new Rectangle2D.Double(x, y, WIDTH, HEIGHT);

        if (x < 0) {
            game.increaseScore(1);
            x = game.getWidth() / 2f;
            xa = -xa;
        }
        else if (x > game.getWidth() - WIDTH - 7) {
            game.increaseScore(2);
            x = game.getWidth() / 2f;
            xa = -xa;
        }
        else if (y < 0 || y > game.getHeight() - HEIGHT - 29)
            ya = -ya;
   /*     if (game.getScore(1) == 10)
            JOptionPane.showMessageDialog(null, "Player 1 wins", "Pong", JOptionPane.PLAIN_MESSAGE);
        else if (game.getScore(2) == 10)
            JOptionPane.showMessageDialog(null, "Player 2 wins", "Pong", JOptionPane.PLAIN_MESSAGE);*/
        checkCollision();

    }

    public void checkCollision() {
        if (game.getPlayer(1).getBounds().intersects(getBounds()) || game.getPlayer(2).getBounds().intersects(getBounds()))
            xa = -xa;
    }

    public Rectangle2D.Double getBounds() {
        position.setX(x);
        position.setY(y);
        return new Rectangle2D.Double(x, y, WIDTH, HEIGHT);
    }

    public Vector2 getPosition() {
        return position;
    }

    public Vector2 addVector(int x, int y) {
        return new Vector2(position.getX() + x, position.getY() + y);
    }

}