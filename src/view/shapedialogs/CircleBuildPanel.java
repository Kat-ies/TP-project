package view.shapedialogs;

import shape.Circle;
import shape.Shape;

public class CircleBuildPanel extends EllipseBuildPanel {
    @Override
    protected Shape createShape() {
        return new Circle();
    }
}
