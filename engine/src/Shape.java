import java.util.ArrayList;
import java.util.List;

public class Shape {

  private ArrayList<Line> shape;

  public Shape(ArrayList<Line> shape){
    this.shape = shape;
  }

  private ArrayList<Line> projectPoints(ArrayList<Line3> lines){
    ArrayList<Line> projected = new ArrayList<>();
    for (Line3 line : lines){
      Vector3 first = line.getFirst();
      Vector3 second = line.getSecond();


    }
  }
}
