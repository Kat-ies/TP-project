package view.shapedialogs;

import shape.Rectangle;
import shape.Shape;
import view.DataValidateException;
import view.PointPanel;
import utils.Point;

public class RectangleBuildPanel extends ShapeBuildPanel {
    private PointPanel topLeftPointChooser;
    private PointPanel bottomRightPointChooser;

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

        topLeftPointChooser = new PointPanel();
        topLeftPointChooser.setPoint(new Point(1, 1));
        addField("Top-left point:", topLeftPointChooser);

        bottomRightPointChooser = new PointPanel();
        bottomRightPointChooser.setPoint(new Point(100, 100));
        addField("Bottom-right point:", bottomRightPointChooser);
    }

    @Override
    protected Shape createShape() {
        return new Rectangle();
    }
}
