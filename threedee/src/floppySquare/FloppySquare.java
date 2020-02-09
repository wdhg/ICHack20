package floppySquare;

import engine.Game;
import engine.GameObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class FloppySquare extends Game {
    private List<GameObject> world;
    private Square square;
    private Random rng;

    FloppySquare(){
        rng = new Random();
        world = new ArrayList<>();
        this.square = new Square();
        world.add(this.square);
    }

    void thrust(){
        square.thrust();
    }

    @Override
    public void update(double deltaTime) {
        for (int i = 0; i < world.size(); i++) {
            world.get(i).update(deltaTime);
            if (world.get(i).isOut()){
                world.remove(i);
            }
        }
        if (rng.nextInt(40) == 1){
            world.add(new Pillar(rng.nextDouble() * 0.6, rng.nextBoolean()));
        }
    }

    @Override
    public Collection<GameObject> getGameObjects() {
        return world;
    }
}
