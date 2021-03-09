package view.shapedialogs;

import shape.Ray;
import shape.Shape;

public class RayBuildPanel extends SegmentBuildPanel {
    @Override
    protected Shape createShape() {
        return new Ray();
    }
}
