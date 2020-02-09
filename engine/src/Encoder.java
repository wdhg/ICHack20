import com.google.gson.*;

import java.util.ArrayList;
import java.util.List;

public class Encoder {
    private static List<double[]> genLines(List<Vector2> vertices, List<Integer> connections) {
        List<double[]> ret = new ArrayList<>();
        for (int i = 0; i < connections.size(); i += 2) {
            Vector2 start = vertices.get(connections.get(i));
            Vector2 end = vertices.get(connections.get(i+1));
            ret.add(new double[]{start.getX(), start.getY(), end.getX(), end.getY()});
        }
        return ret;
    }

    public static List<String> encode(List<Vector2> vertices, List<Integer> connections){
        List<double[]> lineCoords = genLines(vertices, connections);
        List<String> ret = new ArrayList<>();

        int offset = 0;
        int segmentSize = 300;

        for (int i = 0; i < lineCoords.size() / segmentSize; i++) {
            JsonArray lines = new JsonArray();
            for (int j = 0; j < segmentSize && j+offset < lineCoords.size(); j++) {
                JsonObject curLine = new JsonObject();
                double[] coords = lineCoords.get(j + offset);
                curLine.addProperty("x1", coords[0]);
                curLine.addProperty("y1", coords[1]);
                curLine.addProperty("x2", coords[2]);
                curLine.addProperty("y2",coords[3]);
                lines.add(curLine);
                offset += j;
            }

            JsonObject frame = new JsonObject();
            frame.add("lines", lines);

            JsonObject root = new JsonObject();
            root.add("frame", frame);
            ret.add(root.toString());
        }
        return ret;
    }
}
