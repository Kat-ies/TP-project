package shape;

import utils.Point;

public class Diamond extends Polygon {

    public Diamond() {

    }

    public void setPoints(Point rightPoint, Point topPoint) {
        Point center = new Point();
        center.x = Math.min(topPoint.x, rightPoint.x);
        center.y = Math.max(rightPoint.y, topPoint.y);

        if (topPoint.x > rightPoint.x) {
            int tmp = topPoint.x;
            topPoint.x = rightPoint.x;
            rightPoint.x = tmp;
        }
        if (topPoint.y > rightPoint.y) {
            int tmp = topPoint.y;
            topPoint.y = rightPoint.y;
            rightPoint.y = tmp;
        }


        int deltaY = topPoint.y - center.y;
        int deltaX = rightPoint.x - center.x;

        Point bottomPoint = new Point(center.x, center.y - deltaY);
        Point leftPoint = new Point(center.x - deltaX, center.y);

        int[] xPoints = new int[]{topPoint.x, rightPoint.x, bottomPoint.x, leftPoint.x};
        int[] yPoints = new int[]{topPoint.y, rightPoint.y, bottomPoint.y, leftPoint.y};

        super.setPoints(xPoints, yPoints);
    }
}
