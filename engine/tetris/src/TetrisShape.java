import java.util.Random;

public class TetrisShape {

  private Tetrominoe shape;
  public int[] xs;
  public int[] ys;

  public TetrisShape() {
    this.shape = setRandomShape();
    initialiseShape();
  }

  private void initialiseShape() {
    switch (shape) {
      case ZShape:
        xs = new int[]{4, 4, 5, 5};
        ys = new int[]{0, 1, 1, 2};
        break;
      case SShape:
        xs = new int[]{5, 5, 4, 4};
        ys = new int[]{0, 1, 1, 2};
        break;
      case LineShape:
        xs = new int[]{5, 5, 5, 5};
        ys = new int[]{0, 1, 2, 3};
        break;
      case TShape:
        xs = new int[]{4, 4, 4, 5};
        ys = new int[]{0, 1, 1, 2};
        break;
      case SquareShape:
        xs = new int[]{4, 5, 4, 5};
        ys = new int[]{0, 0, 1, 1};
        break;
      case LShape:
        xs = new int[]{4, 4, 4, 5};
        ys = new int[]{0, 1, 2, 2};
        break;
      case MirroredLShape:
        xs = new int[]{4, 5, 5, 5};
        ys = new int[]{0, 1, 2, 2};
        break;
    }
  }

  public Tetrominoe getShape() {
    return shape;
  }

  private Tetrominoe setRandomShape() {

    var r = new Random();
    int x = Math.abs(r.nextInt()) % 7 + 1;

    Tetrominoe[] values = Tetrominoe.values();
    return values[x];
  }

}
