package shape;

import utils.Point;

public abstract class Shape {

    private String name;

    public String getName() {
        return null;
    }

    public void setName(String name) {

    }

    public abstract void draw();

    public abstract Point location();

    public abstract void move(Point point);

}
