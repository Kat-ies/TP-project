package shape;

import model.ModelException;
import utils.Point;

public class Circle extends Ellipse {

    int radius;

    public Circle() {

    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public void setRadius(Point topLeftCorner, Point bottomRightCorner) {
        this.radius = (int)Math.sqrt(Math.pow(topLeftCorner.x - bottomRightCorner.x,2) -
                Math.pow(topLeftCorner.y - bottomRightCorner.y,2));
    }

    @Override
    public Point location() {
        return getTopLeftCorner();
    }

    public void validate() throws ModelException {
        if (radius < 0){
            throw new ModelException("Invalid radius!");
        }
        if(getTopLeftCorner().x <0 || getTopLeftCorner().y < 0){
            throw new ModelException("Invalid center point!");
        }
        if(getBottomRightCorner().x <0 || getBottomRightCorner().y < 0){
            throw new ModelException("Invalid circle point!");
        }

        setBottomRightCorner(new Point(getTopLeftCorner().x + radius, getTopLeftCorner().y + radius));
    }
}
