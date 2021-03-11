package shape;

import java.awt.*;

public class Ellipse extends Rectangle {

    public Ellipse() {

    }

    @Override
    public void draw(Graphics2D graphics) {
        graphics.setStroke(super.getFrameWidth());
        graphics.setColor(super.getFrameColor());
        graphics.drawOval(this.getTopLeftCorner().x, this.getTopLeftCorner().y,
                this.getBottomRightCorner().x - this.getTopLeftCorner().x,
                this.getBottomRightCorner().y - this.getTopLeftCorner().y);

        graphics.setColor(super.getFillColor());
        graphics.fillOval(this.getTopLeftCorner().x, this.getTopLeftCorner().y,
                this.getBottomRightCorner().x - this.getTopLeftCorner().x,
                this.getBottomRightCorner().y - this.getTopLeftCorner().y);
    }
}
