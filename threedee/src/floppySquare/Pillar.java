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

    public Point getTopLeft(){
        return new Point(centreX - width / 2, isTop ? 1: height-1);
    }

    public Point getTopRight(){
        return new Point(centreX + width / 2, isTop ? 1: height-1);
    }

    public Point getBottomLeft(){
        return new Point(centreX - width / 2, isTop ? 1-height: -1);
    }

    public Point getBottomRight(){
        return new Point(centreX + width / 2, isTop ? 1-height: -1);
    }



    @Override
    public List<Plottable> plot() {
        Line left = new Line(getTopLeft(), getBottomLeft());
        Line right = new Line(getTopRight(), getBottomRight());
        List<Plottable> ret =  new ArrayList<>(Arrays.asList(left, right));
        if (isTop){
            ret.add(new Line(getBottomLeft(), getBottomRight()));
        } else {
            ret.add(new Line(getTopRight(), getTopLeft()));
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

    @Override
    public String type() {
        return "Pillar";
    }

    public boolean collided(Square sq){
        if (sq.getTopLeft().isRightOf(this.getTopRight())) {
            return false;
        }
        if (sq.getTopRight().isLeftOf(this.getTopLeft())) {
            return false;
        }
        if (sq.getBottomRight().isAbove(this.getTopRight())) {
            return false;
        }
        if (sq.getTopRight().isBelow(this.getBottomRight())) {
            return false;
        }
        return true;

    }
}
