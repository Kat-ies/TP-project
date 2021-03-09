package view.shapedialogs;

import shape.Line;
import shape.Shape;

public class LineBuildPanel extends RayBuildPanel {
    @Override
    protected Shape createShape() {
        return new Line();
    }
}
