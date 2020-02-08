import com.google.gson.*;

import java.util.List;

public class Encoder {
    public static String encode(List<Vector2> vertices, int[] connections){
        JsonArray lines = new JsonArray();
        for (int i = 0; i < connections.length; i+=2) {
            Vector2 start = vertices.get(connections[i]);
            Vector2 end = vertices.get(connections[i+1]);
            double x1 = start.getX();
            double y1 = start.getY();
            double x2 = end.getX();
            double y2 = end.getY();

            JsonObject curLine = new JsonObject();
            curLine.addProperty("x1", x1);
            curLine.addProperty("y1", y1);
            curLine.addProperty("x2", x2);
            curLine.addProperty("y2",y2);

            lines.add(curLine);
        }

        JsonObject frame = new JsonObject();
        frame.add("lines", lines);

        JsonObject root = new JsonObject();
        root.add("frame", frame);
        return root.getAsString();
    }
}
