import java.awt.Color;

import javax.swing.JFrame;

public class Main extends JFrame {
    private final static int WIDTH = 700, HEIGHT = 450;
    private Game panel;

    public Main() {
        setSize(WIDTH, HEIGHT);
        setTitle("Pong");
        setBackground(Color.WHITE);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel = new Game(this);
        add(panel);
    }

    public Game getPanel() {
        return panel;
    }

    public static void main(String[] args) {
        new Main();
    }
}