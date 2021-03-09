package shape;

import utils.Point;

import java.awt.*;

public class Diamond extends Shape {

    private Point rightPoint;
    private Point topPoint;

    public Diamond() {

    }

    public Diamond(Point rightPoint, Point topPoint,int frameWidth, Color frameColor,
                   Color fillColor) {
        super(frameWidth, frameColor, fillColor);
        this.rightPoint = rightPoint;
        this.topPoint = topPoint;
    }

    public Point getRightPoint() { return rightPoint; }

    public void setRightPoint(Point rightPoint) { this.rightPoint = rightPoint; }

    public Point getTopPoint() { return topPoint; }

    public void setTopPoint(Point topPoint) { this.topPoint = topPoint; }

    @Override
    public void draw(Graphics graphics) {
        Point center = location();
        int deltaY = topPoint.y - center.y;
        int deltaX = rightPoint.x - center.x;

        Point bottomPoint = new Point(center.x, center.y - deltaY);
        Point leftPoint = new Point(center.x - deltaX, center.y);

        int[] xPoints = new int[] {topPoint.x, rightPoint.x, bottomPoint.x, leftPoint.x};
        int[] yPoints = new int[] {topPoint.y, rightPoint.y, bottomPoint.y, leftPoint.y};


        graphics.setColor(super.getFillColor());
        graphics.fillPolygon(xPoints, yPoints, 4);
        graphics.setColor(super.getFrameColor());
        graphics.drawPolygon(xPoints, yPoints, 4);
    }


    @Override
    public Point location() {
        Point center = new Point();
        center.x = topPoint.x;
        center.y = rightPoint.y;
        return  center;
    }

    @Override
    public void move(Point point) {
        Point center = location();
        int deltaY = topPoint.y - center.y;
        int deltaX = rightPoint.x - center.x;

        topPoint = new Point(point.x, point.y + deltaY);
        rightPoint = new Point(point.x + deltaX, point.y);
    }

}
