import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JFrame;

public class Main extends JFrame {
    private final static int WIDTH = 500, HEIGHT = 450;
    private Game game;

    public Main() {
        setSize(WIDTH, HEIGHT);
        setTitle("Pong");
        setBackground(Color.WHITE);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        game = new Game(this);
        add(game);
    }

    ArrayList<Vector2> vertices = new ArrayList<>();
    int[] edges = {0, 1, 1, 2, 2, 3, 4, 5, 5, 6, 6, 7, 8, 9, 9, 10, 10, 11, 11, 12};

    public void addVertices() {
        // Add ball vertices
        vertices.add(game.getBallPosition());
        vertices.add(game.getBallPosition().add(0, Ball.HEIGHT));
        vertices.add(game.getBallPosition().add(Ball.WIDTH, Ball.HEIGHT));
        vertices.add(game.getBallPosition().add(Ball.WIDTH, 0));

        // Add paddle 1 vertices
        vertices.add(game.getPlayer1Position());
        vertices.add(game.getPlayer1Position().add(0, Paddle.HEIGHT));
        vertices.add(game.getPlayer1Position().add(Paddle.WIDTH, Paddle.HEIGHT));
        vertices.add(game.getPlayer1Position().add(Paddle.WIDTH, 0));

        // Add paddle 2 vertices
        vertices.add(game.getPlayer2Position());
        vertices.add(game.getPlayer2Position().add(0, Paddle.HEIGHT));
        vertices.add(game.getPlayer2Position().add(Paddle.WIDTH, Paddle.HEIGHT));
        vertices.add(game.getPlayer2Position().add(Paddle.WIDTH, 0));
    }



    public Game getPanel() {
        return game;
    }

    public static void main(String[] args) {
        new Main();
    }
}