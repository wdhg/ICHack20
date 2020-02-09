import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JFrame;

public class Main {
    private final static int WIDTH = 500, HEIGHT = 450;

    public static void main(String[] args) {
        Game game = new Game();
        Vertices vertices = new Vertices(game);
        new Render(vertices.vertices, vertices.edge);
    }
}