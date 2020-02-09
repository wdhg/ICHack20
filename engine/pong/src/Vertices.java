import java.util.ArrayList;

public class Vertices {

    private Game game;

    ArrayList<Vector2> vertices = new ArrayList<>();
    ArrayList<Integer> edge = new ArrayList<>();
    int[] edges = {0, 1, 1, 2, 2, 3, 3, 0, 4, 5, 5, 6, 6, 7, 7, 4, 8, 9, 9, 10, 10, 11, 11, 8};

    public Vertices(Game game) {
        this.game = game;
        addVertices();
    }


    public void addVertices() {
        // Add ball vertices
        vertices.add(game.getBallPosition());
        vertices.add(game.getBallPosition().add(Ball.WIDTH, 0));
        vertices.add(game.getBallPosition().add(Ball.WIDTH, Ball.HEIGHT));
        vertices.add(game.getBallPosition().add(0, Ball.HEIGHT));



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

        for (int e : edges) {
            edge.add(e);
        }

    }
}
