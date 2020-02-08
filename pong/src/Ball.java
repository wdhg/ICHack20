public class Ball {

    private int x, y;
    private Game game;

    public Ball(Game game) {
        this.game = game;
        this.x = game.getHeight() / 2;
        this.y = game.getWidth() / 2;
    }
}
