import java.util.Arrays;

public class Rectangle extends Shape {

  public Rectangle(Vector2 position, double width, double height) {
    this.setVertices(
      Arrays.asList(
        position,                    // bottom left
        position.add(width, 0),      // bottom right
        position.add(width, height), // top right
        position.add(0, height)      // top left
      )
    );
    this.setEdgeData(Arrays.asList(0,1,1,2,2,3,3,4));
  }
}
