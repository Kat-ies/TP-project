package shape;

import utils.Point;

import java.awt.*;

public class Triangle extends Shape {

    private Point aPoint;
    private Point bPoint;
    private Point cPoint;

    public Triangle() {

    }

    public Triangle(Point aPoint, Point bPoint, Point cPoint,
                    int frameWidth, Color frameColor, Color fillColor) {
        super(frameWidth, frameColor, fillColor);
        this.aPoint = aPoint;
        this.bPoint = bPoint;
        this.cPoint = cPoint;
    }

    public Point getAPoint() { return aPoint; }

    public void setAPoint(Point aPoint) { this.aPoint = aPoint; }

    public Point getBPoint() { return bPoint; }

    public void setBPoint(Point bPoint) { this.bPoint = bPoint; }

    public Point getCPoint() { return cPoint; }

    public void setCPoint(Point cPoint) { this.cPoint = cPoint; }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(super.getFrameColor());
        //drawPolygon(int[] xPoints, int[] yPoints, int nPoints)
        graphics.drawPolygon(new int[] {aPoint.x, bPoint.x, cPoint.x},
                new int[] {aPoint.y, bPoint.y, cPoint.y}, 3);

        graphics.setColor(super.getFillColor());
        graphics.fillPolygon(new int[] {aPoint.x, bPoint.x, cPoint.x},
                new int[] {aPoint.y, bPoint.y, cPoint.y}, 3);
    }

    @Override
    public Point location() {
        Point center = new Point();
        center.x = (aPoint.x + bPoint.x + cPoint.x)/3;
        center.y = (aPoint.y + bPoint.y + cPoint.y)/3;
        return center;
    }

    @Override
    public void move(Point point) {
        Point oldCenter = location();

        int[] deltaForAPoint = new int[] {aPoint.x - oldCenter.x, aPoint.y - oldCenter.y};
        int[] deltaForBPoint = new int[] {bPoint.x - oldCenter.x, bPoint.y - oldCenter.y};
        int[] deltaForCPoint = new int[] {bPoint.x - oldCenter.x, cPoint.y - oldCenter.y};

        aPoint = new Point(point.x + deltaForAPoint[0], point.y + deltaForAPoint[1]);
        bPoint = new Point(point.x + deltaForBPoint[0], point.y + deltaForBPoint[1]);
        cPoint = new Point(point.x + deltaForCPoint[0], point.y + deltaForCPoint[1]);
    }
}
