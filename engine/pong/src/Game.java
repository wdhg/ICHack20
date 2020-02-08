import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.sun.java.accessibility.util.AWTEventMonitor.addKeyListener;


public class Game implements KeyListener, ActionListener {

    private int width, height, scorePlayer1, scorePlayer2;
    private Ball ball;
    private Paddle player1, player2;

    public Game(int width, int height) {
        this.width = width;
        this.height = height;
        this.ball = new Ball(this);
        this.player1 = new Paddle(this, KeyEvent.VK_UP, KeyEvent.VK_DOWN);
        this.player2 = new Paddle(this, KeyEvent.VK_W, KeyEvent.VK_S);
        this.scorePlayer1 = 0;
        this.scorePlayer2 = 0;
        addKeyListener(this);
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        player1.pressed(keyEvent.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        
    }
}
