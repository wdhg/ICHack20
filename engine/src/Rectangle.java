import java.util.Arrays;

public class Rectangle extends Shape {

  private Vector2 position;
  private double width, height;

  public Rectangle(Vector2 position, double width, double height) {
    this.position = position;
    this.width = width;
    this.height = height;

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

  public Vector2 getPosition() {
    return position;
  }

  public double getHeight() {
    return height;
  }

  public double getWidth() {
    return width;
  }

}
