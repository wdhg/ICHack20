public class Paddle {
    private int x, y;
    private Game game;

     public Paddle(Game game) {
         this.x = game.getWidth() - 10;
         this.y = game.getHeight() / 2;
     }

}
