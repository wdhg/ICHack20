package floppySquare;

import engine.GameObject;
import engine.Line;
import engine.Plottable;
import engine.Point;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pillar extends GameObject {
    private final double width = 0.2;
    private double centreX;
    private boolean isTop;
    private double height;
    private final double speed = 0.5;

    Pillar(double height, boolean isTop){
        this.isTop = isTop;
        this.height = height;
        this.centreX = 1;
    }


    @Override
    public List<Plottable> plot() {
        Point topLeft = new Point(centreX - width / 2, isTop ? 1: height-1);
        Point topRight = new Point(centreX + width / 2, isTop ? 1: height-1);
        Point bottomLeft = new Point(centreX - width / 2, isTop ? 1-height: -1);
        Point bottomRight = new Point(centreX + width / 2, isTop ? 1-height: -1);
        Line left = new Line(topLeft, bottomLeft);
        Line right = new Line(topRight, bottomRight);
        List<Plottable> ret =  new ArrayList<>(Arrays.asList(left, right));
        if (isTop){
            ret.add(new Line(bottomLeft, bottomRight));
        } else {
            ret.add(new Line(topRight, topLeft));
        }

        return ret;
    }

    @Override
    public void update(double timeDelta) {
        centreX -= timeDelta * speed;
    }

    @Override
    public boolean isOut() {
        return centreX + width < -0.8;
    }
}
