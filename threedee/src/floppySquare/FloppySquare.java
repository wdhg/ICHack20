package floppySquare;

import engine.Game;
import engine.GameObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class FloppySquare extends Game {
    private List<GameObject> world;
    private List<Pillar> pillars;
    private Square square;
    private Random rng;

    FloppySquare(){
        rng = new Random();
        pillars = new ArrayList<>();
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
            GameObject gobj = world.get(i);
            gobj.update(deltaTime);
            if (gobj.isOut()){
                world.remove(i);
                if (gobj.type().equals("Pillar")){
                    pillars.remove(gobj);
                }
            }
        }
        if (square.isOut()){
            System.exit(-1);
        }
        for (Pillar p:pillars){
            if (p.collided(square)){
                System.exit(-1);
            }
        }

        if (rng.nextInt(40) == 1){
            Pillar p = new Pillar(rng.nextDouble() * 0.6, rng.nextBoolean());
            world.add(p);
            pillars.add(p);
        }
    }

    @Override
    public Collection<GameObject> getGameObjects() {
        return world;
    }
}
