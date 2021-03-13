package shape;

import utils.Point;

import java.awt.*;

public class Ray extends Segment {

    public Ray() {

    }


    private Point getRealEndPoint(Point endPoint) {
        if (endPoint.x > 0 && endPoint.x < Toolkit.getDefaultToolkit().getScreenSize().getWidth() &&
                endPoint.y > 0 && endPoint.y < Toolkit.getDefaultToolkit().getScreenSize().getHeight())
            endPoint = getOutScreenPoint(endPoint);
        return endPoint;
    }

    private Point getOutScreenPoint(Point point) {
        Point center = new Point();
        center.x = (point.x + super.getStartPoint().x) / 2;
        center.y = (point.y + super.getStartPoint().y) / 2;

        Point result;
        double deltaX = point.x - center.x;
        double deltaY = point.y - center.y;
        if (deltaX == 0 && deltaY == 0)
            return point;
        if (Math.abs(deltaX) < Math.abs(deltaY)) {
            double height;
            if (deltaY < 0)
                height = -1;
            else
                height = Toolkit.getDefaultToolkit().getScreenSize().getHeight() + 1;
            result = new Point((int) (deltaX / deltaY * (height - center.y) + center.x), (int) height);
        } else {
            double width;
            if (deltaX < 0)
                width = -1;
            else
                width = Toolkit.getDefaultToolkit().getScreenSize().getWidth() + 1;
            result = new Point((int) (width), (int) (deltaY / deltaX * (width - center.x) + center.y));
        }
        return result;
    }

    @Override
    public void move(Point point) {

        int deltaX = super.getStartPoint().x - point.x;
        int deltaY = super.getStartPoint().y - point.y;

        super.setStartPoint(point);
        super.setEndPoint(new Point(super.getEndPoint().x - deltaX,
                super.getEndPoint().y - deltaY));

    }

    @Override
    public void draw(Graphics2D graphics) {
        graphics.setColor(super.getFrameColor());
        graphics.setStroke(super.getFrameWidth());

        Point startPoint = super.getStartPoint();
        Point endPoint = getRealEndPoint(super.getEndPoint());
        graphics.drawLine(startPoint.x, startPoint.y, endPoint.x, endPoint.y);
    }
}
