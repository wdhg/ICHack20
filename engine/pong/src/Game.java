public class Game {

    private int width, height, scorePlayer, scoreAI;
    private Ball ball;
    private Paddle player;

    public Game(int width, int height) {
        this.width = width;
        this.height = height;
        this.ball = new Ball(this);
        this.player = new Paddle(this);
        this.scorePlayer = 0;
        this.scoreAI = 0;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}
