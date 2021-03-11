package shape;

import model.ModelException;
import utils.Point;

import java.awt.*;
import java.util.List;
import java.util.Vector;

public class Polygon extends Shape {

    private List<Point> points;

    public Polygon() {

    }

    public List<Point> getPoints() {
        return points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }

    public void setPoints(int[] xPoints, int[] yPoints) {
        List<Point> points = new Vector<>();
        for (int i = 0; i < xPoints.length; i++) {
            points.add(new Point(xPoints[i], yPoints[i]));
        }
        setPoints(points);
    }

    @Override
    public void draw(Graphics2D graphics) {

        int[] xPoints = new int[points.size()];
        int[] yPoints = new int[points.size()];
        for (int i = 0; i < points.size(); i++) {
            xPoints[i] = points.get(i).x;
            yPoints[i] = points.get(i).y;
        }

        graphics.setStroke(super.getFrameWidth());
        graphics.setColor(super.getFrameColor());
        graphics.drawPolygon(xPoints, yPoints, points.size());

        graphics.setColor(super.getFillColor());
        graphics.fillPolygon(xPoints, yPoints, points.size());
    }


    @Override
    public Point location() {
        Point center = new Point();
        int sumX = 0;
        int sumY = 0;
        for (Point point : points) {
            sumX += point.x;
            sumY += point.y;
        }

        center.x = sumX / points.size();
        center.y = sumY / points.size();
        return center;
    }

    @Override
    public void move(Point point) {
        Point center = location();
        List<Point> newPoints = new Vector<>();

        for (int i = 0; i < points.size(); i++) {
            int newXPoint = points.get(i).x - center.x + point.x;
            int newYPoint = points.get(i).y - center.y + point.y;

            newPoints.add(new Point(newXPoint, newYPoint));
        }
        setPoints(newPoints);
    }

    @Override
    public void validate() throws ModelException {
        if (points.size() < 3) {
            throw new ModelException("You need more points to build polygon!");
        }

        for (int i = 0; i < points.size(); i++) {
            if (points.get(i).x < 0 || points.get(i).y < 0) {
                throw new ModelException("You have invalid point(-s)");
            }
        }

    }

}
