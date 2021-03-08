package shape;

import utils.Point;

import java.awt.*;

public class Ray extends Segment {

    public Ray() {

    }

    public Ray(Point startPoint, Point endPoint, int frameWidth, Color frameColor) {
        super(startPoint, endPoint, frameWidth, frameColor);
    }

    @Override
    public void setEndPoint(Point endPoint) {
        if(endPoint.x>0 && endPoint.x<Toolkit.getDefaultToolkit().getScreenSize().getWidth() &&
                endPoint.y>0 && endPoint.y<Toolkit.getDefaultToolkit().getScreenSize().getHeight())
            endPoint = getOutScreenPoint(endPoint);
        super.setEndPoint(endPoint);
    }

    public Point getOutScreenPoint(Point point) {
        Point theCenter = location();
        Point result;
        double deltaX = point.x - theCenter.x;
        double deltaY = point.y - theCenter.y;
        if (deltaX==0 && deltaY==0)
            return point;
        if (Math.abs(deltaX) < Math.abs(deltaY)) {
            double height;
            if (deltaY < 0)
                height = -1;
            else
                height = Toolkit.getDefaultToolkit().getScreenSize().getHeight() + 1;
            result =  new Point((int)(deltaX / deltaY * (height - theCenter.y) + theCenter.x), (int)height);
        } else {
            double width;
            if (deltaX < 0)
                width = -1;
            else
                width = Toolkit.getDefaultToolkit().getScreenSize().getWidth() + 1;
            result = new Point((int)(width), (int)(deltaY / deltaX * (width - theCenter.x) + theCenter.y));
        }
        return result;
    }
}
