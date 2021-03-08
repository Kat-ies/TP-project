package shape;

import utils.Point;

import java.awt.*;

public class Circle extends Ellipse {

    public Circle() {

    }

    public Circle(Point topLeftCorner, Point bottomRightCorner,
                  int frameWidth, Color frameColor, Color fillColor){
        super(topLeftCorner, bottomRightCorner, frameWidth, frameColor, fillColor);
    }

}
