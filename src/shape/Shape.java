package shape;

import utils.Point;

public interface Shape {

    public void draw();

    public Point location();

    public void move(Point point);

}