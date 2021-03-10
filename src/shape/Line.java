package shape;

import utils.Point;

import java.awt.*;

public class Line extends Ray {

    public Line() {

    }

    private void swapPoints() {
        Point tmp = getStartPoint();
        setStartPoint(getEndPoint());
        setEndPoint(tmp);
    }

    @Override
    public void draw(Graphics2D graphics) {
        super.draw(graphics);
        swapPoints();
        super.draw(graphics);
        swapPoints();
    }
}
