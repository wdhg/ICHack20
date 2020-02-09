package engine;

import com.google.gson.JsonObject;

public class Line implements Plottable {
    private Point start;
    private Point end;
    public Line(Point a, Point b){
        this.start = a;
        this.end = b;
    }
    public Line(double x1, double y1, double x2, double y2){
        this.start = new Point(x1,y1);
        this.end = new Point(x2,y2);
    }

    public void setXY(double x1, double y1, double x2, double y2){
        this.start = new Point(x1,y1);
        this.end = new Point(x2,y2);
    }

    public Point getStart(){
        return start;
    }


    @Override
    public JsonObject toJson() {
        //TODO: generify
        JsonObject json = new JsonObject();
        json.addProperty("x1",start.getX());
        json.addProperty("y1", start.getY());
        json.addProperty("x2", end.getX());
        json.addProperty("y2", end.getY());
        return json;
    }
}
