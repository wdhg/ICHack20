package engine;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class Game {
    public abstract Collection<GameObject> getGameObjects();

    public void update(double deltaTime) {
        for (GameObject g : getGameObjects()) {
            g.update(deltaTime);
        }
    }

    public List<Plottable> renderAll(){
        List<Plottable> ret = new ArrayList<>();
        for (GameObject g : getGameObjects()) {
            ret.addAll(g.plot());
        }
        return ret;
    }
}

