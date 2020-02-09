package floppySquare;

import engine.GameObject;
import engine.Line;
import engine.Plottable;
import engine.Point;

import java.security.PublicKey;
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

    public Point getTopLeft(){
        return new Point(centreX - sideLength / 2, centreY + sideLength / 2);
    }

    public Point getTopRight(){
        return new Point(centreX + sideLength / 2, centreY + sideLength / 2);
    }

    public Point getBottomLeft(){
        return new Point(centreX - sideLength / 2, centreY - sideLength / 2);
    }

    public Point getBottomRight(){
        return new Point(centreX + sideLength / 2, centreY - sideLength / 2);
    }

    @Override
    public List<Plottable> plot() {
        Line top = new Line(getTopLeft(), getTopRight());
        Line left = new Line(getTopLeft(), getBottomLeft());
        Line right = new Line(getTopRight(), getBottomRight());
        Line bottom = new Line(getBottomLeft(), getBottomRight());
        return new ArrayList<>(Arrays.asList(top, left, right, bottom));
    }

    @Override
    public void update(double timeDelta) {
        v += g * timeDelta;
        double s = v * timeDelta + 0.5 * g * timeDelta * timeDelta;
        centreY += s;
        if (centreY + sideLength / 2 > 1){
            centreY = 1 - sideLength / 2;
            v = 0;
        }
    }

    @Override
    public boolean isOut(){
        return centreY < -1;
    }

    @Override
    public String type() {
        return "Square";
    }
}
