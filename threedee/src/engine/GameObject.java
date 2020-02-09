package engine;

import java.util.ArrayList;
import java.util.List;

public abstract class GameObject {
    public abstract List<Plottable> plot();
    public abstract void update(double timeDelta);
    public abstract boolean isOut();
}
