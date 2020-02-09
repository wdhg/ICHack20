package floppySquare;

import engine.Renderer;
import pipe.Pipe;

import java.io.IOException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {
        FloppySquare fs = new FloppySquare();
        Pipe pipe = new Pipe();

        Renderer renderer = new Renderer(fs, pipe);
        renderer.start();

        while (true){
            Scanner scan=new Scanner(System.in);
            scan.nextLine();
            fs.thrust();
        }
    }

}
