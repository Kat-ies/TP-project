package view.shapedialogs;

import shape.Rectangle;
import shape.Shape;
import view.DataValidateException;
import view.PointPickerPanel;
import utils.Point;

public class RectangleBuildPanel extends ShapeBuildPanel {
    private PointPickerPanel topLeftPointChooser;
    private PointPickerPanel bottomRightPointChooser;

    @Override
    protected void setupShape(Shape shape) throws DataValidateException {
        super.setupShape(shape);
        Rectangle rect = (Rectangle)shape;
        rect.setTopLeftCorner(topLeftPointChooser.getPoint());
        rect.setBottomRightCorner(bottomRightPointChooser.getPoint());
    }

    @Override
    public void setupControls() {
        super.setupControls();

        topLeftPointChooser = new PointPickerPanel();
        topLeftPointChooser.setPoint(new Point(1, 1));
        addField("Top-left point:", topLeftPointChooser);

        bottomRightPointChooser = new PointPickerPanel();
        bottomRightPointChooser.setPoint(new Point(100, 100));
        addField("Bottom-right point:", bottomRightPointChooser);
    }

    @Override
    protected Shape createShape() {
        return new Rectangle();
    }
}
