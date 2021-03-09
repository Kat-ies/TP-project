package shape;

import model.ModelException;
import utils.Point;

import java.awt.*;

public class Circle extends Ellipse {

    public Circle() {

    }

    public Circle(Point topLeftCorner, Point bottomRightCorner,
                  int frameWidth, Color frameColor, Color fillColor) {
        super(topLeftCorner, bottomRightCorner, frameWidth, frameColor, fillColor);
    }

    public void validate() throws ModelException {
        int radius = Math.min(getBottomRightCorner().x - getTopLeftCorner().x,
                              getBottomRightCorner().y - getTopLeftCorner().y) / 2;
        Point center = location();
        setTopLeftCorner(new Point(center.x - radius, center.y - radius));
        setBottomRightCorner(new Point(center.x + radius, center.y + radius));
    }
}
