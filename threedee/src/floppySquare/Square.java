package floppySquare;

import engine.GameObject;
import engine.Line;
import engine.Plottable;
import engine.Point;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Square extends GameObject {
    private double centreX;
    private double centreY;
    private double sideLength = 0.2;
    private final double g = -0.3;
    private double v = 0;

    Square(){
        centreX = 0;
        centreY = 0;
    }

    void thrust(){
        v+=0.8;
    }

    @Override
    public List<Plottable> plot() {
        Point topLeft = new Point(centreX - sideLength / 2, centreY + sideLength / 2);
        Point topRight = new Point(centreX + sideLength / 2, centreY + sideLength / 2);
        Point bottomLeft = new Point(centreX - sideLength / 2, centreY - sideLength / 2);
        Point bottomRight = new Point(centreX + sideLength / 2, centreY - sideLength / 2);
        Line top = new Line(topLeft, topRight);
        Line left = new Line(topLeft, bottomLeft);
        Line right = new Line(topRight, bottomRight);
        Line bottom = new Line(bottomLeft, bottomRight);
        return new ArrayList<>(Arrays.asList(top, left, right, bottom));
    }

    @Override
    public void update(double timeDelta) {
        v += g * timeDelta;
        double s = v * timeDelta + 0.5 * g * timeDelta * timeDelta;
        centreY += s;
    }

    @Override
    public boolean isOut(){
        return centreY < -1;
    }
}
