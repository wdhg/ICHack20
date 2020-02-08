package shapes;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultDirectedWeightedGraph;
import org.jgrapht.graph.DefaultWeightedEdge;

import java.util.ArrayList;
import java.util.List;

public class Shapes {
  public static List<Shape> generateSquare(double x, double y, double sideLength) {
    List<Shape> lines = new ArrayList<>();

    lines.add(new Line(x, y, x + sideLength, y));
    lines.add(new Line(x + sideLength, y, x + sideLength, y - sideLength));
    lines.add(new Line(x + sideLength, y - sideLength, x, y - sideLength));
    lines.add(new Line(x, y - sideLength, x, y));

    return lines;
  }

  public static List<Line> sortLines(List<Line> lines) {
    Graph<Point, DefaultWeightedEdge> graph = new DefaultDirectedWeightedGraph<>(DefaultWeightedEdge.class);

    for (Line line : lines) {
      graph.addVertex(line.getA());
      graph.addVertex(line.getB());
    }

    return null;
  }
}
