package shapes;

import java.util.ArrayList;
import java.util.List;

public class Square extends Shape {
  private List<Line> lines;

  public Square(Point topLeft, double sideLength) {
    lines = new ArrayList<>();

    lines.add(new Line(topLeft.getX(), topLeft.getY(), topLeft.getX() + sideLength, topLeft.getY()));
    lines.add(new Line(topLeft.getX() + sideLength, topLeft.getY(), topLeft.getX() + sideLength, topLeft.getY() + sideLength));
    lines.add(new Line(topLeft.getX() + sideLength, topLeft.getY() + sideLength, topLeft.getX(), topLeft.getY() + sideLength));
    lines.add(new Line(topLeft.getX(), topLeft.getY() + sideLength, topLeft.getX(), topLeft.getY()));

    calculateLength();
  }

  public Square(List<Line> lines) {
    this.lines = lines;

    calculateLength();
  }

  public Square(double x, double y, double sideLength) {
    this(new Point(x, y), sideLength);
  }

  private void calculateLength() {
    length = 0;

    for (Line line : lines) {
      length += line.length;
    }
  }

  @Override
  public Square scale(double factor) {
    return new Square(Line.scaleAll(lines, factor));
  }

  private Line getCurrentLine(double drawingProgress) {
    return lines.get((int) (drawingProgress * 4));
  }

  @Override
  public double nextX(double drawingProgress) {
    Line line = getCurrentLine(drawingProgress);

    return line.nextX(drawingProgress * 4 % 1);
  }

  @Override
  public double nextY(double drawingProgress) {
    Line line = getCurrentLine(drawingProgress);

    return line.nextY(drawingProgress * 4 % 1);
  }
}
