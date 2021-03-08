package shape;

import utils.Point;

import java.awt.*;

public class Rectangle extends Shape {

    private Point bottomRightCorner;
    private Point topLeftCorner;
    public Rectangle() {

    }

    public Rectangle(Point topLeftCorner, Point bottomRightCorner) {
        this.bottomRightCorner = bottomRightCorner;
        this.topLeftCorner = topLeftCorner;
    }


    public Rectangle(Point topLeftCorner, Point bottomRightCorner, int frameWidth, Color frameColor,
                     Color fillColor) {
        super(frameWidth, frameColor, fillColor);
        this.bottomRightCorner = bottomRightCorner;
        this.topLeftCorner = topLeftCorner;
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(super.getFrameColor());

        //drawRect(int x, int y, int width, int height)
        graphics.drawRect(this.topLeftCorner.x, this.topLeftCorner.y,
                this.bottomRightCorner.x - this.topLeftCorner.x,
                this.bottomRightCorner.y - this.topLeftCorner.y);

        graphics.setColor(super.getFillColor());
        graphics.fillRect(this.topLeftCorner.x, this.topLeftCorner.y,
                this.bottomRightCorner.x - this.topLeftCorner.x,
                this.bottomRightCorner.y - this.topLeftCorner.y);
    }

    public Point getBottomRightCorner() {
        return this.bottomRightCorner;
    }

    public Point getTopLeftCorner() {
        return this.bottomRightCorner;
    }

    public void setBottomRightCorner(Point point) { this.bottomRightCorner = point; }

    public void setTopLeftCorner(Point point) { this.topLeftCorner = point; }

    @Override
    public Point location() {
        Point center = new Point();
        center.x = (this.bottomRightCorner.x + this.topLeftCorner.x)/2;
        center.y = (this.bottomRightCorner.y + this.topLeftCorner.y)/2;
        return center;
    }

    @Override
    public void move(Point point) {
        //we set new center point position
        Point center = location();
        int deltaX = Math.abs(this.bottomRightCorner.x - center.x);
        int deltaY = Math.abs(this.bottomRightCorner.y - center.y);

        this.topLeftCorner = new Point(point.x - deltaX, point.y - deltaY);
        this.bottomRightCorner = new Point(point.x + deltaX, point.y + deltaY);
    }

}
