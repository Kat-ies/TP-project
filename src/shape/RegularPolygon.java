package shape;

import utils.Point;

import java.util.ArrayList;

public class RegularPolygon extends Polygon {

    private Point center;
    private int radius;
    private int sidesNumber;

    public RegularPolygon() {
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getSidesNumber() {
        return sidesNumber;
    }

    public void setSidesNumber(int sidesNumber) {
        this.sidesNumber = sidesNumber;
    }

    public void setPolygonPoints(Point center, double radius, int sidesNumber) {
        ArrayList<Point> points = new ArrayList<Point>(sidesNumber + 1);
        double z;
        double angle = 360.0 / sidesNumber;

        if (sidesNumber % 2 != 0) {
            z = 90;
        } else {
            z = 90 - angle / 2;
        }

        for (int i = 0; i < sidesNumber; i++) {
            points.add(new Point(center.x + (int) (Math.cos(z / 180 * Math.PI) * radius),
                    center.y - (int) (Math.sin(z / 180 * Math.PI) * radius)));
            z = z + angle;
        }
        super.setPoints(points);
    }


    @Override
    public Point location() {
        return this.center;
    }
}
