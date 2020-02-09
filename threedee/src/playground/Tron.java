package playground;

import engine.GameObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Tron extends engine.Game {
    private List<GameObject> world;
    Tron(){
        world = new ArrayList<>();
        world.add(new Ground());
    }

    @Override
    public Collection<GameObject> getGameObjects() {
        return world;
    }
}
