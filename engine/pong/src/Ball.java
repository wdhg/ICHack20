import java.awt.Rectangle;

public class Ball {

    private Vector2 position;
    private Vector2 direction;
    private Game game;
    private Rectangle ball;


    public Ball(Game game) {
        this.game = game;
        this.ball = new Rectangle(5, 5);
        this.position.setX(game.getHeight() / 2);
        this.position.setX(game.getWidth() / 2);
        this.direction.setX(1);
        this.direction.setY(0);
    }

    public void move() {
        
    }


}
