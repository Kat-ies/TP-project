package shape;

import model.ModelException;
import utils.Point;

import java.awt.*;

public class Segment extends Shape {

    private Point startPoint;
    private Point endPoint;

    public Segment() {

    }

    public Point getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(Point startPoint) {
        this.startPoint = startPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(Point endPoint) {
        this.endPoint = endPoint;
    }

    @Override
    public void draw(Graphics2D graphics) {
        graphics.setColor(super.getFrameColor());
        graphics.setStroke(super.getFrameWidth());
        graphics.drawLine(startPoint.x, startPoint.y, endPoint.x, endPoint.y);
    }

    @Override
    public Point location() {
        return new Point((this.startPoint.x + this.endPoint.x) / 2,
                (this.startPoint.y + this.endPoint.y) / 2);
    }

    @Override
    public void move(Point point) {
        Point center = location();
        int deltaX = Math.abs(center.x - startPoint.x);
        int deltaY = Math.abs(center.y - startPoint.y);

        this.startPoint = new Point(point.x - deltaX, point.y - deltaY);
        this.endPoint = new Point(point.x + deltaX, point.y + deltaY);
    }

    @Override
    public void validate() throws ModelException {
        if (getEndPoint().x == getStartPoint().x && getEndPoint().y == getStartPoint().y) {
            throw new ModelException("Invalid points!");
        }

        if (getEndPoint().x < 0 || getEndPoint().y < 0 ||
                getStartPoint().x < 0 || getStartPoint().y < 0) {
            throw new ModelException("Invalid coordinates!");
        }
    }
}
