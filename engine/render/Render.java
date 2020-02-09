import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class Render extends JPanel{

  private List<Vector2> vertices;
  private List<Integer> edges;

  public Render(List<Vector2> vertices, List<Integer> edges){
    this.vertices = vertices;
    this.edges = edges;
  }

  public static int convertToPixel(double coord){
    Double pixel = (coord + 1) * 250;
    return pixel.intValue();
  }

  @Override
  public void paint(Graphics g){
    Graphics2D g2d = (Graphics2D) g;
    String hexColor = "000000";
    g2d.setColor(Color.decode(hexColor));
    for (int i = 0; i < edges.size(); i += 2){
      int firstX = convertToPixel(vertices.get(edges.get(i)).getX());
      int firstY  = convertToPixel((-1) * vertices.get(edges.get(i)).getY());
      int secondX = convertToPixel(vertices.get(edges.get(i + 1)).getX());
      int secondY = convertToPixel((-1) * vertices.get(edges.get(i + 1)).getY());
      g2d.drawLine(firstX, firstY, secondX, secondY);
    }
  }

  public static void main(String[] args) {
    List<Vector2> cubeVertices = new ArrayList<>();
    cubeVertices.add(new Vector2(-1,-1));
    cubeVertices.add(new Vector2(-0.5,-1));
    List<Integer> cubeEdges = new ArrayList<>();
    cubeEdges.add(0);
    cubeEdges.add(1);

    JFrame f = new JFrame("Test");
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.getContentPane().add(new Render(cubeVertices, cubeEdges));
    f.setSize(500, 500);
    f.setLocation(0, 0);
    f.setVisible(true);
  }
}
