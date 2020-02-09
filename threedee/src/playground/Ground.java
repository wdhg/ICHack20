package playground;

import engine.GameObject;
import engine.Line;
import engine.Plottable;

import java.util.ArrayList;
import java.util.List;

public class Ground extends GameObject {
    private final double horizonSpeed = -0.3;
    private final double topLen = 0.6;
    private final double bottomLen = 2;
    private final int numVerticals = 10;
    private final int numHorizontals = 10;

    private double horizonYLimit = -0.9;
    private double horizontalInterval = (0 - horizonYLimit) / numHorizontals;

    private double horizontalXOffset = -0.6;


    private List<Line> verticals;
    private List<Line> horizontals;

    Ground(){
        verticals = new ArrayList<>();

        double horizonXOffset = -topLen/2;
        double horizonY = 0;
        double bottomY = -0.9;
        for (int i = 0; i < numVerticals; i++) {
            double vertXHorizon = horizonXOffset + i * (topLen / (numVerticals - 1));
            double vertXBottom = -1 + i * (bottomLen / (numVerticals - 1));
            verticals.add(new Line(vertXHorizon, horizonY, vertXBottom, bottomY));
        }

        drawHorizontals(-0.1);
    }

    private void drawHorizontals(double yOffset){
        horizontals = new ArrayList<>();

        for (int i = 0; i < numHorizontals; i++) {
            double y = yOffset - horizontalInterval * i;
            double xBegin = horizontalXOffset - i*horizontalInterval;
            double xEnd = -xBegin;
            horizontals.add(new Line(xBegin,y,xEnd,y));
        }
    }

    @Override
    public void update(double timeDelta){
        for (int i = 0; i < horizontals.size(); i++) {
            double oldY = horizontals.get(i).getStart().getY();
            double newY = oldY + timeDelta * horizonSpeed;
            if (newY < horizonYLimit + 0.1){
                horizontals.remove(i);
                continue;
            }
            double newXStart = horizontalXOffset - i*horizontalInterval;
            double newXEnd = -newXStart;
            horizontals.get(i).setXY(newXStart,newY, newXEnd, newY);
        }
        if (horizontals.get(0).getStart().getY() < -0.) {
            horizontals.add(0, new Line(horizontalXOffset,0,-horizontalXOffset,0));
        }
        /*
        double curTopY = horizontals.get(0).getStart().getY();
        if (curTopY + timeDelta * horizonSpeed < ){
            drawHorizontals(0);
        } else {
            drawHorizontals(curTopY + timeDelta * horizonSpeed);
        }

         */
    }

    @Override
    public boolean isOut() {
        return false;
    }

    @Override
    public String type() {
        return null;
    }

    @Override
    public List<Plottable> plot() {
        List<Plottable> ret = new ArrayList<>();
        ret.addAll(horizontals);
        ret.addAll(verticals);
        return ret;
    }
}
