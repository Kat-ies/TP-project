package view.shapedialogs;

import shape.Ellipse;
import shape.Shape;

public class EllipseBuildPanel extends RectangleBuildPanel {
    @Override
    protected Shape createShape() {
        return new Ellipse();
    }
}
