package shape;

import utils.Point;

import java.awt.*;

public class Segment extends Shape {

    private Point startPoint;
    private Point endPoint;

    public Segment() {

    }

    public Segment(Point startPoint, Point endPoint, int frameWidth, Color frameColor) {
        super(frameWidth, frameColor);
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public Point getStartPoint() { return startPoint; }

    public void setStartPoint(Point startPoint) { this.startPoint = startPoint; }

    public Point getEndPoint() { return endPoint; }

    public void setEndPoint(Point endPoint) { this.endPoint = endPoint; }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(super.getFrameColor());
        graphics.drawLine(startPoint.x, startPoint.y, endPoint.x, endPoint.y);
    }

    @Override
    public Point location() {
        Point center = new Point();
        center.x = (this.startPoint.x + this.endPoint.x)/2;
        center.y = (this.startPoint.y + this.endPoint.y)/2;
        return center;
    }

    @Override
    public void move(Point point) {
        Point center = location();
        int deltaX = Math.abs(center.x - startPoint.x);
        int deltaY = Math.abs(center.y - startPoint.y);

        this.startPoint = new Point(point.x - deltaX, point.y - deltaY);
        this.endPoint = new Point(point.x + deltaX, point.y + deltaY);
    }
}
