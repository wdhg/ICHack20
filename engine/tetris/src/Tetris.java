import java.awt.EventQueue;
import java.util.ArrayList;

public class Tetris {

  public ArrayList<Vector2> vertices;
  public ArrayList<Integer> edges;

  public Tetris() {
    initUI();
    this.vertices = new ArrayList<>();
    this.edges = new ArrayList<>();
  }

  private void initUI() {
    Board board = new Board();
    board.start();
  }

  public static void main(String[] args) {
    EventQueue.invokeLater(() -> {
      Tetris game = new Tetris();
    });
  }
}