import java.awt.Graphics;
import java.awt.geom.Rectangle2D;

public class Paddle {
    public static final double WIDTH = 0.1, HEIGHT = 0.6;
    private Game game;
    private int up, down;
    private double x;
    private double y, ya;
    private Rectangle2D.Double paddle;
    private Vector2 position;

    public Paddle(Game game, int up, int down, double x) {
        this.game = game;
        this.x = x;
        y = 0.5 / 2f;
        this.up = up;
        this.down = down;
        paddle = new Rectangle2D.Double(x, y, WIDTH, HEIGHT);
        position = new Vector2(x, y);
    }

    public void update() {
        if (y > 0 && y < game.getHeight() - HEIGHT - 29)
            y += ya;
        else if (y == 0)
            y++;
        else if (y == game.getHeight() - HEIGHT - 29)
            y--;

        position.setY(y);
        paddle.y = y;
    }

    public void pressed(int keyCode) {
        if (keyCode == up)
            ya = -1;
        else if (keyCode == down)
            ya = 1;
    }

    public void released(int keyCode) {
        if (keyCode == up || keyCode == down)
            ya = 0;
    }

    public Rectangle2D.Double getBounds() {
        return new Rectangle2D.Double(x, y, WIDTH, HEIGHT);
    }

    public Vector2 getPosition() {
        return position;
    }
}