package view.shapedialogs;

import shape.Segment;
import shape.Shape;
import utils.Point;
import view.DataValidateException;
import view.PointPickerPanel;

public class SegmentBuildPanel extends ShapeBuildPanel {
    private PointPickerPanel startChooser;
    private PointPickerPanel endChooser;

    @Override
    public void setupControls() {
        super.setupControls();

        startChooser = new PointPickerPanel();
        startChooser.setPoint(new Point(1, 1));
        addField("Start:", startChooser);

        endChooser = new PointPickerPanel();
        endChooser.setPoint(new Point(100, 100));
        addField("End:", endChooser);
    }

    @Override
    protected void setupShape(Shape shape) throws DataValidateException {
        super.setupShape(shape);
        Segment segment = (Segment)shape;
        segment.setStartPoint(startChooser.getPoint());
        segment.setEndPoint(endChooser.getPoint());
    }

    @Override
    protected Shape createShape() {
        return new Segment();
    }
}
