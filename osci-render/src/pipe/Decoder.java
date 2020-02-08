package pipe;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.*;
import shapes.Line;
import shapes.Shape;

import java.util.ArrayList;
import java.util.List;

public class Decoder {
    static List<Shape> decodeFrame(String json){
        JsonObject root = JsonParser.parseString(json).getAsJsonObject();
        JsonArray lines = root.getAsJsonObject("frame").getAsJsonArray("lines");
        List<Shape> ret = new ArrayList<>();

        for (JsonElement l: lines){
            JsonObject lineInfo = l.getAsJsonObject();
            ret.add(parseLine(lineInfo));
        }

        return ret;
    }

    private static Line parseLine(JsonObject lineObj){
        double x1 = lineObj.get("x1").getAsDouble();
        double y1 = lineObj.get("y1").getAsDouble();
        double x2 = lineObj.get("x2").getAsDouble();
        double y2 = lineObj.get("y2").getAsDouble();
        double weight = lineObj.get("weight").getAsDouble();
        if (weight == 0){
            return new Line(x1,y1,x2,y2);
        } else {
            return new Line(x1,y1,x2,y2,weight);
        }
    }
}
