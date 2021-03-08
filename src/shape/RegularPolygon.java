package shape;

import utils.Point;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class RegularPolygon extends Polygon {

    private Point center;
    private Point pointOnCircle;
    private int sidesNumber;

    public RegularPolygon() {

    }

    public RegularPolygon(Point center, Point pointOnCircle, int sidesNumber,
                          int frameWidth, Color frameColor, Color fillColor) {
        super(frameWidth, frameColor, fillColor);

        this.center = center;
        this.pointOnCircle = pointOnCircle;
        this.sidesNumber = sidesNumber;

        List<Point> points = getPolygonPoints(center, pointOnCircle, sidesNumber);
        super.setPoints(points);
    }

    public Point getCenter() { return center; }

    public void setCenter(Point center) { this.center = center; }

    public Point getPointOnCircle() { return pointOnCircle; }

    public void setPointOnCircle(Point pointOnCircle) { this.pointOnCircle = pointOnCircle; }

    public int getSidesNumber() { return sidesNumber; }

    public void setSidesNumber(int sidesNumber) { this.sidesNumber = sidesNumber; }

    private ArrayList<Point> getPolygonPoints(Point center, Point pointOnCircle, int sidesNumber) {
        ArrayList<Point> points = new ArrayList<Point>(sidesNumber + 1);
        double radius = Math.sqrt(Math.pow((pointOnCircle.x) - center.x, 2) + Math.pow(pointOnCircle.y - center.y, 2));
        double z;
        double angle = 360.0 / sidesNumber;

            if (sidesNumber % 2 != 0)
                z = 90;
            else
                z = 90 - angle / 2;

        for (int i = 0; i < sidesNumber; i++) {
            points.add(new Point(center.x + (int) (Math.cos(z / 180 * Math.PI) * radius),
                    center.y - (int) (Math.sin(z / 180 * Math.PI) * radius)));
            z = z + angle;
        }
        return points;
    }


    @Override
    public Point location() {
        return this.center;
    }

}
