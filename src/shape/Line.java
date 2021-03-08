package shape;

import utils.Point;

import java.awt.*;

public class Line extends Ray {


    public Line() {

    }

    public Line(Point startPoint, Point endPoint, int frameWidth, Color frameColor) {
        super(startPoint, endPoint, frameWidth, frameColor);
    }


    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(super.getFrameColor());
        super.draw(graphics);
        Point theCenter = location();
        Point endPoint = getEndPoint();
        setEndPoint(new Point(2*theCenter.x-endPoint.x, 2*theCenter.y-endPoint.y));
        super.draw(graphics);
    }
}
