package shape;

import utils.Point;

public class Triangle extends Polygon {

    public Triangle() {

    }

    public void setPoints(Point aPoint, Point bPoint, Point cPoint) {
        int[] xPoints = new int[]{aPoint.x, bPoint.x, cPoint.x};
        int[] yPoints = new int[]{aPoint.y, bPoint.y, cPoint.y};

        super.setPoints(xPoints, yPoints);
    }
}
