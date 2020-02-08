import javafx.scene.input.KeyCode;

import java.awt.*;

public class Paddle {
    private int x, y;
    private int up, down;
    private Game game;
    private Rectangle paddle;

     public Paddle(Game game, int up, int down) {
         this.up = up;
         this.down = down;
         this.game = game;
         this.x = game.getWidth() - 10;
         this.y = game.getHeight() / 2;
         paddle = new Rectangle(1, 10);
     }

     public void pressed(int keyCode) {
        if (keyCode == up) {

        }
     }


}
