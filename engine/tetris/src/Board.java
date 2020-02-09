import static com.sun.java.accessibility.util.AWTEventMonitor.addKeyListener;

import java.util.ArrayList;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Board extends Renderer {

  private Tetrominoe[][] board;
  private final int BOARD_WIDTH = 10;
  private final int BOARD_HEIGHT = 10;
  private final int PERIOD_INTERVAL = 300;
  private Timer timer;
  private boolean isFallingFinished = false;
  private boolean isPaused = false;
  private int numLinesRemoved = 0;
  private TetrisShape curPiece;
  private ArrayList<Vector2> vertices;
  private ArrayList<Integer> edges;

  public Board() {
    this.board = new Tetrominoe[BOARD_HEIGHT][BOARD_WIDTH];
    this.curPiece = new TetrisShape();
    initBoard();
    addKeyListener(new TAdapter());
  }

  private void initBoard() {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board.length; j++) {
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
          double topLeftY = ((double) i + 5) / 5;
          vertices.add(new Vector2(topLeftX, topLeftY));
          vertices.add(new Vector2(topLeftX + 0.1, topLeftY));
          vertices.add(new Vector2(topLeftX + 0.1, topLeftY - 0.1));
          vertices.add(new Vector2(topLeftX, topLeftY - 0.1));
          int n = counter;
          // 1 to 2
          edges.add(counter, counter + 1);
          // 2 to 3
          edges.add(counter, counter + 1);
          // 3 to 4
          edges.add(counter, counter + 1);
          // 4 to 1
          edges.add(counter, n);
          counter++;
        }
      }
    }
  }

  private int maxY() {
    int maxY = curPiece.ys[0];
    for (int i = 0; i < 4; i++) {
      maxY = Math.max(maxY, curPiece.ys[i]);
    }
    return maxY;
  }

  private Tetrominoe shapeAt(int x, int y) {
    return board[y][x];
  }

  public void start() {
    curPiece = new TetrisShape();
    for (int i = 0; i < 4; i++) {
      board[curPiece.xs[i]][curPiece.ys[i]] = curPiece.getShape();
    }
    timer = new Timer(PERIOD_INTERVAL, new GameCycle());
    timer.start();
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
      if (shapeAt(x, y) != Tetrominoe.NoShape) {
        return false;
      }
    }
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 4; j++) {
        int currX = curPiece.xs[i];
        int currY = curPiece.ys[j];
        board[currX][currY] = Tetrominoe.NoShape;
        board[currX + deltaX][currY + deltaY] = curPiece.getShape();
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
        if (shapeAt(j, i) == Tetrominoe.NoShape) {
          lineIsFull = false;
          break;
        }
      }
      if (lineIsFull) {
        numFullLines++;
        for (int j = 0; j < BOARD_WIDTH; j++) {
          board[j][i] = Tetrominoe.NoShape;
        }
      }
    }
    if (numFullLines > 0) {
      numLinesRemoved += numFullLines;
      isFallingFinished = true;
    }
  }


  private class GameCycle implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
      doGameCycle();
    }
  }

  private void doGameCycle() {
    update();
  }

  private void update() {
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
    this.render(this.vertices, this.edges);
  }

  class TAdapter extends KeyAdapter {

    @Override
    public void keyPressed(KeyEvent e) {
      if (curPiece.getShape().equals(Tetrominoe.NoShape)) {
        return;
      }

      int keycode = e.getKeyCode();

      switch (keycode) {
        case KeyEvent.VK_P:
          pause();
          break;
        case KeyEvent.VK_LEFT:
          tryMove(curPiece, -1, 0);
          break;
        case KeyEvent.VK_RIGHT:
          tryMove(curPiece, 1, 0);
          break;
        case KeyEvent.VK_DOWN:
          dropDown();
          break;
        case KeyEvent.VK_Q:
          tryMove(curPiece.rotateLeft(), curPiece.xs[0], curPiece.ys[0]);
          break;
        case KeyEvent.VK_E:
          tryMove(curPiece.rotateRight(), curPiece.xs[0], curPiece.ys[0]);
          break;
      }
    }
  }
}