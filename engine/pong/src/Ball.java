import java.awt.*;

import javax.swing.JOptionPane;

public class Ball {
    public static final int WIDTH = 30, HEIGHT = 30;
    private Main game;
    private int x, y, xa = 2, ya = 2;
    private Vector2 position;
    private Rectangle ball;

    public Ball(Main game) {
        x = game.getWidth() / 2;
        y = game.getHeight() / 2;
        position = new Vector2(x, y);
        ball = new Rectangle(x, y, WIDTH, HEIGHT);
        this.game = game;
    }

    public void update() {
        x += xa;
        y += ya;

        position.setX(x);
        position.setY(y);

        ball.x = x;
        ball.y = y;

        if (x < 0) {
            game.getPanel().increaseScore(1);
            x = game.getWidth() / 2;
            xa = -xa;
        }
        else if (x > game.getWidth() - WIDTH - 7) {
            game.getPanel().increaseScore(2);
            x = game.getWidth() / 2;
            xa = -xa;
        }
        else if (y < 0 || y > game.getHeight() - HEIGHT - 29)
            ya = -ya;
        if (game.getPanel().getScore(1) == 10)
            JOptionPane.showMessageDialog(null, "Player 1 wins", "Pong", JOptionPane.PLAIN_MESSAGE);
        else if (game.getPanel().getScore(2) == 10)
            JOptionPane.showMessageDialog(null, "Player 2 wins", "Pong", JOptionPane.PLAIN_MESSAGE);
        checkCollision();

    }

    public void checkCollision() {
        if (game.getPanel().getPlayer(1).getBounds().intersects(getBounds()) || game.getPanel().getPlayer(2).getBounds().intersects(getBounds()))
            xa = -xa;
    }

    public Rectangle getBounds() {
        position.setX(x);
        position.setY(y);
        ball.x = x;
        ball.y = y;
        return new Rectangle(x, y, WIDTH, HEIGHT);
    }

    public void paint(Graphics g) {
        g.fillRect(x, y, WIDTH, HEIGHT);
    }

    public Vector2 getPosition() {
        return position;
    }

    public Vector2 addVector(int x, int y) {
        return new Vector2(position.getX() + x, position.getY() + y);
    }

}