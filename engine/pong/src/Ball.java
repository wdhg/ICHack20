import java.awt.Rectangle;

public class Ball {

    private Vector2 position = new Vector2(0 ,0);
    private Vector2 direction = new Vector2(0 ,0);
    private Game game;
    private Rectangle ball;


    public Ball(Game game) {
        this.game = game;
        this.ball = new Rectangle(5, 5);
        position.setX(game.getHeight() / 2f);
        position.setY(game.getWidth() / 2f);
        direction.setX(1);
        direction.setY(0);
    }

    public void setXDirection(int xDirection) {
        direction.setX(xDirection);
    }

    public void setYDirection(int yDirection) {
        direction.setY(yDirection);
    }


}
