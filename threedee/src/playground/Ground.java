package playground;

import engine.GameObject;
import engine.Line;
import engine.Plottable;

import java.util.ArrayList;
import java.util.List;

public class Ground extends GameObject {
    private final double horizonSpeed = -0.3;
    private final double topLen = 1;
    private final double bottomLen = 2;
    private final int numVerticals = 10;
    private final int numHorizontals = 10;


    private List<Line> verticals;
    private List<Line> horizontals;

    Ground(){
        verticals = new ArrayList<>();

        double horizonXOffset = -0.5;
        double horizonY = 0;
        double bottomY = -1;
        for (int i = 0; i < numVerticals; i++) {
            double vertXHorizon = horizonXOffset + i * (topLen / (numVerticals - 1));
            double vertXBottom = i * (bottomLen / (numVerticals - 1));
            verticals.add(new Line(vertXHorizon, horizonY, vertXBottom, bottomY));
        }

        drawHorizontals(-0.1);
    }

    private void drawHorizontals(double yOffset){
        horizontals = new ArrayList<>();
        double horizonYLimit = -0.9;
        double horizontalInterval = (yOffset - horizonYLimit) / numHorizontals;

        for (int i = 0; i < numHorizontals; i++) {
            double y = yOffset - horizontalInterval * i;
            double xBegin = yOffset - i*horizontalInterval;
            double xEnd = -xBegin;
            horizontals.add(new Line(xBegin,y,xEnd,y));
        }
    }

    @Override
    public void update(double timeDelta){
        double curTopY = horizontals.get(0).getStart().getY();
        if (curTopY + timeDelta * horizonSpeed < -0.3){
            drawHorizontals(-0.1);
        } else {
            drawHorizontals(curTopY);
        }
    }

    @Override
    public List<Plottable> plot() {
        List<Plottable> ret = new ArrayList<>();
        ret.addAll(horizontals);
        ret.addAll(verticals);
        return ret;
    }
}
