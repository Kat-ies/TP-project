package shape;

import utils.Point;

public class Circle extends Ellipse {


    public Circle() {

    }

    public void setPoints(Point center, int radius) {
        super.setTopLeftCorner(new Point(center.x - radius, center.y - radius));
        super.setBottomRightCorner(new Point(center.x + radius, center.y + radius));
    }
}
