import java.util.ArrayList;
import java.util.stream.Stream;

public class Shape {

    public ArrayList<Vector2> normalise(ArrayList<Vector2> points, double minBound, double maxBound) {
        ArrayList<Vector2> normalisedPoints = new ArrayList<>();
        for (Vector2 point : points) {
            double x = point.getX();
            double y = point.getY();
            double newX = (maxBound - minBound) *
                    (x - getMinX(points.stream()) / (getMaxX(points.stream()) - getMinX(points.stream()))) + minBound;
            double newY = (maxBound - minBound) *
                    (y - getMinY(points.stream()) / (getMaxY(points.stream()) - getMinY(points.stream()))) + minBound;

            normalisedPoints.add(new Vector2(newX, newY));
        }
        return normalisedPoints;
    }

    private double getMaxX(Stream<Vector2> points) {
        return points
                .map(Vector2::getX)
                .reduce(0.0, Math::max);
    }

    private double getMinX(Stream<Vector2> points) {
        return points
                .map(Vector2::getX)
                .reduce(0.0, Math::min);
    }

    private double getMaxY(Stream<Vector2> points) {
        return points
                .map(Vector2::getY)
                .reduce(0.0, Math::max);
    }

    private double getMinY(Stream<Vector2> points) {
        return points
                .map(Vector2::getY)
                .reduce(0.0, Math::min);
    }
}
