package engine;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import pipe.Pipe;

import java.io.IOException;
import java.util.List;

public class Renderer extends Thread{
    Game game;
    Pipe output;

    public Renderer(Game game, Pipe output){
        this.game = game;
        this.output = output;
    }

    public void run() {
        while (true){
            try {
                this.sleep(1000 / 30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            game.update(1.0/30);
            String jsonPlot = genPlot(game.renderAll());
            System.out.println(jsonPlot);

            try {
                output.send(jsonPlot);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String genPlot(List<Plottable> prims){
        //todo generify
        JsonArray lines = new JsonArray();
        for (Plottable p: prims){
            lines.add(p.toJson());
        }
        JsonObject frame = new JsonObject();
        frame.add("lines", lines);
        JsonObject root = new JsonObject();
        root.add("frame", frame);
        return root.toString();
    }
}
