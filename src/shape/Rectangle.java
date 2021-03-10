package shape;

import model.ModelException;
import utils.Point;

import java.awt.*;

public class Rectangle extends Shape {

    private Point bottomRightCorner;
    private Point topLeftCorner;

    public Rectangle() {

    }

    @Override
    public void validate() throws ModelException {
        if (topLeftCorner.x > bottomRightCorner.x) {
            int tmp = topLeftCorner.x;
            topLeftCorner.x = bottomRightCorner.x;
            bottomRightCorner.x = tmp;
        }
        if (topLeftCorner.y > bottomRightCorner.y) {
            int tmp = topLeftCorner.y;
            topLeftCorner.y = bottomRightCorner.y;
            bottomRightCorner.y = tmp;
        }

        if (topLeftCorner.x < 0 || topLeftCorner.y < 0) {
            throw new ModelException("Invalid top left coordinate!");
        }

        if (bottomRightCorner.x < 0 || bottomRightCorner.y < 0) {
            throw new ModelException("Invalid bottom right coordinate!");
        }


    }

    @Override
    public void draw(Graphics2D graphics) {
        graphics.setStroke(super.getFrameWidth());
        graphics.setColor(super.getFillColor());
        graphics.fillRect(this.topLeftCorner.x, this.topLeftCorner.y,
                this.bottomRightCorner.x - this.topLeftCorner.x,
                this.bottomRightCorner.y - this.topLeftCorner.y);

        graphics.setColor(super.getFrameColor());
        graphics.drawRect(this.topLeftCorner.x, this.topLeftCorner.y,
                this.bottomRightCorner.x - this.topLeftCorner.x,
                this.bottomRightCorner.y - this.topLeftCorner.y);
    }

    public Point getBottomRightCorner() {
        return this.bottomRightCorner;
    }

    public Point getTopLeftCorner() {
        return this.topLeftCorner;
    }

    public void setBottomRightCorner(Point point) {
        this.bottomRightCorner = point;
    }

    public void setTopLeftCorner(Point point) {
        this.topLeftCorner = point;
    }

    @Override
    public Point location() {
        Point center = new Point();
        center.x = (this.bottomRightCorner.x + this.topLeftCorner.x) / 2;
        center.y = (this.bottomRightCorner.y + this.topLeftCorner.y) / 2;
        return center;
    }

    @Override
    public void move(Point point) {
        Point center = location();
        int deltaX = Math.abs(this.bottomRightCorner.x - center.x);
        int deltaY = Math.abs(this.bottomRightCorner.y - center.y);

        this.topLeftCorner = new Point(point.x - deltaX, point.y - deltaY);
        this.bottomRightCorner = new Point(point.x + deltaX, point.y + deltaY);
    }
}
