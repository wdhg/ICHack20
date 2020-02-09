package playground;

import engine.Renderer;
import pipe.Pipe;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Tron tron = new Tron();
        Pipe pipe = new Pipe();

        Renderer renderer = new Renderer(tron, pipe);
        renderer.start();
    }
}
