import java.util.Arrays;

public class Rectangle extends Shape {

  public Rectangle(Vector2 position, double width, double height) {
    this.setVertices(
      Arrays.asList(
        position,
        position.add(width, 0),
        position.add(width, height),
        position.add(0, height)
      )
    );
    this.setEdgeData(Arrays.asList(0,1,1,2,2,3,3,4));
  }
}
