import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.Timer;

public class Board extends Renderer {

  private Tetrominoe[][] board;
  private final int BOARD_WIDTH = 10;
  private final int BOARD_HEIGHT = 10;
  private boolean isFallingFinished = false;
  private boolean isPaused = false;
  private boolean gameOver = false;
  private int numLinesRemoved = 0;
  private TetrisShape curPiece;
  private ArrayList<Vector2> vertices;
  private ArrayList<Integer> edges;

  public Board() {
    this.board = new Tetrominoe[BOARD_HEIGHT][BOARD_WIDTH];
    this.curPiece = new TetrisShape();
    initBoard();
  }

  private void initBoard() {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        board[i][j] = Tetrominoe.NoShape;
      }
    }
  }

  private void createVerticesAndEdges() {
    int counter = 0;
    vertices = new ArrayList<>();
    edges = new ArrayList<>();
    for (int i = 0; i < BOARD_HEIGHT; i++) {
      for (int j = 0; j < BOARD_WIDTH; j++) {
        if (board[i][j] != Tetrominoe.NoShape) {
          double topLeftX = ((double) j - 5) / 5;
          double topLeftY = -((double) i - 5) / 5;
          vertices.add(new Vector2(topLeftX, topLeftY));
          vertices.add(new Vector2(topLeftX + 0.2, topLeftY));
          vertices.add(new Vector2(topLeftX + 0.2, topLeftY - 0.2));
          vertices.add(new Vector2(topLeftX, topLeftY - 0.2));
          int n = counter;
          // 1 to 2
          edges.add(counter, ++counter);
          // 2 to 3
          edges.add(counter, ++counter);
          // 3 to 4
          edges.add(counter, ++counter);
          // 4 to 1
          edges.add(counter, n);
          counter++;
        }
      }
    }
    render(vertices, edges);
  }

  private int maxY() {
    int maxY = curPiece.ys[0];
    for (int i = 0; i < 4; i++) {
      maxY = Math.max(maxY, curPiece.ys[i]);
    }
    return maxY;
  }


  public void start() throws InterruptedException {
    curPiece = new TetrisShape();
    for (int i = 0; i < 4; i++) {
      board[curPiece.ys[i]][curPiece.xs[i]] = curPiece.getShape();
    }
    createVerticesAndEdges();
    while (!gameOver){
      Thread.sleep(1000);
      update();
    }
  }

  private void pause() {
    isPaused = !isPaused;
  }

  private void dropDown() {
    while (maxY() < BOARD_HEIGHT) {
      if (!tryMove(curPiece, 0, 1)) {
        break;
      }
    }
    pieceDropped();
  }

  private void oneLineDown() {
    if (!tryMove(curPiece, 0, 1)) {
      pieceDropped();
    }
  }

  private void pieceDropped() {
    if (maxY() == BOARD_HEIGHT - 1) {
      isFallingFinished = true;
    }
  }

  private void newPiece() {
    curPiece = new TetrisShape();
  }

  private boolean tryMove(TetrisShape newPiece, int deltaX, int deltaY) {
    for (int i = 0; i < 4; i++) {
      int x = deltaX + newPiece.xs[i];
      int y = deltaY - newPiece.ys[i];
      if (x < 0 || x >= BOARD_WIDTH || y < 0 || y >= BOARD_HEIGHT) {
        return false;
      }
      if (board[y][x] != Tetrominoe.NoShape) {
        return false;
      }
    }
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 4; j++) {
        int currX = curPiece.xs[i];
        int currY = curPiece.ys[j];
        board[currY][currX] = Tetrominoe.NoShape;
        board[currY + deltaY][currX + deltaX] = curPiece.getShape();
        curPiece.xs[i] = currX + deltaX;
        curPiece.ys[i] = currY + deltaY;
      }
    }
    removeFullLines();
    return true;
  }

  private void removeFullLines() {
    int numFullLines = 0;
    for (int i = BOARD_HEIGHT - 1; i >= 0; i--) {
      boolean lineIsFull = true;
      for (int j = 0; j < BOARD_WIDTH; j++) {
        if (board[i][j] == Tetrominoe.NoShape) {
          lineIsFull = false;
          break;
        }
      }
      if (lineIsFull) {
        numFullLines++;
        for (int j = 0; j < BOARD_WIDTH; j++) {
          board[i][j] = Tetrominoe.NoShape;
        }
      }
    }
    if (numFullLines > 0) {
      numLinesRemoved += numFullLines;
      isFallingFinished = true;
    }
  }

  private void update() {
    Scanner scn = new Scanner(System.in);
    char input = scn.nextLine().charAt(0);
    if (!curPiece.getShape().equals(Tetrominoe.NoShape)) {
      switch (input) {
        case 'p':
          pause();
          break;
        case 'a':
          tryMove(curPiece, -1, 0);
          break;
        case 'd':
          tryMove(curPiece, 1, 0);
          break;
        case 's':
          dropDown();
          break;
        case 'q':
          tryMove(curPiece.rotateLeft(), curPiece.xs[0], curPiece.ys[0]);
          break;
        case 'e':
          tryMove(curPiece.rotateRight(), curPiece.xs[0], curPiece.ys[0]);
          break;
      }

      if (isPaused) {
        return;
      }
      if (isFallingFinished) {
        isFallingFinished = false;
        newPiece();
      } else {
        oneLineDown();
      }
      createVerticesAndEdges();
    }
  }
}