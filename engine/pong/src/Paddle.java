import java.awt.Graphics;
import java.awt.Rectangle;

public class Paddle {
    public static final int WIDTH = 10, HEIGHT = 60;
    private Main game;
    private int up, down;
    private int x;
    private int y, ya;
    private Rectangle paddle;
    private Vector2 position;

    public Paddle(Main game, int up, int down, int x) {
        this.game = game;
        this.x = x;
        y = game.getHeight() / 2;
        this.up = up;
        this.down = down;
        paddle = new Rectangle(x, y, WIDTH, HEIGHT);
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

    public Rectangle getBounds() {
        return new Rectangle(x, y, WIDTH, HEIGHT);
    }

    public void paint(Graphics g) {
        g.fillRect(x, y, WIDTH, HEIGHT);
    }

    public Vector2 getPosition() {
        return position;
    }
}