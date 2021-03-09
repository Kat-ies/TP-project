package view.shapedialogs;

import shape.Diamond;
import shape.Shape;
import shape.Triangle;
import utils.Point;
import view.DataValidateException;
import view.PointPanel;

public class TriangleBuildPanel extends ShapeBuildPanel {

    private PointPanel firstPointChooser;
    private PointPanel secondPointChooser;
    private PointPanel thirdPointChooser;

    @Override
    public void setupControls() {
        super.setupControls();

        firstPointChooser = new PointPanel();
        firstPointChooser.setPoint(new Point(1, 50));
        addField("First point:", firstPointChooser);

        secondPointChooser = new PointPanel();
        secondPointChooser.setPoint(new Point(100, 1));
        addField("Second point:", secondPointChooser);

        thirdPointChooser = new PointPanel();
        thirdPointChooser.setPoint(new Point(100, 1));
        addField("Third point:", thirdPointChooser);
    }

    @Override
    protected void setupShape(Shape shape) throws DataValidateException {
        super.setupShape(shape);
        Triangle triangle = (Triangle)shape;
        triangle.setAPoint(firstPointChooser.getPoint());
        triangle.setBPoint(secondPointChooser.getPoint());
        triangle.setCPoint(thirdPointChooser.getPoint());
    }

    @Override
    protected Shape createShape() {
        return new Triangle();
    }
}
