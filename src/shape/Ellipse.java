package shape;

import utils.Point;

import java.awt.*;

public class Ellipse extends Rectangle {

    public Ellipse() {

    }

    public Ellipse(Point topLeftCorner, Point bottomRightCorner,
                   int frameWidth, Color frameColor, Color fillColor){
        super(topLeftCorner, bottomRightCorner, frameWidth, frameColor, fillColor);
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(super.getFrameColor());
        graphics.drawOval(this.getTopLeftCorner().x, this.getTopLeftCorner().y,
                this.getBottomRightCorner().x - this.getBottomRightCorner().x,
                this.getBottomRightCorner().y - this.getBottomRightCorner().y);

        graphics.setColor(super.getFillColor());
        graphics.fillOval(this.getTopLeftCorner().x, this.getTopLeftCorner().y,
                this.getBottomRightCorner().x - this.getBottomRightCorner().x,
                this.getBottomRightCorner().y - this.getBottomRightCorner().y);
    }
}
