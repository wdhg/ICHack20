import java.util.ArrayList;

public class Tetris {

  public ArrayList<Vector2> vertices;
  public ArrayList<Integer> edges;
  public boolean gameOver;

  public Tetris() throws InterruptedException {
    initUI();
    this.vertices = new ArrayList<>();
    this.edges = new ArrayList<>();
    this.gameOver = false;
  }

  private void initUI() throws InterruptedException {
    Board board = new Board();
    board.start();
  }

  public static void main(String[] args) throws InterruptedException {
    Tetris game = new Tetris();
  }
}