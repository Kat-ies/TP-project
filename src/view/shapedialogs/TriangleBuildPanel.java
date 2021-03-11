package view.shapedialogs;

import shape.Shape;
import shape.Triangle;
import utils.Point;
import view.DataValidateException;
import view.PointPickerPanel;

public class TriangleBuildPanel extends ShapeBuildPanel {

    private PointPickerPanel firstPointChooser;
    private PointPickerPanel secondPointChooser;
    private PointPickerPanel thirdPointChooser;

    @Override
    public void setupControls() {
        super.setupControls();

        firstPointChooser = new PointPickerPanel();
        firstPointChooser.setPoint(new Point(1, 50));
        addField("First point:", firstPointChooser);

        secondPointChooser = new PointPickerPanel();
        secondPointChooser.setPoint(new Point(100, 1));
        addField("Second point:", secondPointChooser);

        thirdPointChooser = new PointPickerPanel();
        thirdPointChooser.setPoint(new Point(1, 100));
        addField("Third point:", thirdPointChooser);
    }

    @Override
    protected void setupShape(Shape shape) throws DataValidateException {
        super.setupShape(shape);
        Triangle triangle = (Triangle)shape;
        triangle.setPoints(firstPointChooser.getPoint(), secondPointChooser.getPoint(),
                thirdPointChooser.getPoint());
    }

    @Override
    protected Shape createShape() {
        return new Triangle();
    }
}
