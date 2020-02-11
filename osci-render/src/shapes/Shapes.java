package shapes;

import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.connectivity.ConnectivityInspector;
import org.jgrapht.alg.cycle.ChinesePostman;
import org.jgrapht.graph.AsSubgraph;
import org.jgrapht.graph.DefaultUndirectedWeightedGraph;
import org.jgrapht.graph.DefaultWeightedEdge;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Shapes {
  public static List<Shape> generateSquare(double x, double y, double sideLength) {
    List<Shape> lines = new ArrayList<>();

    lines.add(new Line(x, y, x + sideLength, y));
    lines.add(new Line(x + sideLength, y, x + sideLength, y - sideLength));
    lines.add(new Line(x + sideLength, y - sideLength, x, y - sideLength));
    lines.add(new Line(x, y - sideLength, x, y));

    return lines;
  }

  public static List<Shape> sortLines(List<Shape> shapes) {
    Graph<Point, DefaultWeightedEdge> graph = new DefaultUndirectedWeightedGraph<>(DefaultWeightedEdge.class);

    for (Shape shape : shapes) {
      Line line = (Line) shape;

      graph.addVertex(line.getA());
      graph.addVertex(line.getB());

      DefaultWeightedEdge edge = new DefaultWeightedEdge();
      graph.addEdge(line.getA(), line.getB(), edge);
      graph.setEdgeWeight(edge, line.length * line.weight);
    }

    ConnectivityInspector<Point, DefaultWeightedEdge> inspector = new ConnectivityInspector<>(graph);

    List<Shape> sortedLines = new ArrayList<>();

    for (Set<Point> vertices : inspector.connectedSets()) {
      AsSubgraph<Point, DefaultWeightedEdge> subgraph = new AsSubgraph<>(graph, vertices);

      ChinesePostman<Point, DefaultWeightedEdge> cp = new ChinesePostman<>();

      try {
        GraphPath<Point, DefaultWeightedEdge> edges = cp.getCPPSolution(subgraph);

        Point prevPoint = edges.getStartVertex();
        Point firstPoint = edges.getStartVertex();
        List<Point> path = edges.getVertexList();

        for (int i = 1; i < edges.getLength(); i++) {
          sortedLines.add(new Line(prevPoint, path.get(i)));
          prevPoint = path.get(i);
        }

        sortedLines.add(new Line(prevPoint, firstPoint));
      } catch (Exception e) {
        for (DefaultWeightedEdge edge : subgraph.edgeSet()) {
          sortedLines.add(new Line(subgraph.getEdgeSource(edge), subgraph.getEdgeTarget(edge)));
        }
      }
    }

    return sortedLines;
  }
}
