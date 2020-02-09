import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Game extends JPanel implements ActionListener, KeyListener {
    private final static int WIDTH = 10, HEIGHT = 10;
    private Ball ball;
    private Paddle player1, player2;
    private double score1, score2;

    public Game() {
        setBackground(Color.WHITE);
        ball = new Ball(this);
        player1 = new Paddle(this, KeyEvent.VK_UP, KeyEvent.VK_DOWN, 0.7);
        player2 = new Paddle(this, KeyEvent.VK_W, KeyEvent.VK_S, 0.2);
        Timer timer = new Timer(5, this);
        timer.start();
        addKeyListener(this);
        setFocusable(true);
    }

    public Paddle getPlayer(int playerNo) {
        if (playerNo == 1)
            return player1;
        else
            return player2;
    }

    public void increaseScore(int playerNo) {
        if (playerNo == 1)
            score1++;
        else
            score2++;
    }

    public double getScore(int playerNo) {
        if (playerNo == 1)
            return score1;
        else
            return score2;
    }

    private void update() {
        ball.update();
        player1.update();
        player2.update();
    }

    public void actionPerformed(ActionEvent e) {
        update();
        repaint();
    }

    public void keyPressed(KeyEvent e) {
        player1.pressed(e.getKeyCode());
        player2.pressed(e.getKeyCode());
    }

    public void keyReleased(KeyEvent e) {
        player1.released(e.getKeyCode());
        player2.released(e.getKeyCode());
    }

    public void keyTyped(KeyEvent e) {
        ;
    }

    public Vector2 getBallPosition() {
        return ball.getPosition();
    }

    public Vector2 getPlayer1Position() {
        return player1.getPosition();
    }

    public Vector2 getPlayer2Position() {
        return player2.getPosition();
    }

}